import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, 0, expression.length() - 1);
        return new ArrayList<>(result);
    }

    private Set<String> parse(String s, int l, int r) {
        Set<String> result = new TreeSet<>();
        Set<String> current = new TreeSet<>();
        current.add("");

        int i = l;

        while (i <= r) {
            char c = s.charAt(i);

            if (c == '{') {
                int count = 1;
                int j = i + 1;

                while (count > 0) {
                    if (s.charAt(j) == '{') count++;
                    else if (s.charAt(j) == '}') count--;
                    j++;
                }

                Set<String> inside = parse(s, i + 1, j - 2);
                current = multiply(current, inside);

                i = j;
            } 
            else if (c == ',') {
                result.addAll(current);
                current = new TreeSet<>();
                current.add("");

                i++;
            } 
            else {
                Set<String> letter = new TreeSet<>();
                letter.add(String.valueOf(c));

                current = multiply(current, letter);
                i++;
            }
        }

        result.addAll(current);
        return result;
    }

    private Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> result = new TreeSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna