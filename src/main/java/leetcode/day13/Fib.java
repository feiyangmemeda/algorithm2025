package leetcode.day13;

/**
 * @author feiyang.duan
 * @date 2025/6/19
 * @description 斐波那契数
 * Copyright: 数禾科技 Copyright(c)
 */
public class Fib {

    public static void main(String[] args) {
        int fib = fib(4);
        System.out.println(fib);
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib2(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        if (n >= 1) {
            arr[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            // 循环中不停交换a、b的值
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
