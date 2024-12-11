package com.devSense.customEndpoint.demo_CustomEndpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "custom-endpoint")
public class MyCustomEndpoint {
    @ReadOperation
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        return data;
    }

    @WriteOperation
    public void sendData(Map<String, Object> data) {
        // Process the data
        System.out.println("Received data: " + data);
    }
}
