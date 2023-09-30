class Solution {
    static class Node {
        int i;
        double dto0;
        Node(int i, double dto0) {
            this.i = i;
            this.dto0 = dto0;
        }
        static Node of(int i, double dto0) {
            return new Node(i, dto0);
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        final var N = points.length;
        
        final var maxHeap = new PriorityQueue<Node>((p1,p2) -> Double.compare(p2.dto0,p1.dto0));
        for (var i = 0; i < N; i++) {
            maxHeap.offer(Node.of(i, dto0(points[i])));
            if (k < maxHeap.size()) maxHeap.poll();
        }

        final var res = new int[k][];
        var i = 0;
        while (!maxHeap.isEmpty()) {
            final var top = maxHeap.poll();
            res[i++] = points[top.i];
        }
        
        return res;
    }

    private static double dto0(int[] p) {
        final var p0 = p[0];
        final var p1 = p[1];
        return Math.sqrt(p0*p0 + p1*p1);
    }
}
