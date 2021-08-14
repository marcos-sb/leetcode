
abstract class Node {
    public abstract int evaluate();
}

abstract class OpNode extends Node {
    Node left, right;
    
    public static OpNode build(char op) {
        switch (op) {
            case '+':
                return new SumNode();
            case '-':
                return new SubNode();
            case '*':
                return new MultNode();
            case '/':
                return new DivNode();
            default:
                return null;
        }
    }
}

class SumNode extends OpNode {
    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

class SubNode extends OpNode {
    @Override
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }
}

class MultNode extends OpNode {
    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}

class DivNode extends OpNode {
    @Override
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }
}

class TermNode extends Node {    
    int val;
    TermNode(int val) {
        this.val = val;
    }
    
    @Override
    public int evaluate() {
        return val;
    }
}

class TreeBuilder {
    Node buildTree(String[] postfix) {
        final Deque<Node> stack = new LinkedList<>();
        for (var el : postfix) {
            final var c = el.charAt(0);
            if (Character.isDigit(c))
                stack.push(new TermNode(Integer.parseInt(el)));
            else {
                stack.push(OpNode.build(c));
                buildOpTree(stack);
            }
        }
        return stack.pop();
    }
    
    static void buildOpTree(Deque<Node> stack) {
        final var opNode = (OpNode) stack.pop();
        opNode.right = stack.pop();
        opNode.left = stack.pop();
        stack.push(opNode);
    }
};

