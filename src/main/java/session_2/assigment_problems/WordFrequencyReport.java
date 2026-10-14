package main.java.session_2.assigment_problems;

import java.util.*;

public class WordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "").replace(",", "");

        String[] words = feedback.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            boolean stop = false;

            for (String s : stopWords) {
                if (word.equals(s)) {
                    stop = true;
                    break;
                }
            }

            if (!stop && !word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));

        for (String word : list) {
            System.out.println(word + ": " + map.get(word));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter feedback paragraph:");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);
        sc.close();
    }
}
