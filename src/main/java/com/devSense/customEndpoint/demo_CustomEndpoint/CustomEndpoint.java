package com.devSense.customEndpoint.demo_CustomEndpoint;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom-endpoint1")
public class CustomEndpoint {

    @ReadOperation
    public String ReadMessage() {
        return "Hello from CustomEndpoint";
    }

    @WriteOperation
    public String WriteMessage(String msg) {
        return "Hello " + msg + "!";
    }


    @DeleteOperation
    public String DeleteMessage() {
        return "Delete Message performed!";
    }
}
