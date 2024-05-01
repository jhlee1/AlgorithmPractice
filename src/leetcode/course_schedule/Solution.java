package leetcode.course_schedule;


import java.util.*;

// 207. Course Schedule https://leetcode.com/problems/course-schedule/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseRequirements = new HashMap<>();
        Set<Integer> graphedNum = new HashSet<>();

        for (int[] preRequisite : prerequisites) {
            courseRequirements.putIfAbsent(preRequisite[0], new ArrayList<>());
            courseRequirements.get(preRequisite[0]).add(preRequisite[1]);
        }

        for (Integer currentCourse : courseRequirements.keySet()) {
            graphedNum.add(currentCourse);
            if (!checkFinishable(courseRequirements, currentCourse, graphedNum)) {
                return false;
            }
            graphedNum.remove(currentCourse);
        }

        return true;
    }

    public boolean checkFinishable(Map<Integer, List<Integer>> courseRequirements, Integer currentCourse, Set<Integer> graphedNum) {
        if (!courseRequirements.containsKey(currentCourse)) {
            return true;
        }

        for (Integer preRequisite : courseRequirements.get(currentCourse)) {
            if (graphedNum.contains(preRequisite)) {
                return false;
            }
            graphedNum.add(preRequisite);
            if (!checkFinishable(courseRequirements, preRequisite, graphedNum)) {
                return false;
            }
            graphedNum.remove(preRequisite);
        }
        courseRequirements.get(currentCourse).clear();


        return true;
    }
}
