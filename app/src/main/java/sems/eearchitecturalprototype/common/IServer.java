package sems.eearchitecturalprototype.common;

public interface IServer {

    /**
     * Initial value for the duty cycle interval
     */
    int DEFAULT_DUTY_CYCLE_SECONDS = 1;

    /**
     * Allows a client to register themselves at the server, to later be able to communicate through requests and responses
     * @param client the client that wants to register itself
     */
    void register(IClient client);

    /**
     * Method for receiving a response
     * @param response the response to be processed
     */
    void onSendResponse(IResponse response);

}
