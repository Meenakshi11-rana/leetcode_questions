import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(0);
            } 
            else {
                int value = stack.pop();

                if (value == 0) {
                    value = 1;
                } 
                else {
                    value = 2 * value;
                }

                stack.push(stack.pop() + value);
            }
        }

        return stack.pop();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna