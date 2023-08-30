import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a text or provide a file path to count words:");
        String input = sc.nextLine();
        
        String[] words = getWords(input);
        int totalWordCount = words.length;
        System.out.println("Total word count: " + totalWordCount);
        
        // Optional: Count unique words and their frequencies
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    private static String[] getWords(String input) {
        if (input.startsWith("file:")) {
            String filePath = input.substring(5); // Remove "file:" prefix
            return readWordsFromFile(filePath);
        } else {
            return input.split("\\s+|\\p{Punct}");
        }
    }
    
    private static String[] readWordsFromFile(String filePath) {
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            StringBuilder content = new StringBuilder();
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append(" ");
            }
            fileScanner.close();
            return content.toString().split("\\s+|\\p{Punct}");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0]; // Return an empty array on error
        }
    }
}
