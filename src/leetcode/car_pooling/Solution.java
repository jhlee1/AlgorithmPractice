package leetcode.car_pooling;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] locations = new int[1001];

        for (int[] trip : trips) {
            locations[trip[1]] += trip[0];
            locations[trip[2]] -= trip[0];
        }

        int numOfPassengers = 0;
        for (int location = 0; location < locations.length; location++) {
            numOfPassengers += locations[location];
            if (numOfPassengers > capacity) {
                return false;
            }
        }

        return true;

    }
}
