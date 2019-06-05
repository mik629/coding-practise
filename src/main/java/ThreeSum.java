import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        new ThreeSum().find(nums, n, target);
    }

    public Set<List<Integer>> find(int[] nums, int n, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ind3 = Arrays.binarySearch(Arrays.copyOfRange(nums, j + 1, n), target - nums[i] - nums[j]);
                if (ind3 >= 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[j + 1 + ind3]));
                }
            }
        }
        return res;
    }
}
