package main.java.session_9.assigment_problems;

import java.util.*;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double charge();

    double insurance() {
        return 0;
    }

    double total() {
        return charge() + insurance();
    }
}

class Standard extends Parcel {
    Standard(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance() {
        return value * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance() {
        return value * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel p;

            switch (type) {
                case "STANDARD":
                    p = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    p = new Express(weight, value);
                    break;
                default:
                    p = new Fragile(weight, value);
            }

            double charge = p.charge();
            double insurance = p.insurance();
            double total = p.total();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
