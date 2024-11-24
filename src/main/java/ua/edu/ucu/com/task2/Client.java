package ua.edu.ucu.com.task2;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {

    // private int counter;

    // private final int id counter++;

    private static AtomicInteger counter = new AtomicInteger();
    private final int id = counter.incrementAndGet();
    private String name;
    private String email;
    private int age;
    private String sex;

}
