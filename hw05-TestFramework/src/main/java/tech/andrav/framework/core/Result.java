package tech.andrav.framework.core;

public class Result {
    private final String testClass;
    private final String testMethod;
    private Boolean testResult;

    public Result(String testClass, String testMethod) {
        this.testClass = testClass;
        this.testMethod = testMethod;
        this.testResult = null;
    }

    public Result(String testClass, String testMethod, Boolean testResult) {
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

    public Boolean getTestResult() {
        return testResult;
    }

    public void setTestResult(Boolean result) {
        if (testResult == null) {
            testResult = result;
        }
    }

    public String getPrintString() {
        return testResult ? "successfully" : "failure";
    }
}
