import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class FourSumN3LogN {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    int l = binarySearch(nums, k + 1, nums.length - 1, target - nums[i] - nums[j] - nums[k]);
                    if (l > -1) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        if (target < nums[low] || target > nums[high]) {
            return -1;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = nums[mid];

            if (midVal == target) {
                return mid;
            } else if (target < midVal) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}