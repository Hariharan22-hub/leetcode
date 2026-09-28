class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int pal = x;
        int sum = 0;
        while(x!=0){
            int d = x%10;
            sum=sum*10+d;
            x/=10;
        }
        return sum==pal;
    }
}