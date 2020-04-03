package com.github.alan2lin;

import com.github.alan2lin.runtime.DefaultFsmFramework;
import com.github.alan2lin.runtime.intf.FsmFramework;
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
