class Solution {
    public int tribonacci(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;
        
        final var aux = new int[3];
        aux[0] = 0; aux[1] = 1; aux[2] = 1;

        for (var i = 3; i <= n; i++)
            aux[i%3] = aux[0] + aux[1] + aux[2];

        return aux[n%3];
    }
}
