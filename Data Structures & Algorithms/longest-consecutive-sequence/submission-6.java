class Solution {
    public static int longestConsecutive(int[] nums) {
        int[] res = Arrays.stream(nums).distinct().toArray();
        int longest = 0;
        for (int num : nums) {
            if (!contains(nums, num - 1)) {
                int length = 0;
                while (contains(nums, num + length)) {
                    length++;
                }
                longest = Integer.max(length, longest);
            }
        }

        return longest;
    }

    private static boolean contains(int[] nums, int num) {
        for (int n : nums) {
            if (n == num) return true;
        }

        return false;
    }
}
