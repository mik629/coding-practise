class MedianOfTwoSortedArraysOfDifferentSize {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (findMedian(total / 2 + 1, nums1, nums2, 0, 0) +
                    findMedian(total / 2, nums1, nums2, 0, 0)) / 2.0;
        } else {
            return findMedian(total / 2 + 1, nums1, nums2, 0, 0);
        }
    }

    private double findMedian(int totalMiddle, int[] nums1, int[] nums2, int start1, int start2) {
        if (start1 >= nums1.length) {
            return nums2[start2 + totalMiddle - 1];
        }

        if (start2 >= nums2.length) {
            return nums1[start1 + totalMiddle - 1];
        }

        if (totalMiddle == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int median1Index = start1 + totalMiddle / 2 - 1;
        int median2Index = start2 + totalMiddle / 2 - 1;

        int median1 = median1Index < nums1.length ? nums1[median1Index] : Integer.MAX_VALUE;
        int median2 = median2Index < nums2.length ? nums2[median2Index] : Integer.MAX_VALUE;

        if (median1 < median2) {
            return findMedian(totalMiddle - totalMiddle / 2, nums1, nums2, median1 + 1, start2);
        } else {
            return findMedian(totalMiddle - totalMiddle / 2, nums1, nums2, start1, median2 + 1);
        }
    }
}