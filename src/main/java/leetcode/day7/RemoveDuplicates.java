package leetcode.day7;

/**
 * @author feiyang.duan
 * @date 2025/5/12
 * @description 删除有序数组中的重复项
 * 快慢指针
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
        int length = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println(length);
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i - 1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
