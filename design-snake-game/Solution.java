class SnakeGame {
    static class Pos {
        int r, c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            final var that = (Pos) obj;
            return this.r == that.r && this.c == that.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r,c);
        }
    }

    private final Set<Pos> snakePos;
    private final Deque<Pos> snake;
    private final Queue<Pos> food;
    private final Map<String, int[]> movs;
    private final int w;
    private final int h;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.snakePos = new HashSet<>();
        this.snake = new LinkedList<>();
        this.food = new LinkedList<>();
        this.movs = Map.of(
            "U", new int[]{-1,0},
            "D", new int[]{1,0},
            "L", new int[]{0,-1},
            "R", new int[]{0,1}
        );
        this.w = width;
        this.h = height;
        
        for (var foodRC : food)
            this.food.offer(new Pos(foodRC[0], foodRC[1]));
        
        final var start = new Pos(0,0);
        this.snakePos.add(start);
        this.snake.offerFirst(start);
    }
    
    public int move(String direction) {
        final var mov = movs.get(direction);
        final var currPos = snake.peekFirst();
        final var nextPos = new Pos(currPos.r+mov[0], currPos.c+mov[1]);
        
        if (outside(nextPos)) return -1;
        
        if (!food.isEmpty() && nextPos.equals(food.peek())) {
            food.poll();
        } else {
            final var tail = snake.pollLast();
            snakePos.remove(tail);
        }
        
        if (touchesTail(nextPos)) return -1;
        
        snake.offerFirst(nextPos);
        snakePos.add(nextPos);
        
        return snakePos.size() - 1;
    }
    
    private boolean outside(Pos p) {
        return p.r < 0 || p.c < 0 || p.r >= h || p.c >= w;
    }
    
    private boolean touchesTail(Pos p) {
        return snakePos.contains(p);
    }
    
}

