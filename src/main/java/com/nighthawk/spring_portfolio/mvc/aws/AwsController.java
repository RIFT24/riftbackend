package com.nighthawk.spring_portfolio.mvc.aws;

import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.nighthawk.spring_portfolio.mvc.aws.AwsCommandService;
import com.nighthawk.spring_portfolio.mvc.aws.CommandRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aws")
public class AwsController {

    @Autowired
    private EC2Service ec2Service;

    @GetMapping("/instances")
    public DescribeInstancesResult describeInstances() {
        return ec2Service.describeInstances();
    }
}
