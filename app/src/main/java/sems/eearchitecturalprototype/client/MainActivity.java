package sems.eearchitecturalprototype.client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import sems.eearchitecturalprototype.R;
import sems.eearchitecturalprototype.common.IClient;
import sems.eearchitecturalprototype.common.IDataPoint;
import sems.eearchitecturalprototype.common.IRequest;
import sems.eearchitecturalprototype.common.IServer;
import sems.eearchitecturalprototype.server.Server;

public class MainActivity extends AppCompatActivity implements IClient {

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
        dataPointBuffer = new ArrayList();
        dutyCycleInterval.set(1);

        setServer(new Server());
        setLocationSampler(new DummyLocationSampler());

        server.register(this);
    }

    @Override
    public boolean onSendRequest(IRequest request) {
        return true;
    }

    public void sendResponse() {
        server.onSendResponse(null);
    }

    public void startSampling() {
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                dataPointBuffer.add(locationSampler.sampleLocation());
            }
        }, 0, dutyCycleInterval.get(), TimeUnit.SECONDS);
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
