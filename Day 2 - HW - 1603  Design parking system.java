class ParkingSystem {
    // Array to store the count of slots for [big, medium, small]
    private int[] count;

    public ParkingSystem(int big, int medium, int small) {
        // Initialize with provided capacities
        count = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // carType is 1, 2, or 3. Use carType - 1 to map to array indices 0, 1, 2.
        if (count[carType - 1] > 0) {
            count[carType - 1]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
