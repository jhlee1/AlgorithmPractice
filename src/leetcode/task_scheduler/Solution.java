package leetcode.task_scheduler;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    class Task {
        char id;
        int count;
        int coolDown;

        Task(char id, int count) {
            this.id = id;
            this.count = count;
            this.coolDown = 0;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int['Z' - 'A' + 1];
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        Queue<Task> taskWaitQueue = new LinkedList<>();
        int result = 0;

        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        for (int i = 0; i < taskCounts.length; i++) {
            if (taskCounts[i] > 0) {
                taskQueue.add(new Task((char) (i + 'A'), taskCounts[i]));
            }
        }

        while (!taskQueue.isEmpty() || !taskWaitQueue.isEmpty()) {
            result++;
            if (!taskQueue.isEmpty()) {
                Task t = taskQueue.poll();
                t.count--;
                if (t.count != 0) {
                    t.coolDown = result + n;
                    taskWaitQueue.add(t);
                }
            }

            if (!taskWaitQueue.isEmpty() && taskWaitQueue.peek().coolDown <= result) {
                taskQueue.add(taskWaitQueue.poll());
            }
        }

        return result;
    }
}