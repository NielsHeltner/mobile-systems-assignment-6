package sems.eearchitecturalprototype.client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import sems.eearchitecturalprototype.R;
import sems.eearchitecturalprototype.client.interfaces.ILocationSampler;
import sems.eearchitecturalprototype.common.IClient;
import sems.eearchitecturalprototype.common.IDataPoint;
import sems.eearchitecturalprototype.common.IRequest;
import sems.eearchitecturalprototype.common.IServer;
import sems.eearchitecturalprototype.server.Server;

public class MainActivity extends AppCompatActivity implements IClient {

    public static final int RESPONSE_THRESHOLD = 5;

    private IServer server;
    private ILocationSampler locationSampler;

    private ScheduledExecutorService executorService;

    private List<IDataPoint> dataPointBuffer;
    private AtomicInteger dutyCycleInterval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        dataPointBuffer = Collections.synchronizedList(new ArrayList());
        dutyCycleInterval = new AtomicInteger(server.DEFAULT_DUTY_CYCLE);

        setServer(new Server());
        setLocationSampler(new DummyLocationSampler());

        server.register(this);

        startSampling();
    }

    @Override
    public boolean onSendRequest(IRequest request) {
        Log.d(getString(R.string.app_name), "Received new request");
        if(dataPointBuffer.size() > RESPONSE_THRESHOLD) {
            Log.d(getString(R.string.app_name), "Handling request, new duty cycle " + request.getDutyCycleInterval());
            dutyCycleInterval.set(request.getDutyCycleInterval());
            sendResponse();
            dataPointBuffer.clear();
            return true;
        }
        else {
            return false;
        }
    }

    public void sendResponse() {
        server.onSendResponse(new Response(this, dataPointBuffer));
    }

    public void startSampling() {
        executorService.schedule(new Callable<Void>() {
            @Override
            public Void call() {
                Log.d(getString(R.string.app_name), "Sampling location");
                dataPointBuffer.add(locationSampler.sampleLocation());
                executorService.schedule(this, dutyCycleInterval.get(), TimeUnit.SECONDS);
                return null;
            }
        }, 0, TimeUnit.SECONDS);
    }

    /**
     * Method for dependency injection / late binding of a server
     *
     * @param server an implementation of the IServer interface
     */
    public void setServer(IServer server) {
        this.server = server;
    }

    /**
     * Method for dependency injection / late binding of a locationSampler
     *
     * @param locationSampler an implementation of the ILocationSampler interface
     */
    public void setLocationSampler(ILocationSampler locationSampler) {
        this.locationSampler = locationSampler;
    }

}
