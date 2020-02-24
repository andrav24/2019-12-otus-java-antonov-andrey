package tech.andrav.framework.core;

import tech.andrav.framework.annotation.After;
import tech.andrav.framework.annotation.Before;
import tech.andrav.framework.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {

    private final Class<?> clazz;
    private final List<Method> annotatedBefore = new ArrayList<>();
    private final List<Method> annotatedAfter = new ArrayList<>();
    private final List<Method> annotatedTest = new ArrayList<>();
    private final List<Result> results = new ArrayList<>();

    TestRunner(Class<?> clazz) {
        this.clazz = clazz;
    }

    public List<Result> exec () throws Exception {
        classAnalyzer();
        runTests();
        return results;
    }

    private void runTests() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Collections.shuffle(annotatedTest);
        for (Method methodTest : annotatedTest) {
            Result res = new Result(clazz.getName(), methodTest.getName());
            Object obj = null;

            try {
                Constructor<?> constructor = clazz.getConstructor();
                obj = constructor.newInstance();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                runAllAnnotatedBefore(obj);
                methodTest.invoke(obj);
            } catch (Exception e) {
                res.setTestResult(false);
            } finally {
                runAllAnnotatedAfter(obj);
            }

            // если тесты не упали - устанавливаем результат в true
            if (res.getTestResult() == null) {
                res.setTestResult(true);
            }

            results.add(res);
        }
    }

    private void runAllAnnotatedBefore(Object obj) throws InvocationTargetException, IllegalAccessException {
        for (Method method : annotatedBefore) {
            method.invoke(obj);
        }
    }

    private void runAllAnnotatedAfter(Object obj) throws InvocationTargetException, IllegalAccessException {
        for (Method method : annotatedAfter) {
            method.invoke(obj);
        }
    }

    private void classAnalyzer() {
        Method[] methods = clazz.getDeclaredMethods();
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
    }
}
