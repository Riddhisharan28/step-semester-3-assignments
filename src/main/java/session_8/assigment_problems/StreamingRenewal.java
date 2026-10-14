package main.java.session_8.assigment_problems;


import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {
    abstract int validityDays();

    LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(validityDays());
    }
}

class Basic extends Plan {
    int validityDays() {
        return 30;
    }
}

class Standard extends Plan {
    int validityDays() {
        return 90;
    }
}

class Premium extends Plan {
    int validityDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan p;

            switch (type) {
                case "BASIC":
                    p = new Basic();
                    break;
                case "STANDARD":
                    p = new Standard();
                    break;
                default:
                    p = new Premium();
            }

            LocalDate renewal = p.getRenewalDate(startDate);
            System.out.println(name + ": " + renewal);
        }

        sc.close();
    }
}
