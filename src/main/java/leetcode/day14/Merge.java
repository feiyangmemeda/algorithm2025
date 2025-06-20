package leetcode.day14;

import java.util.Arrays;

/**
 * @author feiyang.duan
 * @date 2025/6/20
 * @description 合并两个有序数组
 * Copyright: 数禾科技 Copyright(c)
 */
public class Merge {


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            // nums只保留前m位
            int[] newArray = new int[m];
            for (int i = 0; i < m; i++) {
                newArray[i] = nums1[i];
            }
            for (int i = 0; i < m; i++) {
                nums1[i] = newArray[i];
            }
            return;
        }
        // 双指针
        int[] newArray = new int[m + n];
        int index = 0;
        for (int i = 0, j = 0; index < m + n; index++) {
            if (j >= n) {
                newArray[index] = nums1[i];
                i++;
                continue;
            }
            if (i >= m) {
                newArray[index] = nums2[j];
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                newArray[index] = nums1[i];
                i++;
            } else {
                newArray[index] = nums2[j];
                j++;
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = newArray[i];
        }
    }
}
