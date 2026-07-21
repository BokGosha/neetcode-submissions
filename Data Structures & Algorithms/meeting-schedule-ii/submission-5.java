/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public static int minMeetingRooms(List<Interval> intervals) {
        List<Integer> starts = intervals.stream().map(i -> i.start).sorted().toList();
        List<Integer> ends = intervals.stream().map(i -> i.end).sorted().toList();

        int res = 0;
        int count = 0;
        int s = 0;
        int e = 0;
        while (s < intervals.size()){
            if (starts.get(s) < ends.get(e)){
                count++;
                s++;
            } else {
                count--;
                e++;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}
