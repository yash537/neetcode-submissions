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
    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer,Integer> mp=new TreeMap<>();

        for(Interval interval:intervals){
            int start=interval.start;
            int end=interval.end;

            mp.put(start,mp.getOrDefault(start,0)+1);
            mp.put(end,mp.getOrDefault(end,0)-1);
        }

        int cnt=0;
        int maxi=0;

        for(int event:mp.values()){
            cnt+=event;
            maxi=Math.max(maxi,cnt);
        }

        return maxi;
    }
}
