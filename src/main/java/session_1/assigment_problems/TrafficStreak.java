package main.java.session_1.assigment_problems;

import java.util.*;

public class TrafficStreak {
    static void findLongestStreak(String s) {
        int count = 1, max = 1;
        char color = s.charAt(0), best = color;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count > max) {
                max = count;
                best = s.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + best
                + "' repeated " + max + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String s = sc.nextLine();

        if (s.length() > 0)
            findLongestStreak(s);
        else
            System.out.println("Signal log is empty");

        sc.close();
    }
}