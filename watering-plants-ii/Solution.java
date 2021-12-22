class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        var refills = 0;
        var ai = 0;
        var bi = plants.length-1;
        var capA = capacityA;
        var capB = capacityB;
        while (ai < bi) {
            if (capA < plants[ai]) {
                capA = capacityA; 
                refills++;
            }
            if (capB < plants[bi]) {
                capB = capacityB;
                refills++;
            }
            capA -= plants[ai++];
            capB -= plants[bi--];
        }
        if (ai == bi) {
            final var maxLeft = Math.max(capA, capB) - plants[ai];
            if (maxLeft < 0) refills++;            
        }
        return refills;
    }
}
