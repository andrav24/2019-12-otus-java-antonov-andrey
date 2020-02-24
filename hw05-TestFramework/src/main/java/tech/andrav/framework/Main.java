package tech.andrav.framework;

import tech.andrav.framework.core.Framework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] args0;
        String[] strDemoDefaultClasses = {"tech.andrav.framework.demo.test.MyClassOneTest","tech.andrav.framework.demo.test.MyClassTwoTest"};

        if (args.length == 0) {
            args0 = strDemoDefaultClasses;
        } else {
            args0 = Arrays.copyOf(args,args.length);
        }

        Framework app = new Framework();
        app.run(args0);
    }
}
