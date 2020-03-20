package com.alan2lin;

import com.alan2lin.runtime.DefaultFsmFramework;
import com.alan2lin.runtime.intf.FsmFramework;
import org.apache.commons.cli.CommandLine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements  CommandLineRunner
{

    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(App.class);

        app.run(args);
        return;


    }

    @Override
    public void run(String... args) throws Exception {
        FsmFramework fsm =  DefaultFsmFramework.getInstance();
        //fsm.start();
    }
}
