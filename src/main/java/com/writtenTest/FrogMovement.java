package com.writtenTest;
import java.util.*;

public class FrogMovement {
    private static void setBit(long[] bits, int position) {
        int index = (position - 1) / 64;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        String instructions = in.nextLine();
        in.close();

        int size = (n + 63) / 64;
        long[] current = new long[size];
        long[] next = new long[size];

        setBit(current, k);


//        boolean[] possibleEndpoints = new boolean[n + 1];
//
//        Set<Integer> curretnPositions = new HashSet<>();
//        curretnPositions.add(k);
//        for (char instruction : instructions.toCharArray()) {
//            Set<Integer> nextPositions = new HashSet<>();
//
//            for (int currentPos : curretnPositions) {
//                if (instruction == 'L' || instruction == '?') {
//                    //向左移动，如果位于1则不动
//                    int newPos = (currentPos > 1) ? currentPos - 1 : currentPos;
//                    nextPositions.add(newPos);
//                }
//                if (instruction == 'R' || instruction == '?') {
//                    //向左移动，如果位于1则不动
//                    int newPos = (currentPos < n) ? currentPos + 1 : currentPos;
//                    nextPositions.add(newPos);
//                }
//            }
//            //更新位置集合
//            curretnPositions = nextPositions;
//        }
//
//        for (int pos : curretnPositions) {
//            possibleEndpoints[pos] = true;
//        }
//
//        StringBuilder res = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            res.append(possibleEndpoints[i] ? '1' : '0');
//        }
//        System.out.println(res.toString());
    }
}
