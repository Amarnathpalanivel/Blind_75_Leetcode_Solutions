class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0 || m == 0 || n < m) {
            return "";
        }
        int[] need = new int[128];
        int[] window = new int[128];
        for (int i = 0; i < m; i++) {
            need[t.charAt(i)]++;
        }
        int left = 0;
        int matched = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        for (int right = 0; right < n; right++) {
            char current = s.charAt(right);
            window[current]++;
            if (
                need[current] > 0 &&
                window[current] <= need[current]
            ) {
                matched++;
            }
            while (matched == m) {
                int currentLength =
                    right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                window[leftChar]--;
                if (
                    need[leftChar] > 0 &&
                    window[leftChar] < need[leftChar]
                ) {
                    matched--;
                }
                left++;
            }
        }
        if (startIndex == -1) {
            return "";
        }
        return s.substring(
            startIndex,
            startIndex + minLength
        );
    }
}