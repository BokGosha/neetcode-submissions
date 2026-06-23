class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxr = 0;
        while (left < right) {
            int res = Integer.min(heights[left], heights[right]) * (right - left);
            maxr = Integer.max(maxr, res);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxr;
    }
}
