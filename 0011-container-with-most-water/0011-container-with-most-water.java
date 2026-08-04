class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = Math.min(height[left], height[right]) * (right - left); 
        while (left < right){
            if (height[left] < height[right]){
                left++;
                int newAns = Math.min(height[left], height[right]) * (right - left); 
                ans = Math.max(newAns, ans);
            } else{
                right--;
                int newAns = Math.min(height[left], height[right]) * (right - left); 
                ans = Math.max(newAns, ans);
            }
        }
        return ans;
    }
}