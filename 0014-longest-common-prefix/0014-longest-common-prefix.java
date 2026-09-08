class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return"";

        String first = strs[0];
        for (int i=0 ; i<first.length() ; i++){  //拿strs[0]裡面的字串逐步判斷
            char ch = first.charAt(i);  //有ch進inner loop

            for (int j=1 ; j<strs.length ; j++){
                if(i >=strs[j].length() || strs[j].charAt(i) != ch){
                    return first.substring(0,i);
                }
            }
        }
    return first;
    } 
}