package main.java.session_2.class_problems;

import java.util.*;

public class CSVStudentRecord {

    static void parseStudentRecord(String csvLine) {
        String[] data = csvLine.split(",", -1);

        if (data.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Name: " + data[0].trim()
                    + " | Roll No: " + data[1].trim()
                    + " | Dept: " + data[2].trim());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String line = sc.nextLine();

        parseStudentRecord(line);
        sc.close();
    }
}