class Solution {
    public boolean hasDuplicate(int[] nums) {
        return !Arrays.equals(Arrays.stream(nums).distinct().toArray(), nums);
    }
}