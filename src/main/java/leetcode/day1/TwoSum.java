package leetcode.day1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author feiyang.duan
 * @date 2025/4/17
 * @description two num sum
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSumForHash(nums, 17);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num2 = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == num2) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static int[] twoSumForHash(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
