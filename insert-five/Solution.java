public class Solution {
    public int InsertFive(int a) {
        final String aStr = String.valueOf(a);
        
        int i = 0;
        if (a >= 0)
            for (; i < aStr.length(); i++)
                if ('5' > aStr.charAt(i)) break;
        else
            for (; i < aStr.length(); i++)
                if ('5' < aStr.charAt(i)) break;
        
        return Integer.parseInt(aStr.substring(0, i) + '5' + aStr.substring(i));
    }
}
