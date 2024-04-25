package leetcode.first_bad_version;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// 278. https://leetcode.com/problems/first-bad-version/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long bottom = 0;
        long top = n;
        n /= 2;
        while (top - bottom > 1) {
            if (isBadVersion(n)) {
                top = n;
            } else {
                bottom = n;
            }
            n = (int)((top + bottom) / 2);
        }

        return (int) top;
    }
}