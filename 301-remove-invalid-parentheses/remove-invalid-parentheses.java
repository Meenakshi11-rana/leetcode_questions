import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        int left = 0;
        int right = 0;

        // Find minimum number of '(' and ')' to remove
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                left++;
            } 
            else if (ch == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, ans);

        return ans;
    }

    private void dfs(String s, int index, int leftRemove,
                     int rightRemove, List<String> ans) {

        if (leftRemove == 0 && rightRemove == 0) {

            if (isValid(s)) {
                ans.add(s);
            }

            return;
        }

        for (int i = index; i < s.length(); i++) {

            // Avoid duplicate strings
            if (i > index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            // Remove '('
            if (leftRemove > 0 && s.charAt(i) == '(') {

                dfs(
                    s.substring(0, i) + s.substring(i + 1),
                    i,
                    leftRemove - 1,
                    rightRemove,
                    ans
                );
            }

            // Remove ')'
            if (rightRemove > 0 && s.charAt(i) == ')') {

                dfs(
                    s.substring(0, i) + s.substring(i + 1),
                    i,
                    leftRemove,
                    rightRemove - 1,
                    ans
                );
            }
        }
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            } 
            else if (ch == ')') {
                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna