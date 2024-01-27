package com.nighthawk.spring_portfolio.mvc.aws;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.*;
import java.util.Collections;


import org.springframework.stereotype.Service;

@Service
public class AwsCommandService {

    private final AWSSimpleSystemsManagement ssmClient;

    public AwsCommandService() {
        // Initialize the SSM client
        this.ssmClient = AWSSimpleSystemsManagementClientBuilder.standard()
                            .withRegion("us-east-2") // Set your region
                            .build();
    }

    public String runCommand(String instanceId, String command) {
        // Send the command
        SendCommandRequest sendCommandRequest = new SendCommandRequest()
            .withInstanceIds(instanceId)
            .withDocumentName("AWS-RunShellScript")
            .withParameters(Collections.singletonMap("commands", Collections.singletonList(command)));

        SendCommandResult sendCommandResult = ssmClient.sendCommand(sendCommandRequest);
        String commandId = sendCommandResult.getCommand().getCommandId();

        // Sleep to allow command to execute (Consider implementing a better wait mechanism)
        try {
            Thread.sleep(8000); // Adjust as needed
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Handle the exception
        }

        // Get command output
        GetCommandInvocationRequest getCommandInvocationRequest = new GetCommandInvocationRequest()
            .withCommandId(commandId)
            .withInstanceId(instanceId);
        GetCommandInvocationResult getCommandInvocationResult = ssmClient.getCommandInvocation(getCommandInvocationRequest);

        return getCommandInvocationResult.getStandardOutputContent();
    }
}
