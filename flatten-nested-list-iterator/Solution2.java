/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {
    static class NestedMeta {
        int curr;
        final List<NestedInteger> list;
        NestedMeta(List<NestedInteger> list) {
            this.curr = 0;
            this.list = list;
        }
    }

    final Deque<NestedMeta> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        stack.push(new NestedMeta(nestedList));
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        final var nextIdx = stack.peek().curr;
        stack.peek().curr++;
        return stack.peek().list.get(nextIdx).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().list.size() <= stack.peek().curr) {
                stack.pop();
                continue;
            }
            if (stack.peek().list.get(stack.peek().curr).isInteger())
                break;
            final var currIndx = stack.peek().curr++;
            stack.push(new NestedMeta(stack.peek().list.get(currIndx).getList()));
        }
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
