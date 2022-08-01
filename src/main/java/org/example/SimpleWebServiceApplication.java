package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SimpleWebServiceApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimpleWebServiceApplication.class, args);
    }

    @GetMapping
    public String helloWorld() {
        String host;
        try {
            host = InetAddress.getLocalHost().getHostName();
            System.out.println("Host: " + host);
        } catch (UnknownHostException e) {
            host = "UNKNOWN";
            System.out.println("Error getting hostname.");
        }
        return "Hello World from host: " + host;
    }

    @GetMapping(path = "/info")
    public String info() {
        return "Insert you info here.";
    }

    @Override
    public void run(final ApplicationArguments args) {
        final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);

        executor.scheduleAtFixedRate(printHelloWorld(), 0, 1L, TimeUnit.SECONDS);
    }

    private Runnable printHelloWorld() {
        return () -> System.out.println("Hello World.");
    }
}
