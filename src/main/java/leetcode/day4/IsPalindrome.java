package leetcode.day4;

/**
 * @author feiyang.duan
 * @date 2025/4/24
 * @description 回文数
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (0 < x && x < 9) {
            return true;
        }
        int result = 0;
        int y = x;
        while (x != 0) {
            int num = x % 10;
            x = x / 10;
            result = result * 10 + num;
        }
        return result == y;
    }
}
