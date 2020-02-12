package tech.andrav.hw04.aop.proxy;

public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.action();
    }

    private void action() {
        LoggingInterface loggingInterfaceInst = IoC.createMyClass(new ClassWithLog());
        loggingInterfaceInst.calculation(16);
        LoggingInterface loggingInterfaceInst2 = IoC.createMyClass(new ClassWithoutLog());
        loggingInterfaceInst2.calculation(16);
        loggingInterfaceInst.calculation(106);
    }
}
