package tech.andrav.hw04.aop.proxy;

public class LoggingInterfaceImpl implements LoggingInterface {

    @Log
    @Override
    public void calculation(int param) {
        System.out.println(param);
    };
}
