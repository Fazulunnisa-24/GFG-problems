class Solution {
    int transform(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }

        int n = s1.length();

        // Check whether both strings contain the same characters
        int[] freq = new int[256];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int x : freq) {
            if (x != 0) {
                return -1;
            }
        }

        // Match s2 from the end using characters of s1.
        // Characters that cannot be matched need to be moved.
        int i = n - 1;
        int j = n - 1;
        int matched = 0;

        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                matched++;
                j--;
            }
            i--;
        }

        return n - matched;
    }
}