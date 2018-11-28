package com.mjolnir.interview.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 23/03/2018
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval == null){
            return intervals;
        }

        List<Interval> resInterval = new ArrayList<>();
        Interval temp = newInterval;
        if (intervals.isEmpty()){
            resInterval.add(newInterval);
            return resInterval;
        }
        for (Interval interval : intervals){
            if (temp != null){
                if (newInterval.end < interval.start){
                    resInterval.add(temp);
                    resInterval.add(interval);
                    temp = null;
                }
                else if (newInterval.end == interval.start){
                    Interval mergeInterval = new Interval(newInterval.start, interval.end);
                    resInterval.add(mergeInterval);
                    temp = null;
                }
                else if (interval.end < newInterval.start){
                    resInterval.add(interval);
                    resInterval.add(newInterval);
                    temp = null;
                }
                else if (interval.end == newInterval.start){
                    Interval mergeInterval = new Interval(interval.start, newInterval.end);
                    resInterval.add(mergeInterval);
                    temp = null;
                }
                else {
                    resInterval.add(interval);
                }
            }
            else {
                resInterval.add(interval);
            }


        }

        return resInterval;

    }


    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {

        if (intervals == null || newInterval == null){
            return intervals;
        }

        List<Interval> resInterval = new ArrayList<>();
        int pos = 0;

        for (Interval interval : intervals){

            if (interval.end < newInterval.start){
                resInterval.add(interval);
                pos++;
            }
            else if (interval.start > newInterval.end){
                resInterval.add(interval);
            }
            else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }

        }

        resInterval.add(pos, newInterval);
        return resInterval;

    }

}
