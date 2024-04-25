package leetcode.k_closest_points_to_origin;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

// 973. https://leetcode.com/problems/k-closest-points-to-origin/description/

class Solution {

    public class Point {
        int[] coordinates;
        double distance;
        public Point(int x, int y) {
            coordinates = new int[]{x, y};
            distance = Math.sqrt(x * x + y * y);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> kClosestPoints = new PriorityQueue<>(points.length, Comparator.<Point>comparingDouble(value -> value.distance));
        int[][] result = new int[k][2];
        for (int[] point : points) {
            kClosestPoints.add(new Point(point[0], point[1]));
        }

        for (int i = 0; i < k; i++) {
            result[i] = kClosestPoints.poll().coordinates;
        }

        return result;
    }
}