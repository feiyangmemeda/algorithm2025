package leetcode.day4;

/**
 * @author feiyang.duan
 * @date 2025/4/24
 * @description .和*的正则匹配
 */
public class IsMatch {

    public static void main(String[] args) {
        boolean abc = isMatch("aa", "aa");
        System.out.println(abc);
    }


    public static boolean isMatch(String s, String p) {
        char[] pCharArray = p.toCharArray();
        char[] sCharArray = s.toCharArray();
        int index = 0;
        loop1:
        for (int j = index; j < pCharArray.length; j++) {
            char p1 = pCharArray[j];
            loop2:
            for (int i = index; i < sCharArray.length; i++) {
                if (p1 == '*') {
                    index++;
                    break loop2;
                }
                if (p1 == '.') {
                    index++;
                    continue loop1;
                }
                if (p1 != sCharArray[i]) {
                    return false;
                } else {
                    // 若p到了数组末尾，但s仍有元素
                    if (index == pCharArray.length - 1 && index < sCharArray.length - 1) {
                        return false;
                    }
                    // 若s到了数组末尾，p仍有元素
                    if (index == sCharArray.length - 1 && index < pCharArray.length - 1) {
                        return false;
                    }
                    index++;
                    continue loop1;
                }
            }
        }
        return true;
    }
}