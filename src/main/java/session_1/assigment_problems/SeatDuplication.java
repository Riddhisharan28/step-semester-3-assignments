package main.java.session_1.assigment_problems;

public class SeatDuplication {
    static void checkDuplicateSeats(int[] a) {
        boolean found = false;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    boolean printed = false;

                    for (int k = 0; k < i; k++) {
                        if (a[k] == a[i])
                            printed = true;
                    }

                    if (!printed) {
                        System.out.println("Duplicate Seat Number Found: " + a[i]);
                        found = true;
                    }
                }
            }
        }

        if (!found)
            System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        int[] seats = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seats);
    }
}
