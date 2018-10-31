package sems.eearchitecturalprototype.server;

import java.util.ArrayList;
import java.util.List;

import sems.eearchitecturalprototype.common.IClient;
import sems.eearchitecturalprototype.common.IResponse;
import sems.eearchitecturalprototype.common.IServer;

public class Server implements IServer {

    private final List<IClient> clients;
    private IDynamicDutyCycleCalculator calculator;

    public Server() {
        clients = new ArrayList();
        setDynamicDutyCycleCalculator(new DummyDynamicDutyCycleCalculator());
    }

    @Override
    public void register(IClient client) {
        clients.add(client);
    }

    @Override
    public void onSendResponse(IResponse response) {

    }

    public void sendRequest() {
        for (IClient client : clients) {
            client.onSendRequest(null);
        }
    }

    public void setDynamicDutyCycleCalculator(IDynamicDutyCycleCalculator calculator) {
        this.calculator = calculator;
    }

}
