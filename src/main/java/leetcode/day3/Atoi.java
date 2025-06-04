package leetcode.day3;

/**
 * @author feiyang.duan
 * @date 2025/4/23
 * @description 类的描述信息
 * Copyright: 数禾科技 Copyright(c)
 */
public class Atoi {

    public static void main(String[] args) {
        int i = myAtoi("-2147483649");
        System.out.println(i);
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String trim = s.trim();
        if (trim.length() == 0) {
            return 0;
        }
        int result = 0;
        boolean isMinus = false;
        if (trim.charAt(0) == '-') {
            trim = trim.substring(1);
            isMinus = true;
            if (trim.length() == 0) {
                return 0;
            }
        } else if (trim.charAt(0) == '+') {
            trim = trim.substring(1);
            if (trim.length() == 0) {
                return 0;
            }
        }

        for (int i = 0; i < trim.length(); i++) {
            if (trim.charAt(i) > '9' || trim.charAt(i) < '0') {
                break;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && trim.charAt(i) > '8')) {
                return Integer.MIN_VALUE;
            }
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && trim.charAt(i) > '7')) {
                return Integer.MAX_VALUE;
            }
            if (isMinus) {
                result = result * 10 + (-1) * Integer.parseInt(String.valueOf(trim.charAt(i)));
            } else {
                result = result * 10 + Integer.parseInt(String.valueOf(trim.charAt(i)));
            }

        }
        return result;
    }
}
