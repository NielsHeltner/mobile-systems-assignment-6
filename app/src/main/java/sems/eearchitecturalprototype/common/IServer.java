package sems.eearchitecturalprototype.common;

public interface IServer {

    void register(IClient client);

    void onSendResponse(IResponse response);

}
