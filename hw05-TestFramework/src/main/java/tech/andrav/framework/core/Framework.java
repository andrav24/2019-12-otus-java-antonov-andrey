package tech.andrav.framework.core;

import java.util.ArrayList;
import java.util.List;

public class Framework {

    private final List<List<Result>> listOfResults = new ArrayList<>();

    public void run(String[] args) throws Exception {

        runTesting(args);
        printResult();

    }


    private void runTesting(String[] args) throws Exception {
        for (String arg : args) {
            try {
                Class<?> clazz = Class.forName(arg);
                TestRunner testRunner = new TestRunner(clazz);
                listOfResults.add(testRunner.exec());
            } catch (ClassNotFoundException e) {
                System.out.println("Class " + arg + " is not found!");
            }
        }
    }

    private void printResult() {
        int wasFailure = 0;
        int wasSuccessful = 0;
        int totalCount = 0;
        String currentClass = "";

        for (List<Result> results : listOfResults) {
            totalCount += results.size();   // кол-во запущенных тестов

            for (Result result : results) {
                if (!currentClass.equals(result.getTestClass())) {
                    currentClass = result.getTestClass();
                    System.out.println("Test class: " + currentClass);
                }
                System.out.print("\t" + String.format("%-" + 15 +"s", result.getPrintString()));
                System.out.println(result.getTestMethod());

                if (result.getTestResult()) {
                    wasSuccessful++;        // кол-во успешных тестов
                } else {
                    wasFailure ++;          // кол-во упавших тестов
                }
            }
        }
        System.out.println();
        System.out.println("Tests run: " + totalCount);
        System.out.println("Tests successful: " + wasSuccessful);
        System.out.println("Tests failure: " + wasFailure);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
