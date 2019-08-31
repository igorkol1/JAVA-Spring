package pl.coderslab.beans;

import java.time.LocalDateTime;

public class HelloWorld {

    private String message;

    public HelloWorld() {
    }

    public void hello(){
        System.out.println(LocalDateTime.now());
    }
}
