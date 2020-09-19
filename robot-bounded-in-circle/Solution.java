class Solution {
    public boolean isRobotBounded(String instructions) {
        // N E S W
        final int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        final int[] originPos = new int[]{0,0};
        int curDir = 0;
        int[] curPos = new int[]{0,0};
        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'R':
                    curDir = (curDir+1) % directions.length;
                    break;
                case 'L':
                    final int len = directions.length;
                    curDir = (((curDir-1) % len) + len) % len;
                    break;
                case 'G':
                    curPos[0] += directions[curDir][0];
                    curPos[1] += directions[curDir][1];
                    break;
            }
        }
        return curDir != 0 || Arrays.equals(curPos, originPos);
    }
}
