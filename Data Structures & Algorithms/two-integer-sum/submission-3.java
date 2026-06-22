class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] answer = new int[]{i, map.get(target - nums[i])};
                return Arrays.stream(answer).sorted().toArray();
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
