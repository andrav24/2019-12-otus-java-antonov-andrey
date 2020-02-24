package tech.andrav.framework.core;

import java.io.File;

public class Utils {

    private Utils() {

    }

    public static String getFileName(String className) {
        String classPath = System.getProperty("java.class.path") + File.separator + className.replace(".", File.separator);
        return classPath;
    }
}
