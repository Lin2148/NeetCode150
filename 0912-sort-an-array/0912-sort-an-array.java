class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] tmp = new int[nums.length];

        mergeSort(nums, 0, nums.length-1, tmp);
        return nums;
    }

    private void mergeSort(int[] arr, int start, int end, int[] tmp){
        // no need sort
        if (start >= end){
            return;
        }

        int mid = start+ (end-start) /2;
        mergeSort(arr, start, mid, tmp);
        mergeSort(arr, mid+1, end, tmp);

        merge(arr, start, mid, end, tmp);
    }

    private void merge(int[] arr, int start, int mid, int end, int[] tmp){
        System.arraycopy(arr, start, tmp, start, end-start+1);
        int i = start;
        int j = mid+1;
        int k = start;
        // compare two part then put into arr
        while (i <= mid && j <= end){
            if (tmp[i] <= tmp[j]){
                arr[k] = tmp[i];
                k++;
                i++;
            } else{
                arr[k] = tmp[j];
                k++;
                j++;
            }
        }
        // left part still hava elem
        while (i <= mid) {
            arr[k] = tmp[i];
            k++;
            i++;
        }
    }
}