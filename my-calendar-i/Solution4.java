class MyCalendar {
    private TreeNode root;

    public MyCalendar() {
        root = null;
    }

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new TreeNode(startTime, endTime);
            return true;
        }
        return add(root, startTime, endTime);
    }

    private boolean add(TreeNode root, int start, int end) {
        if (end <= root.start) {
            if (root.left == null) {
                root.left = new TreeNode(start, end);
                return true;
            }
            return add(root.left, start, end);
        }
        if (root.end <= start) {
            if (root.right == null) {
                root.right = new TreeNode(start, end);
                return true;
            }
            return add(root.right, start, end);
        }
        return false;
    }

    private static class TreeNode {
        int start, end;
        TreeNode left, right;
        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
