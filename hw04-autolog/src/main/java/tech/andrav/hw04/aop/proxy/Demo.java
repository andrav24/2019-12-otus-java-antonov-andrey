package tech.andrav.hw04.aop.proxy;

public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.action();
    }

    private void action() {
        LoggingInterface loggingInterfaceInst = IoC.createMyClass(new LoggingInterfaceImpl());
        loggingInterfaceInst.calculation(16);
        LoggingInterface loggingInterfaceInst2 = IoC.createMyClass(new LoggingInterfaceImpl2());
        loggingInterfaceInst2.calculation(16);
    }
}
