class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> sorted = Arrays.stream(intervals).sorted(Comparator.comparingInt(a -> a[0])).toList();
        List<int[]> output = new ArrayList<>();
        output.add(sorted.getFirst());
        for (int i = 1; i < sorted.size(); i++) {
            int start = sorted.get(i)[0];
            int end = sorted.get(i)[1];
            int lastEnd = output.getLast()[1];
            if (start <= lastEnd) {
                output.getLast()[1] = Integer.max(lastEnd, end);
            } else {
                output.add(new int[]{start, end});
            }
        }

        return output.toArray(new int[output.size()][]);
    }
}
