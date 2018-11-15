package sems.eearchitecturalprototype.common;

public interface IClient {

    /**
     * Method for receiving a request
     * @param request the request to process
     */
    void onSendRequest(IRequest request);

}
