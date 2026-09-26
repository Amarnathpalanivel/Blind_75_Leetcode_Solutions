class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int size = 0;
        for (int num : nums) {
            int left = 0;
            int right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            temp[left] = num;
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}