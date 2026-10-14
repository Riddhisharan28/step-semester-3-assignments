package main.java.session_2.assigment_problems;

import java.util.*;

public class ISBNNormalizer {

    static String normalizeCode(String raw) {
        raw = raw.trim();

        if (raw.length() < 3)
            return raw;

        return raw.substring(0, 3).toUpperCase()
                + raw.substring(3);
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13)
            return "Invalid: wrong length";

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i)))
                return "Invalid: publisher code must be 3 letters";
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i)))
                return "Invalid: body must contain only digits";
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(publisher).append("] YEAR: ");
        sb.append(year).append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String raw = sc.nextLine();

        String code = normalizeCode(raw);
        System.out.println(validateAndFormat(code));

        sc.close();
    }
}