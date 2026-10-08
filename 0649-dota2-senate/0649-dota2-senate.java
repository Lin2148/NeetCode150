class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        boolean[] right = new boolean[n];
        Arrays.fill(right, true);

        int rCnt = 0;

        int aliveR = 0;
        int aliveD = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') aliveR++;
            else aliveD++;
        }

        while (aliveR > 0 && aliveD > 0) {
            for(int i = 0; i < n; i++){
                // 計算還能投票的
                if (right[i]){
                    if (senate.charAt(i) == 'R') {
                        if (rCnt < 0) {
                            right[i] = false; 
                            aliveR--;
                        }
                        rCnt++; 
                    } else { // 是 'D'
                        if (rCnt > 0) {
                            right[i] = false; 
                            aliveD--;
                        }
                        rCnt--; 
                    }
                }
            }
        }
        return aliveR > 0 ? "Radiant" : "Dire";
    }
}