package com.nighthawk.spring_portfolio.mvc.aws;

public class CommandRequest {
    private String instanceId;
    private String command;

    // Standard getters and setters
    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
