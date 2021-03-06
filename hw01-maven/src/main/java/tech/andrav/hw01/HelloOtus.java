package tech.andrav.hw01;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by tully.
 * Edited by Antonov Andrey.
 * Example for hw01-maven
 *
 * To start the application:
 * mvn package
 * java -jar ./hw01-maven/target/hw01-maven-jar-with-dependencies.jar
 * java -cp "./hw01-maven/target/hw01-maven.jar:${HOME}/.m2/repository/com/google/guava/guava/27.1-jre/guava-27.1-jre.jar" tech.andrav.hw01.HelloOtus
 *
 * To unzip the jar:
 * unzip -l hw01-maven.jar
 * unzip -l hw01-maven-jar-with-dependencies.jar
 *
 * To build:
 * mvn package
 * mvn clean compile
 * mvn assembly:single
 * mvn clean compile assembly:single
 */
public class HelloOtus {
    private static final int MEASURE_COUNT = 1;

    public static void main(String... args) {
        List<Integer> example = new ArrayList<>();
        int min = 0;
        int max = 9;
        for (int i = min; i < max + 1; i++) {
            example.add(i);
        }

        System.out.println(example);
        System.out.println(Lists.reverse(example));
        System.out.println("-----------------------------");

        List<Integer> result = new ArrayList<>();
        Collections.shuffle(example);
        System.out.println(example);
        calcTime(() -> result.addAll(Lists.reverse(Lists.reverse(example))));
        System.out.println(result);
    }

    private static void calcTime(Runnable runnable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASURE_COUNT; i++) {
            runnable.run();
        }
        long finishTime = System.nanoTime();
        long timeNs = (finishTime - startTime) / MEASURE_COUNT;
        System.out.println("Time spent: " + timeNs + "ns (" + timeNs / 1_000_000 + "ms)");
    }
}

