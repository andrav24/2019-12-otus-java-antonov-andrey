package tech.andrav.framework.core;

public class Result {
    private final String testClass;
    private final String testMethod;
    private final boolean testResult;

    public Result(String testClass, String testMethod, boolean testResult) {
        this.testClass = testClass;
        this.testMethod = testMethod;
        this.testResult = testResult;
    }

    public String getTestClass() {
        return testClass;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public boolean isTestResult() {
        return testResult;
    }

    public int getTestResultAsInt() {
        return testResult ? 1 : 0;
    }

    public String getPrintString() {
        return testResult ? "successfully" : "failure";
    }
}
