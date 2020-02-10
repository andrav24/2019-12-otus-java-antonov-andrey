package tech.andrav.hw04.aop.proxy;

public class ClassWithoutLog implements LoggingInterface {

    @Override
    public void calculation(int param) {
        System.out.println("ClassWithoutLog: " + (param + 10));
    };
}
