package programmers.practice_kit.hash.level2_phonebook;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        boolean result = solution(new String[] {"123","456","789"});

        System.out.println(result);
    }

    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);

        for (int startAt = 0; startAt < phoneBook.length - 1; startAt++) {
            for (int i = startAt + 1; i < phoneBook.length; i++) {
                if (phoneBook[i].startsWith(phoneBook[startAt])) {
                    return false;
                } else {
                    break;
                }
            }
        }

        return true;
    }
}
