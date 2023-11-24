package test;

import org.junit.runner.*;
import org.junit.runner.notification.Failure;
import java.io.FileWriter;
import java.io.IOException;

public class TestSuiteRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);

        String outputPath = "OUTPUT.txt";
        String output = "";
        if (result.wasSuccessful()) {
            output += "!!!SUCCESS!!!\n\n";
        } else {
            output += "!!!FAILED!!!\n\n";
        }
        output += "All tests completed in " + result.getRunTime() + " ms.\n";
        output += "Total tests run: " + result.getRunCount() + "\n";
        output += "Passed: " + (result.getRunCount() - result.getFailureCount()) + "\n";
        output += "Failed: " + result.getFailureCount() + "\n";
        if (result.getFailureCount() > 0) {
            output += "\nFailures:\n";
        }
        for (int i = 0; i < result.getFailureCount(); i++) {
            Failure failure = result.getFailures().get(i);
            output += (i + 1) + ": " + failure.toString() + "\n";
        }
        output += "\nOutput logged in " + outputPath + ".\n";

        System.out.println();
        System.out.println(output);

        try {
            FileWriter fw = new FileWriter("OUTPUT.txt");
            fw.write(output);
            fw.close();
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
