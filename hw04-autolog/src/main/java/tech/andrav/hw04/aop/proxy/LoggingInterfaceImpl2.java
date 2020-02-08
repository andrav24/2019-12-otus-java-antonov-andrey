package tech.andrav.hw04.aop.proxy;

public class LoggingInterfaceImpl2 implements LoggingInterface {

    @Override
    public void calculation(int param) {
        System.out.println(param + 10);
    };
}
