package tech.andrav.hw04.aop.proxy;

public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.action();
    }

    private void action() {
        new TestLogging().calculation(16);
    }
}
