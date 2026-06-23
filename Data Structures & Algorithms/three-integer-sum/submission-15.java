class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 3) return res;
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[left] + nums[i] + nums[right];
                if (threeSum > 0) {
                    right--;
                } else if (threeSum < 0) {
                    left++;
                } else {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                }
            }
        }

        return res;
    }
}
