class Solution {
    static final int[][] movs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    final Set<Pair> visited = new HashSet<>();
    Robot robot;
    
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        bt(0,0,0);
    }
    
    private void bt(int row, int col, int dir) {
        visited.add(new Pair(row, col));
        robot.clean();
        
        for (int i = 0; i < movs.length; i++) {
            final var newDir = (dir + i) % movs.length;
            final var newRow = row + movs[newDir][0];
            final var newCol = col + movs[newDir][1];
            
            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                bt(newRow, newCol, newDir);
                back();
            }

            robot.turnRight();
        }
    }
    
    private void back() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
