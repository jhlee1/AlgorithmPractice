package leetcode.flood_fill;

// 733. https://leetcode.com/problems/flood-fill/description/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        color(image, sr, sc, color, image[sr][sc]);

        return image;
    }

    public void color(int[][] image, int sr, int sc, int color, int sourceColor) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length || image[sr][sc] == color || image[sr][sc] != sourceColor) {
            return;
        }

        image[sr][sc] = color;

        color(image, sr - 1, sc, color, sourceColor);
        color(image, sr + 1, sc, color, sourceColor);
        color(image, sr, sc - 1, color, sourceColor);
        color(image, sr, sc + 1, color, sourceColor);
    }
}