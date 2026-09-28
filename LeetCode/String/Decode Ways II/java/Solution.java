class Solution {
    public int numDecodings(String s) {
        final long mod = 1000000007;
        long prev2 = 1;
        long prev1 = 0;
        char first = s.charAt(0);
        if(first == '*'){
          prev1 = 9;
        }
        else if(first != '0'){
            prev1 = 1;
        }
        for(int i=1;i<s.length();i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);
            long current = 0;
            if (curr == '*') {
                current += 9 * prev1;
            } else if (curr != '0') {
                current += prev1;
            }
            if (prev == '*' && curr == '*') {

                current += 15 * prev2;
            } else if (prev == '*') {
                if (curr >= '0' && curr <= '6') {
                    current += 2 * prev2;
                } else {
                    current += prev2;
                }
            } else if (curr == '*') {
                if (prev == '1') {
                    current += 9 * prev2;
                } else if (prev == '2') {
                    current += 6 * prev2;
                }
            } else {
                int num = (prev - '0') * 10 + (curr - '0');

                if (num >= 10 && num <= 26) {
                    current += prev2;
                }
            }
            current %= mod;
            prev2 = prev1;
            prev1 = current;
        }
        return (int) prev1;
    }
}