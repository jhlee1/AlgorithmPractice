package leetcode.ipo;

import java.util.Comparator;
import java.util.PriorityQueue;

// 502. IPO https://leetcode.com/problems/ipo/description/

class Solution {
    class Project {
        int profit;
        int capital;
        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> projects = new PriorityQueue<>(Comparator.comparingInt(p -> p.capital));
        PriorityQueue<Project> possibleProjects = new PriorityQueue<>((p1, p2)-> p2.profit - p1.profit);

        for (int i = 0; i < profits.length; i++) {
            Project p = new Project(profits[i], capital[i]);
            projects.add(p);
        }

        for (int i = 0; i < k; i++) {
            while (!projects.isEmpty() && projects.peek().capital <= w) {
                possibleProjects.add(projects.poll());
            }
            if (possibleProjects.isEmpty()) {
                break;
            }
            w += possibleProjects.poll().profit;
        }

        return w;
    }

}