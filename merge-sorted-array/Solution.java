public class Solution {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m-1;
        int j = B.length-1;
        for (int k = A.length-1; k >= 0; k--)
            if (i < 0) A[k] = B[j--];
            else if (j < 0) A[k] = A[i--];
            else if (A[i] < B[j]) A[k] = B[j--];
            else A[k] = A[i--];
    }
}
