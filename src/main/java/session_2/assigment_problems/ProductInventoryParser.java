package main.java.session_2.assigment_problems;

import java.util.*;

public class ProductInventoryParser {

    static void parseInventoryRecord(String csvLine) {
        String[] data = csvLine.split(",", -1);

        if (data.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + data[0].trim()
                    + " | SKU: " + data[1].trim()
                    + " | Qty: " + data[2].trim());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter inventory record: ");
        String line = sc.nextLine();

        parseInventoryRecord(line);
        sc.close();
    }
}