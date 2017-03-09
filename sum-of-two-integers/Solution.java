public class Solution {
    public int getSum(int a, int b) {
        int c = 0; // c = a + b
        int mask = 1;
        boolean carry = false;
        boolean m_a, m_b, m_c;
        for(int i = 0; i<32; i++) {
            m_a = (mask & a) != 0L ? true : false;
            m_b = (mask & b) != 0L ? true : false;
            m_c = !( (!(m_a ^ m_b)) ^ carry );
            c |= ((m_c ? 1 : 0) << i);

            carry = (m_a && (m_b || carry)) || (m_b && carry);
            mask <<= 1;
        }

        return c;
    }
}
