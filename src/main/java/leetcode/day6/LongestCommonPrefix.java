package leetcode.day6;

/**
 * @author feiyang.duan
 * @date 2025/4/27
 * @description 最长公共前缀
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = {"dog","racecar","car"};
        String longest = longestCommonPrefix(strings);
        System.out.println(longest);
    }


    public static String longestCommonPrefix(String[] strs) {
        // 取出最短长度
        int min = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }
        // 开始遍历
        StringBuilder sb = new StringBuilder();
        String str1 = strs[0];
        loop1:
        for (int i = 0; i < min; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (str1.charAt(i) != strs[j].charAt(i)) {
                    break loop1;
                }
            }
            sb.append(str1.charAt(i));
        }
        return sb.toString();
    }
}
