class Solution {
    static final Deque<Character> stackOp = new ArrayDeque<>();
    static final Deque<Integer> stackOperand = new ArrayDeque<>();
    
    public int calculate(String s) {
        var n = 0;
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                n *= 10;
                n += c - '0';
            } else {
                stackOperand.push(n);
                n = 0;
                while (!stackOp.isEmpty() && precedence(stackOp.peek()) >= precedence(c)) {
                    eval();
                }
                stackOp.push(c);
            }
        }
        stackOperand.push(n);
        
        while (!stackOp.isEmpty()) eval();
        
        return stackOperand.pop();
    }
    
    private int precedence(char c) {
        switch (c) {
            case '*':
            case '/':
                return 2;
            case '-':
                return 1;
            case '+':
                return 0;
        }
        return 0;
    }
    
    private void eval() {
        final var operandB = stackOperand.pop();
        final var operandA = stackOperand.pop();
        final var op = stackOp.pop();
        stackOperand.push(eval(operandA, operandB, op));
    }
    
    private static int eval(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }
}
