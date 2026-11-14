class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();

        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-")
                && !token.equals("*") && !token.equals("/")) {
                    stk.push(Integer.parseInt(token));
                } else {
                    int b = stk.pop();
                    int a = stk.pop();

                    int res = 0;
                    if (token.equals("+")) {
                        res = a + b;
                    } if (token.equals("-")) {
                        res = a - b;
                    } if (token.equals("*")) {
                        res = a * b;
                    } if (token.equals("/")) {
                        res = a / b;
                    }

                    stk.push(res);
                }
        }

        return stk.pop();
    }
}
