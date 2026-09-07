class Solution {
    public String mergeAlternately(String word1, String word2) {
        int ptr = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++){
            sb.append(word1.charAt(i));
            // word1 longer
            if (ptr < word2.length()){
                sb.append(word2.charAt(ptr));
                ptr++;
            }
        }

        // word2 longer;
        if (ptr < word2.length()){
            sb.append(word2, ptr, word2.length());
        }
        return sb.toString();
    }
}