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
    public static boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return true;
        }

        List<Interval> sorted = intervals.stream().sorted(Comparator.comparingInt(a -> a.start)).toList();
        int prevEnd = sorted.getFirst().end;
        for (Interval interval : sorted.subList(1, sorted.size())) {
            if (interval.start < prevEnd) {
                return false;
            }
            prevEnd = interval.end;
        }

        return true;
    }
}
