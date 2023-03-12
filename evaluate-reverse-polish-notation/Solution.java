class Solution {
    public int evalRPN(String[] tokens) {
        final var stack = new ArrayList<Integer>();
        for (var t : tokens) {
            if (t.length() == 1 && !Character.isDigit(t.charAt(0))) {
                stack.add(doOp(stack, t.charAt(0)));
            } else {
                stack.add(Integer.valueOf(t));
            }
        }
        return stack.get(0);
    }

    private static int doOp(List<Integer> stack, char op) {
        final var right = stack.remove(stack.size()-1);
        final var left  = stack.remove(stack.size()-1);
        var res = 0;
        
        switch(op) {
            case '+':
                res = left + right;
                break;
            case '-':
                res = left - right;
                break;
            case '/':
                res = left / right;
                break;
            case '*':
                res = left * right;
        }
        
        return res;
    }
}
