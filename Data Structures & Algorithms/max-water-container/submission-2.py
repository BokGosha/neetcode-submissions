class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l, r = 0, len(heights)-1
        maxr = 0
        while l < r:
            res = min(heights[l], heights[r]) * (r - l)
            maxr = max(maxr, res)
            if heights[l] < heights[r]:
                l += 1
            elif heights[l] > heights[r]:
                r -= 1
            else:
                l += 1
        return maxr