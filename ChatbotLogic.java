import java.io.*;
import java.util.*;

public class ChatbotLogic {

    private Map<String, String> faq = new HashMap<>();

    public ChatbotLogic() {
        loadFAQ();
    }

    // Load FAQ data (Training)
    private void loadFAQ() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("FAQ.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    faq.put(parts[0].toLowerCase(), parts[1]);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error loading FAQ file.");
        }
    }

    // NLP + Rule-based response
    public String getResponse(String input) {
        input = input.toLowerCase();
        input = input.replaceAll("[^a-z ]", "");

        for (String key : faq.keySet()) {
            if (input.contains(key)) {
                return faq.get(key);
            }
        }
        return "Sorry, I didn't understand that. Please try again.";
    }
}
