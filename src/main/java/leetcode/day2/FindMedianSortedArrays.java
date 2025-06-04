package leetcode.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author feiyang.duan
 * @date 2025/4/21
 * @description 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {6,7,8,9,10,11,12,13,14,15,16,17};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return ((double) (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2])) / 2;
            } else {
                return nums2[nums2.length / 2];
            }
        }
        if (nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return ((double) (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2])) / 2;
            } else {
                return nums1[nums1.length / 2];
            }
        }
        // 合并数组,因为两个数组是已经进行过排序的
        int n = Math.max(nums1.length, nums2.length);
        // 交换位置，长度长的为1，短的为2
        if (nums1.length < nums2.length) {
            int[] temp = Arrays.copyOf(nums2, nums2.length);
            nums2 = nums1;
            nums1 = temp;
        }
        List<Integer> list = new ArrayList<>(nums1.length + nums2.length);

        int lastIndex1 = 0;
        int lastIndex2 = 0;

        // 必定有一个先遍历完
        for (int i = 0, j = 0; i < n; ) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                list.add(nums2[j]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
            lastIndex1 = i;
            lastIndex2 = j;
            if (nums2.length <= j) {
                break;
            }
        }

        // 将剩余元素全部加入
        if (lastIndex1 < nums1.length) {
            for (int i = lastIndex1; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
        }

        if (lastIndex2 < nums2.length) {
            for (int i = lastIndex2; i < nums2.length; i++) {
                list.add(nums2[i]);
            }
        }

        // 找出中位数
        if (list.size() == 2) {
            return ((double) list.get(0) + list.get(1)) / 2;
        }
        if (list.size() % 2 == 0) {
            int left = list.size() / 2 - 1;
            int right = list.size() / 2;
            return ((double) (list.get(left) + list.get(right))) / 2;

        } else {
            return list.get(list.size() / 2);
        }


    }
}
