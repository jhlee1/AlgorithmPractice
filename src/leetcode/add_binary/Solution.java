package leetcode.add_binary;

class Solution {
    public String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        int sum = 0;
        int aLength = a.length();
        int bLength = b.length();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= maxLength; i++) {
            if (aLength >= i) {
                sum += (a.charAt(aLength - i) - '0');
            }

            if (bLength >= i) {
                sum += (b.charAt(bLength - i) - '0');
            }

            if (sum > 1) {
                sum -= 2;
                result.append(sum);
                sum = 1;
            } else {
                result.append(sum);
                sum = 0;
            }
        }

        if (sum > 0) {
            result.append(1);
        }

        return result.reverse().toString();
    }
}