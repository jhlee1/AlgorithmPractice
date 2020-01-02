package leetcode.median_of_two_sorted_arrays;

/**
 * Created by Joohan Lee on 2020/01/02
 */
public class Solution {
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int medianIndex = (nums1.length + nums2.length) / 2 - 1;
    int[] combinedArray = new int[medianIndex + 2];
    int i = 0, j = 0;

    while (
        i < nums1.length
            && j < nums2.length
            && i + j <= medianIndex + 1) {
      if (nums1[i] <= nums2[j]) {
        combinedArray[i + j] = nums1[i];
        i++;
      } else {
        combinedArray[i + j] = nums2[j];
        j++;
      }
    }

    if (i >= nums1.length) {
      while (i + j <= medianIndex + 1) {
        combinedArray[i + j] = nums2[j];
        j++;
      }
    }

    if (j >= nums2.length) {
      while (i + j <= medianIndex + 1) {
        combinedArray[i + j] = nums1[i];
        i++;
      }
    }

    if ((nums1.length + nums2.length) % 2 == 0) {
      return (combinedArray[medianIndex] + combinedArray[medianIndex + 1]) / 2.0;
    } else {
      return combinedArray[medianIndex + 1];
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2};
    int[] nums2 = {1, 2, 3, 4, 5, 6};

    System.out.println(findMedianSortedArrays(nums1, nums2));
  }
}
