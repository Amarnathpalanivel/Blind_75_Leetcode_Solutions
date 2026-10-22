class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (n == 0 || k < 0) {
            return 0;
        }
        int[] frequency = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;
        for (int right = 0; right < n; right++) {
            int index = s.charAt(right) - 'A';
            frequency[index]++;
 
            maxFrequency = Math.max(
                maxFrequency,
                frequency[index]
            );
            int currentLength =
                right - left + 1;
            if (currentLength - maxFrequency > k) {
                frequency[
                    s.charAt(left) - 'A'
                ]--;
 
                left++;
            }
            currentLength =
                right - left + 1;
 
            maxLength = Math.max(
                maxLength,
                currentLength
            );
        }
        return maxLength;
    }
}