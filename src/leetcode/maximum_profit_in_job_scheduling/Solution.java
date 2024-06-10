package leetcode.maximum_profit_in_job_scheduling;

import java.util.*;

class Solution {
    Map<Integer, Integer> dp;
    class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        dp = new HashMap<>();
        Job[] jobs = new Job[startTime.length];

        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }


        Arrays.sort(jobs, Comparator.comparingInt(j -> j.startTime));

        Arrays.stream(jobs).map(job -> job.startTime + " " + job.endTime + " " + job.profit).toList();

        return helper(jobs, 0);

    }

    public int helper(Job[] jobs, int index) {
        if (index >= jobs.length) {
            return 0;
        }

        if (!dp.containsKey(index)) {

            // Not include
            int maxProfit = helper(jobs, index + 1);

            //Include
            int nextIndex = getIndexToStart(jobs, jobs[index].endTime);
            maxProfit = Math.max(maxProfit, helper(jobs, nextIndex) + jobs[index].profit);

            dp.put(index, maxProfit);
        }

        return dp.get(index);
    }

    public int getIndexToStart(Job[] jobs, int currentAt) {
        int floor = 0;
        int ceiling = jobs.length - 1;
        int mid = (floor + ceiling) / 2;


        while (floor <= ceiling) {
            mid = (floor + ceiling) / 2;

            if (jobs[mid].startTime < currentAt) {
                floor = mid + 1;
            } else if (jobs[mid].startTime > currentAt) {
                ceiling = mid - 1;
            } else {
                return mid;
            }
        }
        return mid + 1;
    }

}

