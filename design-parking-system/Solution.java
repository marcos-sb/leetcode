class ParkingSystem {
    private final int[] freeSpacesByType;
    
    public ParkingSystem(int big, int medium, int small) {
        freeSpacesByType = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (freeSpacesByType[carType-1] <= 0) return false;
        freeSpacesByType[carType-1]--;
        return true;
    }
}
