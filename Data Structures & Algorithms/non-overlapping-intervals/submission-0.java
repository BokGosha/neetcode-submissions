class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> sorted = Arrays.stream(intervals).sorted(Comparator.comparingInt(a -> a[0])).toList();
        int res = 0;
        int prevEnd = sorted.get(0)[1];
        for (int i = 1; i < sorted.size(); i++) {
            int start = sorted.get(i)[0];
            int end = sorted.get(i)[1];
            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                res++;
                prevEnd = Integer.min(prevEnd, end);
            }
        }
        
        return res;
    }
}
