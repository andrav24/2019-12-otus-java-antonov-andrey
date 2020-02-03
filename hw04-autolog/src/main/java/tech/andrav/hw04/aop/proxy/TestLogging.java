package tech.andrav.hw04.aop.proxy;

public class TestLogging implements LoggingInterface {
    @Log
    public void calculation(int param) {
        int res = param * 10;
        System.out.println("Result is " + res);
    };

    public void print() {
        System.out.println(toString());
    }
}
