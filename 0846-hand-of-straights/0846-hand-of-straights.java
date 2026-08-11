class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int length = hand.length;
        if (length % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);

        // map  num, count 
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : hand){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }

        for (int i : hand){
            if (hm.get(i)==0){
                continue;
            }

            for (int j=0; j<groupSize; j++){
                int cur = i+j;
                int count = hm.getOrDefault(cur,0);
                if (count == 0){
                    return false;
                }
                hm.put(cur,count-1);
            }
        }
        return true;
    }
}