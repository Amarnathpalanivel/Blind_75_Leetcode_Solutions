class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int value : nums) {
            values.add(value);
        }
        int longestLength = 0;
        for (int value : values) {
            if (values.contains(value - 1)) {
                continue;
            }
            int currentLength = 1;
            int nextValue = value + 1;
            while (values.contains(nextValue)) {
                currentLength++;
                nextValue++;
            }
            longestLength = Math.max(longestLength, currentLength);
        }
        return longestLength;
    }
}