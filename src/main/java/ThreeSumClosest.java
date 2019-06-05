import java.util.Arrays;

class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[] { 1, 2, 4, 8, 16, 32, 64, 128 }, 82) == 82);
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[] { -55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33 }, 0) == 0);
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[] { 1, -3, 3, 5, 4, 1 }, 1) == 1);
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[] { 1, 1, 1, 0 }, -100) == 2);
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[] { -1, 0, 1, 1, 55 }, 3) == 2);
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[] { 0, 1, 2 }, 3) == 3);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int closestSum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int currSum = nums[i] + nums[j] + binarySearch(nums, j + 1, nums.length - 1, target - nums[i] - nums[j]);
                int currentDiff = Math.abs(currSum - target);
                if (currentDiff < min) {
                    min = currentDiff;
                    closestSum = currSum;
                }

                if (currSum == target) {
                    return currSum;
                }
            }
        }

        return closestSum;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        if (target <= nums[low]) {
            return nums[low];
        } else if (target >= nums[high]) {
            return nums[high];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = nums[mid];

            if (midVal == target) {
                return midVal;
            } else if (target < midVal) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return nums[low] - target < target - nums[high] ? nums[low] : nums[high];
    }
}