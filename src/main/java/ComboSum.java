import java.util.ArrayList;
import java.util.List;

class ComboSum {
    public static void main(String[] args) {
        new ComboSum().combinationSum(new int[] { 2, 3, 5 }, 8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int candidate : candidates) {
            sum(candidates, target, 0, new ArrayList<>(), res);
        }
        return res;
    }

    private void sum(int[] nums, int target, int prevSum, List<Integer> combo, List<List<Integer>> allCombos) {
        for (int num : nums) {
            int currentSum = prevSum + num;
            if (currentSum < target) {
                combo.add(num);
                sum(nums, target, currentSum, combo, allCombos);
            } else if (currentSum == target) {
                List<Integer> res = new ArrayList<>(combo);
                res.add(num);
                allCombos.add(res);
                return;
            }
        }
    }
}