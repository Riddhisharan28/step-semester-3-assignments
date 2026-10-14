package main.java.session_8.class_problems;


import java.util.Scanner;
import java.time.LocalDate;

abstract class LibraryItem {
    abstract int borrowingDays();

    LocalDate dueDate(LocalDate currentDate) {
        return currentDate.plusDays(borrowingDays());
    }
}

class Book extends LibraryItem {
    int borrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    int borrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    int borrowingDays() {
        return 3;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int firstQuote = line.indexOf('"');
            int lastQuote = line.lastIndexOf('"');

            String type = line.substring(0, firstQuote).trim();
            String title = line.substring(firstQuote + 1, lastQuote);

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book();
                    break;
                case "DVD":
                    item = new DVD();
                    break;
                default:
                    item = new Magazine();
            }

            System.out.println(title + ": "
                    + item.dueDate(currentDate));
        }

        sc.close();
    }
}
