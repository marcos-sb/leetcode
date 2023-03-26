class Solution {
    class Node {
        int id;
        List<Node> children;
        Node(int id) {
            this.id = id;
            children = new ArrayList<>();
        }
    }

    int maxTime;

    public Solution() {
        maxTime = 0;
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        final var root = buildTree(n, headID, manager);
        dfs(root, 0, informTime);
        return maxTime;
    }

    private Node buildTree(int n, int headID, int[] manager) {
        final var idToNode = new HashMap<Integer, Node>();
        for (var i = 0; i < n; i++) {
            final var nodeI = idToNode.computeIfAbsent(i, k -> new Node(k));
            final var m = manager[i];
            if (m == -1) continue;
            idToNode.computeIfAbsent(m, k -> new Node(k)).children.add(nodeI);
        }
        return idToNode.get(headID);
    }

    private void dfs(Node root, int timeSoFar, int[] informTime) {
        maxTime = Math.max(timeSoFar, maxTime);
        for (var c : root.children)
            dfs(c, timeSoFar + informTime[root.id], informTime);
    }
}
