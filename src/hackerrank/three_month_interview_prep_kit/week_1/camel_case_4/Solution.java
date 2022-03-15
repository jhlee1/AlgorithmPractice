package hackerrank.three_month_interview_prep_kit.week_1.camel_case_4;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(";");
            String operator = line[0];
            String indicator = line[1];
            String name = line[2];
            String result = "";

            if (operator.equals("S")) {
                name = name.replace("()", "");
                String tmp = name.replaceAll("[A-Z]", "_");
                int offset = 0;

                while (tmp.contains("_")) {
                    final int index = tmp.indexOf("_") + offset;
                    String stringToReplace = " " + String.valueOf(name.charAt(index)).toLowerCase().toCharArray()[0];
                    tmp = tmp.replaceFirst("_", stringToReplace);
                    offset--;
//                    System.out.println(tmp);
                }

                result = tmp.trim();


            } else if (operator.equals("C")) {
                String[] chunks = name.split(" ");

                if (indicator.equals("C")) {
                    String firstChar = String.valueOf(chunks[0].charAt(0)).toUpperCase();

                    result += firstChar + chunks[0].substring(1);
                } else {
                    result += chunks[0];
                }

                for (int i = 1; i < chunks.length; i ++) {
                    String firstChar = String.valueOf(chunks[i].charAt(0)).toUpperCase();

                    result += firstChar + chunks[i].substring(1);
                }

                if (indicator.equals("M")) {
                    result += "()";
                }

            } else {
                throw new AssertionError("Unexpected operator.");
            }

            System.out.println(result);
        }


    }
}