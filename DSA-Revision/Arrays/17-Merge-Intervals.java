Problem Description

You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Problem Constraints

0 <= |intervals| <= 105

Input Format

First argument is the vector of intervals

second argument is the new interval to be merged

Output Format
Return the vector of intervals after merging

Example Input
Input 1:
Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:
Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
Output 1:
 [ [1, 5], [6, 9] ]

Output 2:
 [ [1, 9] ]


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<>();
        int i = 0;

        // Process all intervals ending before the start of the new interval
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }

        // Merge all overlapping intervals
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        // Add the merged interval
        result.add(newInterval);

        // Add all the remaining intervals
        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }

        return result;



    }
}



======================================================================================================================================


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.ArrayList;

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        int N = intervals.size();
        ArrayList<Interval> ans = new ArrayList<>();

        int s1 = newInterval.start;
        int e1 = newInterval.end;
        boolean inserted = false;

        for (int i = 0; i < N; i++) {
            int s2 = intervals.get(i).start;
            int e2 = intervals.get(i).end;

            if (e2 < s1) {
                // The current interval ends before the new interval starts, so no overlap
                ans.add(new Interval(s2, e2));
            } else if (s2 > e1) {
                // The current interval starts after the new interval ends, so no overlap
                if (!inserted) {
                    // Insert the merged interval before adding the current interval
                    ans.add(new Interval(s1, e1));
                    inserted = true;
                }
                ans.add(new Interval(s2, e2));
            } else {
                // There is overlap, merge intervals
                s1 = Math.min(s1, s2);
                e1 = Math.max(e1, e2);
            }
        }

        // If the new interval wasn't added, add it now
        if (!inserted) {
            ans.add(new Interval(s1, e1));
        }

        return ans;
    }
}



