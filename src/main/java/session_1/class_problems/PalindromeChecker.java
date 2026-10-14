package main.java.session_1.class_problems;

import java.util.*;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String s) {
        if (s.length() <= 1)
            return true;

        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        return isPalindromeRecursive(s.substring(1, s.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String s) {
        char[] a = s.toCharArray();
        char[] b = new char[a.length];

        for (int i = 0; i < a.length; i++)
            b[i] = a[a.length - 1 - i];

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String s = sc.nextLine();

        System.out.println("Iterative: "
                + (isPalindromeIterative(s) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: "
                + (isPalindromeRecursive(s) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: "
                + (isPalindromeArrayReversal(s) ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}