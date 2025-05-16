package com.writtenTest;

import java.util.Scanner;
import java.util.Stack;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] heightSrs = line.trim().split("\\s+");
        int[] heights = new int[heightSrs.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(heightSrs[i]);
        }

        System.out.println(largestRectangleArea(heights));
    }

    public static  int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return  maxArea;
    }
}
