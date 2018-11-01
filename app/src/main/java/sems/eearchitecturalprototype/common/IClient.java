package sems.eearchitecturalprototype.common;

public interface IClient {

    /**
     * Method for receiving a request
     * @param request the request to process
     * @return whether or not the request was accepted
     */
    boolean onSendRequest(IRequest request);

}
