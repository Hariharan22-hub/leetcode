class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int s =0;
        int min = Integer.MAX_VALUE;
        for(int r=0;r<nums.length;r++){
            s+=nums[r];
            while(s>=target){
                min = Math.min(min,r-l+1);
                s -=nums[l];
                l++;
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }
}