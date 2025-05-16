package com.writtenTest;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx
public class BeautifulNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        in.close();

        boolean[] isPretty = new boolean[n + 1];
        //预处理所有漂亮数
        for(int i = 2; i <= n; i++){
            //i是质数
            if(isPrime(i)) {
                long squarel = (long) i * i;
                for(int j = i; j <= n && (long)j <= squarel; j += i){
                    isPretty[j] = true;
                }
            }
        }
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(isPretty[i]){
                count++;
            }
        }
        System.out.println(count);
    }
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
