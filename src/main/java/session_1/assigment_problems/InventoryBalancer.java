package main.java.session_1.assigment_problems;

public class InventoryBalancer {
    static void analyzeInventory(int[] a, int[] b) {
        int sumA = 0, sumB = 0;
        int max = Integer.MIN_VALUE;
        String section = "";
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];

            if (a[i] > max) {
                max = a[i];
                section = "Section A";
                index = i + 1;
            }

            if (b[i] > max) {
                max = b[i];
                section = "Section B";
                index = i + 1;
            }
        }

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + sumA
                + " | Section B Total: " + sumB
                + " | Status: " + status);

        System.out.println("Highest Quantity: " + max
                + " (" + section + ", Item " + index + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}
