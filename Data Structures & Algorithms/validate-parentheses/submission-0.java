

class Solution {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}