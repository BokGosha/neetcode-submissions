class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), 0, target, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> cur, int total, int target, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (i >= nums.length || total > target) {
            return;
        }

        cur.add(nums[i]);
        dfs(nums, i, cur, total + nums[i], target, res);
        cur.removeLast();
        dfs(nums, i + 1, cur, total, target, res);
    }
}
