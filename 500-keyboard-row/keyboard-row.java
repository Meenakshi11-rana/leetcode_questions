import java.util.*;

class Solution {
    public String[] findWords(String[] words) {

        Set<Character> row1 = Set.of(
            'q','w','e','r','t','y','u','i','o','p'
        );

        Set<Character> row2 = Set.of(
            'a','s','d','f','g','h','j','k','l'
        );

        Set<Character> row3 = Set.of(
            'z','x','c','v','b','n','m'
        );

        List<String> result = new ArrayList<>();

        for (String word : words) {

            String w = word.toLowerCase();

            Set<Character> row;

            if (row1.contains(w.charAt(0))) {
                row = row1;
            } else if (row2.contains(w.charAt(0))) {
                row = row2;
            } else {
                row = row3;
            }

            boolean valid = true;

            for (char ch : w.toCharArray()) {
                if (!row.contains(ch)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna