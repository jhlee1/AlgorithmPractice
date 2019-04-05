package hackerrank.interview_prep_kit.sorting.fraudulent_activity_notifications;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Solution {
    static int activityNotifications(int[] expenditure, int d) {
        int firstNum = 0;
        int secondNum = 0;
        int noti = 0;
        int[] frequencies = new int [201];
        int medianIndex = d / 2;
        boolean odd = d % 2 != 0 ? true : false;

        for(int i = 0; i < d; i++) {
            frequencies[expenditure[i]]++;
        }

        for(int i = d; i < expenditure.length; i++) {
            int currentAt = 0;

            for(int j = 0; j < frequencies.length; j++) {
                currentAt += frequencies[j];

                if(currentAt >= medianIndex) {
                    firstNum = j;
                    break;
                }
            }

            for(int j = firstNum; j < frequencies.length; j++) {
                if(currentAt >= (medianIndex + 1)) {
                    secondNum = j;
                    break;
                }
                currentAt += frequencies[j + 1];
            }

            if(odd) {
                if(expenditure[i] >= secondNum * 2) {
                    noti++;
                }
            } else {
                if(expenditure[i] >= firstNum + secondNum) {
                    noti++;
                }
            }

            frequencies[expenditure[i]]++;
            frequencies[expenditure[i-d]]--;
        }

        return noti;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
