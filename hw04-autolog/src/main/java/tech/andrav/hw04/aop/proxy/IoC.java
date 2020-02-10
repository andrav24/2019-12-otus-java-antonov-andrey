package tech.andrav.hw04.aop.proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;

public class IoC {
    private static final ClassLoader classLoader = IoC.class.getClassLoader();
    private static final HashMap<Class<? extends LoggingInterface>, HashMap<Method, Boolean>> bigCache = new HashMap<>();

    static LoggingInterface createMyClass(LoggingInterface realObj) {
        InvocationHandler handler = new DemoInvocationHandler(realObj);
        return (LoggingInterface) Proxy.newProxyInstance(classLoader, new Class<?>[]{LoggingInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final LoggingInterface myClassObj;
        private final Class<? extends LoggingInterface> clazz;

        DemoInvocationHandler(LoggingInterface myClassObj) {
            this.myClassObj = myClassObj;
            this.clazz = myClassObj.getClass();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            HashMap<Method, Boolean> smallCache = bigCache.get(clazz);
            if (smallCache == null) {
                smallCache = new HashMap<Method, Boolean>();
                bigCache.put(clazz, smallCache);
            }

            Boolean isLogged = smallCache.get(method);
            if (isLogged == null) {
                Annotation anno = clazz.getDeclaredMethod(method.getName(), method.getParameterTypes()).getAnnotation(Log.class);
                isLogged = (anno != null);
                smallCache.put(method, isLogged);
            }

            if (isLogged) {
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
