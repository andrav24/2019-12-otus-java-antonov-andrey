package tech.andrav.framework.core;

import tech.andrav.framework.annotation.After;
import tech.andrav.framework.annotation.Before;
import tech.andrav.framework.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {

    private final Class<?> clazz;
    private final List<Method> annotatedBefore = new ArrayList<>();
    private final List<Method> annotatedAfter = new ArrayList<>();
    private final List<Method> annotatedTest = new ArrayList<>();

    TestRunner(Class<?> clazz) {
        this.clazz = clazz;
    }

    public List<Result> exec () throws Exception {

        List<Result> results = new ArrayList<>();

        Constructor<?> constructor = clazz.getConstructor();
        Method[] methods = clazz.getDeclaredMethods();

        // анализ класса
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations){
                if (annotation instanceof Before) {
                    annotatedBefore.add(method);
                }
                if (annotation instanceof After) {
                    annotatedAfter.add(method);
                }
                if (annotation instanceof Test) {
                    annotatedTest.add(method);
                }
            }
        }

        // выполнение тестов
        Collections.shuffle(annotatedTest);
        for (Method methodTest : annotatedTest) {
            Result res = null;
            Object obj = constructor.newInstance();

            try {
                for (Method methodBefore : annotatedBefore) {
                    methodBefore.invoke(obj);
                }
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            try {
                methodTest.invoke(obj);
            } catch (Exception e) {
                res = new Result(clazz.getName(), methodTest.getName(), false);
            } finally {
                if (res == null) {
                    res = new Result(clazz.getName(), methodTest.getName(), true);
                }
            }

            try {
                for (Method methodAfter : annotatedAfter) {
                    methodAfter.invoke(obj);
                }
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            // запись текущего результата теста в список результатов
            results.add(res);
        }

        return results;
    }
}
