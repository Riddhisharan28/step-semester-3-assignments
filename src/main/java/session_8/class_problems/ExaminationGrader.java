package main.java.session_8.class_problems;


import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

abstract class Question {
    String correct, answer;
    double points;

    Question(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        String[] keywords = correct.split(",");
        int found = 0;

        for (String word : keywords) {
            if (answer.toLowerCase().contains(
                    word.trim().toLowerCase())) {
                found++;
            }
        }

        if (found >= 2) {
            return points * 0.75;
        } else if (found == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            ArrayList<String> data = new ArrayList<>();

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    data.add(matcher.group(1));
                } else {
                    data.add(matcher.group(2));
                }
            }

            String type = data.get(0);
            String correct = data.get(2);
            String answer = data.get(3);
            double points = Double.parseDouble(
                    data.get(4));

            Question q;

            switch (type) {
                case "MCQ":
                    q = new MCQ(correct, answer, points);
                    break;
                case "TF":
                    q = new TF(correct, answer, points);
                    break;
                default:
                    q = new Essay(correct, answer, points);
            }

            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}