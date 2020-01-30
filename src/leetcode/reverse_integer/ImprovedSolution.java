package leetcode.reverse_integer;

/**
 * Created by Joohan Lee on 2020/01/30
 */
public class ImprovedSolution {
    public int reverse(int input) {
        long result = 0;

        while (input != 0) {
            result = result * 10 + input % 10;
            input = input / 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) result;
    }
}



