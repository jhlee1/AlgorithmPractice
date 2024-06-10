package leetcode.greatest_common_divisor_of_strings;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int minStringLength = Math.min(str1.length(), str2.length());

        for (int i = minStringLength; i >= 0; i--) {
            if (str1.length() % i == 0 && str2.length() % i == 0) {
                int factor1 = str1.length() / i;
                int factor2 = str2.length() / i;

                if (str1.equals(str1.substring(0, i).repeat(factor1)) && str2.equals(str2.substring(0, i).repeat(factor2))) {
                    return str1.substring(0, i);
                }
            }
        }


        return "";
    }
}
