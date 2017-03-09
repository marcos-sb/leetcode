class Solution {
public:
    int getSum(int a, int b) {
        int c; // c = a + b
        unsigned mask = 1;
        bool carry = false;
        bool m_a, m_b, m_c;
        for(int i = 0; i<32; i++) {
            m_a = mask & a;
            m_b = mask & b;
            m_c = !( (!(m_a ^ m_b)) ^ carry );
            c |= (m_c << i);

            carry = (m_a && (m_b || carry)) || (m_b && carry);
            mask <<= 1;
        }

        return c;
    }
};
