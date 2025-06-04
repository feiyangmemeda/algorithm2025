package leetcode.day3;

/**
 * @author feiyang.duan
 * @date 2025/4/22
 * @description 最长回文子串
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String abc = "abcdefgabcba123456";
        String result = longestPalindrome(abc);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String result = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder().append(s.charAt(i));
            int right = i + 1;
            while (right < s.length()) {
                sb.append(s.charAt(right));
                if (sb.toString().contentEquals(sb.reverse())) {
                    int range = right - i;
                    if (range > max) {
                        max = range;
                        result = sb.toString();
                    }
                }
                // 反转回去
                sb.reverse();
                right++;
            }
        }
        if (result.equals("")) {
            return s.substring(0, 1);
        }
        return result;
    }

    /**
     * 动态规划
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        // 初始化 dp 数组
        boolean[][] dp = new boolean[n][n];
        // 单个字符是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 1;
        // 枚举子串长度
        for (int len = 2; len <= n; len++) {
            // 枚举子串的起始位置
            for (int i = 0; i < n; i++) {
                int j = i + len - 1;
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 更新最长回文子串的信息
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


}
