package tech.andrav.hw04.aop.proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IoC {
    static LoggingInterface createMyClass(LoggingInterface realObj) {
        InvocationHandler handler = new DemoInvocationHandler(realObj);
        return (LoggingInterface) Proxy.newProxyInstance(IoC.class.getClassLoader(),
                new Class<?>[]{LoggingInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final LoggingInterface myClassObj;

        DemoInvocationHandler(LoggingInterface myClassObj) {
            this.myClassObj = myClassObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Annotation anno = myClassObj.getClass()
                                        .getDeclaredMethod(method.getName(), method.getParameterTypes())
                                        .getAnnotation(Log.class);

            if (anno != null) {
                System.out.print("executed method: " + method.getName());
                for (Object arg : args) {
                    System.out.print(", param: " + arg);
                }
                System.out.println();
            }
            return method.invoke(myClassObj, args);
        }
    }
}
