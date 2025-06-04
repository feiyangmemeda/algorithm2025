package leetcode.day3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feiyang.duan
 * @date 2025/4/23
 * @description 整数反转
 */
public class Reverse {

    public static void main(String[] args) {
        int reverse = reverse(123);
        System.out.println(reverse);
    }


    public static int reverse(int x) {
        // 取出最后一位
        int result = 0;
        while (Math.abs(x) != 0) {
            if (result > (Integer.MAX_VALUE / 10) || result < (Integer.MIN_VALUE / 10)) {
                return 0;
            }
            int lastNum = x % 10;
            x = x / 10;
            result = result * 10 + lastNum;
        }
        return result;
    }
}
