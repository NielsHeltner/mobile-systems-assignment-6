package sems.eearchitecturalprototype.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import sems.eearchitecturalprototype.common.IClient;
import sems.eearchitecturalprototype.common.IResponse;
import sems.eearchitecturalprototype.common.IServer;
import sems.eearchitecturalprototype.server.interfaces.IDynamicDutyCycleCalculator;

public class Server implements IServer {

    private final List<IClient> clients;
    private final Map<IClient, Integer> dutyCycles;
    private IDynamicDutyCycleCalculator calculator;

    private ScheduledExecutorService executorService;

    public Server() {
        clients = new ArrayList();
        dutyCycles = new HashMap();

        executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

        setDynamicDutyCycleCalculator(new DummyDynamicDutyCycleCalculator());

        executorService.schedule(new Callable<Void>() {
            @Override
            public Void call() {
                sendRequest();
                executorService.schedule(this, (int) (Math.random() * 10) + 1, TimeUnit.SECONDS);
                return null;
            }
        }, 0, TimeUnit.SECONDS);
    }

    @Override
    public void register(IClient client) {
        clients.add(client);
    }

    @Override
    public void onSendResponse(IResponse response) {
        int newDutyCycle = calculator.calculateDutyCycle(response.getDataPoints());
        dutyCycles.put(response.getSender(), newDutyCycle);
    }

    public void sendRequest() {
        for (IClient client : clients) {
            client.onSendRequest(new Request(dutyCycles.getOrDefault(client, DEFAULT_DUTY_CYCLE_SECONDS)));
        }
    }

    /**
     * Method for dependency injection / late binding of a dynamicDutyCycleCalculator
     *
     * @param calculator an implementation of the IDynamicDutyCycleCalculator interface
     */
    public void setDynamicDutyCycleCalculator(IDynamicDutyCycleCalculator calculator) {
        this.calculator = calculator;
    }

}
