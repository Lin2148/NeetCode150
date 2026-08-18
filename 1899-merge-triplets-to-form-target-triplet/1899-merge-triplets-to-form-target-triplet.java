class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] max = new int[3];
        for (int[] tri : triplets){
            if (Arrays.equals(tri, target)){
                return true;
            }
            // fliter to large tri
            if (tri[0] > target[0] || tri[1] > target[1] || tri[2] > target[2]){
                continue;
            } else{
                max = maxTri(max, tri);
                if (Arrays.equals(max, target)){
                    return true;
                }
            }
        }
        return false;
    }
    private int[] maxTri (int[] a, int[] b){
        int[] max = new int[3];

        for (int i = 0; i < 3; i++){
            max[i] = Math.max(a[i],b[i]);
        }
        return max;
    }
}