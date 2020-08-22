class Solution {
    public int[] sortArrayByParity(int[] A) {
        int oddIdx = 0;
        int evenIdx = 0;
        
        while (true) {
            while (oddIdx < A.length && A[oddIdx] % 2 == 0) oddIdx++;
            while (evenIdx < A.length && A[evenIdx] % 2 != 0) evenIdx++;
            if (oddIdx < A.length && evenIdx < A.length) {
                if (oddIdx < evenIdx) swap(A, oddIdx, evenIdx);
                else evenIdx++;
            } else break;
        }
        
        return A;
    }
    
    private static void swap(int[] A, int i, int j) {
        final int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
