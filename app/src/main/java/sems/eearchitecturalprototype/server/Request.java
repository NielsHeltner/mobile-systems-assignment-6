package sems.eearchitecturalprototype.server;

import sems.eearchitecturalprototype.common.IRequest;

public class Request implements IRequest {

    private int dutyCycleInterval;

    public Request(int dutyCycleInterval) {
        this.dutyCycleInterval = dutyCycleInterval;
    }

    @Override
    public int getDutyCycleInterval() {
        return dutyCycleInterval;
    }

}
