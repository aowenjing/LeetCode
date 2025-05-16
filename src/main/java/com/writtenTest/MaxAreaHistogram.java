package com.writtenTest;

import java.util.*;

public class MaxAreaHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        System.out.println(longestPallindromeSubstring(s));
    }
    private static int longestPallindromeSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenters(s, i, i);
            int len2 = expandAroundCenters(s, i, i + 1);

            int currentMax = Math.max(len1, len2);
            maxLength = Math.max(maxLength, currentMax);
        }
        return maxLength;
    }
    private static int expandAroundCenters(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
