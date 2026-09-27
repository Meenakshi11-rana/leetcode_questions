import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        String current = "";

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(current);
                current = "";
            } 
            else if (c == ')') {
                current = new StringBuilder(current).reverse().toString();

                current = stack.pop() + current;
            } 
            else {
                current += c;
            }
        }

        return current;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna