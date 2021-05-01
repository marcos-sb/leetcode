class Solution {
    private final double xc;
    private final double yc;
    private final double r;
    
    public Solution(double radius, double x_center, double y_center) {
        this.xc = x_center;
        this.yc = y_center;
        this.r = radius;
    }
    
    public double[] randPoint() {
        final var rnd = ThreadLocalRandom.current();
        final double angle = rnd.nextDouble(0, 2*Math.PI);
        final double delta = r * Math.sqrt(rnd.nextDouble(0, 1));
        
        final double x0 = Math.cos(angle) * delta;
        final double y0 = Math.sin(angle) * delta;
        
        final double x = x0 + xc;
        final double y = y0 + yc;
        
        return new double[]{x, y};
    }
}
