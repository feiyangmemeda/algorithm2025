package leetcode.day2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author feiyang.duan
 * @date 2025/4/21
 * @description 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "loddktdji";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int max = 1;
        int index = 0;
        for (int i = 0; i < charArray.length; i++) {
            Map<Character, Integer> map = new HashMap<>();
            if (index == charArray.length - 1) {
                break;
            }
            for (int j = index; j < charArray.length; j++) {
                if (map.get(charArray[j]) != null) {
                    int maxSize = map.size();
                    if (maxSize > max) {
                        max = maxSize;
                    }
                    index = map.get(charArray[j]) + 1;
                    break;
                } else {
                    map.put(charArray[j], j);
                    index++;
                    if (j == charArray.length - 1) {
                        int maxSize = map.size();
                        if (maxSize > max) {
                            max = maxSize;
                        }
                    }
                }
            }
        }
        return max;
    }

    /**
     * 正确题解：滑动窗口
     * 相当于遍历，每次从下一个字符的下标开始循环
     */
    public static int lengthOfLongestSubstring2(String s) {
        //滑动窗口
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();//去重
        int res = 0;//结果
        for (int left = 0, right = 0; right < s.length(); right++) {//每一轮右端点都扩一个。
            char ch = ss[right];//right指向的元素，也是当前要考虑的元素
            while (set.contains(ch)) {//set中有ch，则缩短左边界，同时从set集合出元素
                set.remove(ss[left]);
                left++;
            }
            set.add(ss[right]);//将当前元素加入。
            res = Math.max(res, right - left + 1);//计算当前不重复子串的长度。
        }
        return res;
    }

}
