class Solution {
    public int compress(char[] chars) {
        int i=0;
        int ind=0;
        while(i<chars.length){
            char curr = chars[i];
            int c=0;
            while(i<chars.length&& chars[i]==curr){
                c++;
                i++;
            }
            chars[ind++] = curr;
            if(c>1){
                String s = Integer.toString(c);
                for(char d : s.toCharArray()){
                    chars[ind++]=d;
                }
            }
        }
        return ind;
    }
}