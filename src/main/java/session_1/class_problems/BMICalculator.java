package main.java.session_1.class_problems;

import java.util.*;

public class BMICalculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    static void printWellnessReport(double[] h, double[] w) {
        System.out.println("\nPerson\tHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < h.length; i++) {
            double bmi = w[i] / (h[i] * h[i]);

            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n",
                    i + 1, h[i], w[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] heights = new double[10];
        double[] weights = new double[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter height (m) and weight (kg) for Person "
                    + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            weights[i] = sc.nextDouble();
        }

        printWellnessReport(heights, weights);

        sc.close();
    }
}