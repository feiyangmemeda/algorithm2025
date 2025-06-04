package leetcode.day5;

/**
 * @author feiyang.duan
 * @date 2025/4/25
 * @description 盛最多水的容器
 */
public class MaxArea {

    public static void main(String[] args) {
        //int i = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        int i = maxArea(new int[]{1, 1});
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            if (height[i] > height[j]) {
                max = Math.max((j - i) * height[j], max);
                j--;
            } else {
                max = Math.max((j - i) * height[i], max);
                i++;
            }
        }
        return max;
    }

}
