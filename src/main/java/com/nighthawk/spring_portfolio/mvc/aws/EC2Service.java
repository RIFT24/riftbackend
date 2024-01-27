package com.nighthawk.spring_portfolio.mvc.aws;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;

import org.springframework.stereotype.Service;

@Service
public class EC2Service {

    private final AmazonEC2 ec2Client;

    public EC2Service() {
        // Initialize the EC2 Client
        this.ec2Client = AmazonEC2ClientBuilder.standard()
                            .withRegion("us-east-2") // Set your region
                            .build();
    }

    public DescribeInstancesResult describeInstances() {
        DescribeInstancesRequest request = new DescribeInstancesRequest();
        return ec2Client.describeInstances(request);
    }
}
