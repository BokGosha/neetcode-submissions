class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        c = 1
        max_c = 1
        nums = sorted(set(nums))
        print(nums)
        for i in range(len(nums) - 1):
            if nums[i + 1] - nums[i] == 1:
                c += 1
                if max_c < c:
                    max_c = c
            else:
                c = 1
        return max_c