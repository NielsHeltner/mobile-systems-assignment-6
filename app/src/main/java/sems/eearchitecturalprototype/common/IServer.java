package sems.eearchitecturalprototype.common;

public interface IServer {

    int DEFAULT_DUTY_CYCLE = 1;

    void register(IClient client);

    void onSendResponse(IResponse response);

}
