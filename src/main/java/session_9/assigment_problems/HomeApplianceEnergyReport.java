package main.java.session_9.assigment_problems;

import java.util.*;

interface SaverMode {
    double saverUnits(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double power();

    double units() {
        return power() * hours / 1000;
    }

    double cost() {
        return units() * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double power() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }

    double power() {
        return 1500;
    }

    public double saverUnits(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double power() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }

    double power() {
        return 500;
    }

    public double saverUnits(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String type = data[0].toUpperCase();
            double hours = Double.parseDouble(data[1]);
            boolean saver = data.length == 3
                            && data[2].equalsIgnoreCase("SAVER");

            Appliance a;

            switch (type) {
                case "FRIDGE":
                    a = new Fridge(hours);
                    break;
                case "AC":
                    a = new AC(hours);
                    break;
                case "TV":
                    a = new TV(hours);
                    break;
                default:
                    a = new Washer(hours);
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = a.units();

            if (saver) {
                SaverMode sm = (SaverMode) a;
                units = sm.saverUnits(units);
            }

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}