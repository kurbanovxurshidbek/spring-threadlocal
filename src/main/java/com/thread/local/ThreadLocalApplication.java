package com.thread.local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

//https://www.baeldung.com/java-threadlocal

@SpringBootApplication
public class ThreadLocalApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(ThreadLocalApplication.class, args);

        testThreadLocalWithUserContext();
    }

    public static void testThreadLocalWithUserContext() throws ExecutionException, InterruptedException {
        //when
        ThreadLocalWithUserContext firstUser = new ThreadLocalWithUserContext(1);
        ThreadLocalWithUserContext secondUser = new ThreadLocalWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();

        Thread.sleep(3000);
    }

    public static void testSharedMapWithUserContext() throws ExecutionException, InterruptedException {
        //when
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();

        Thread.sleep(3000);
        //then
        System.out.println(SharedMapWithUserContext.userContextPerUserId.size());
    }


}
