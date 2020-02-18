package tech.andrav.framework.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Framework {

    List<List<Result>> listOfResults = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        String[] args0;
        Result res = null;

        if (args.length == 0) {
            args0 = new String[]{"tech.andrav.framework.demo.test.MyClassOneTest","tech.andrav.framework.demo.test.MyClassTwoTest"};
        } else {
            args0 = Arrays.copyOf(args,args.length);
        }

        Framework app = new Framework();
        app.start();
        app.runTesting(args0);
        app.printResult();
        app.finish();
    }

    private void start() {

    }

    private void finish() {

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
            for (Result result : results) {
                if (!currentClass.equals(result.getTestClass())) {
                    currentClass = result.getTestClass();
                    System.out.println("Test class: " + currentClass);
                }
                System.out.print("\t" + String.format("%-" + 15 +"s", result.getPrintString()));
                System.out.println(result.getTestMethod());

                switch (result.getTestResultAsInt()) {
                    case 0:
                        wasFailure ++;
                        break;
                    case 1:
                        wasSuccessful++;
                        break;
                }
            }
            totalCount += results.size();
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
