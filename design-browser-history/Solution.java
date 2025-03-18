class BrowserHistory {
    private Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        final var newNode = new Node(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }

    public String back(int steps) {
        while (curr.prev != null && 0 < steps) {
            curr = curr.prev;
            --steps;
        }
        return curr.page;
    }

    public String forward(int steps) {
        while (curr.next != null && 0 < steps) {
            curr = curr.next;
            --steps;
        }
        return curr.page;
    }

    private static class Node {
        String page;
        Node prev, next;
        Node(String page) {
            this.page = page;
        }
    }
}
