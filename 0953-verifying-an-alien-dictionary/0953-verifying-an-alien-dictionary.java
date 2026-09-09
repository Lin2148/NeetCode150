class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            boolean foundDiff = false;
            int len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                

                if(c1 != c2){
                    if (rank[c1-'a'] > rank[c2-'a']){
                        System.out.printf("c1=%c, c2=%c \nrc1=%d,rc2=%d",c1,c2,rank[c1-'a'],rank[c2-'a']);
                        return false;
                    }
                    foundDiff = true;
                    break;
                }   
            }
            // same order chack len
            if(!foundDiff && word1.length() > word2.length()){
                return false;
            }  
        }
        return true;
    }
}