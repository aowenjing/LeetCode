package com.writtenTest;

import java.util.*;

public class StrictlyIncreasingString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            long n = scanner.nextLong();
            scanner.nextLine();
            String s = scanner.nextLine();
            System.out.println(canMakeIncreasing(s) ? "YES" : "NO");
        }
        scanner.close();
    }

    private static boolean canMakeIncreasing(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        //记录第一个和第二个需要交换的位置
        int first = -1, second = -1;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] >= chars[i + 1]) {
                if (count == 0) {
                    first = i;
                } else if (count == 1) {
                    second = i;
                }
                count++;
            }
        }

        //如果不需要交换，检查重复字符
        if(count == 0) {
            Set<Character> set = new HashSet<>();
            for (char c : chars) {
                if (!set.add(c)) {
                    return true;
                }
            }
            return false;
        }

        //如果交换1个
        if (count == 1) {
            swap(chars, first, first + 1);
            boolean case1 = isIncreasing(chars);
            swap(chars, first, first + 1); //恢复

            if(!case1) {
                char target = ' ';
                int pos = -1;
                //找到比chars[first + 1]大的最小字符
                for (int i = first + 2; i < n; i++) {
                    if (chars[i] > chars[first + 1] && (target == ' ' || chars[i] < target)) {
                        target = chars[i];
                        pos = i;
                    }
                }
                //找到了
                if (pos != -1) {
                    swap(chars, first, pos);
                    boolean case2 = isIncreasing(chars);
                    swap(chars, first, pos);
                    if(!case2) return true;
                }
                //找到比chars[first]小的最大字符
                target = ' ';
                pos = -1;
                for (int i = 0; i < first; i++) {
                    if (chars[i] > chars[first] && (target == ' ' || chars[i] > target)) {
                        target = chars[i];
                        pos = i;
                    }
                    //找到了
                    if (pos != -1) {
                        swap(chars, first + 1, pos);
                        boolean case3 = isIncreasing(chars);
                        swap(chars, first + 1, pos);
                        if(!case3) return true;
                    }
                    return false;
                }

            }
            return true;
        }
        if (count > 1) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    swap(chars, i, j);
                    boolean possible = isIncreasing(chars);
                    swap(chars, i, j);
                    if(possible) return true;
                }
            }
        }
        return false;
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    private static boolean isIncreasing(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] >= chars[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
