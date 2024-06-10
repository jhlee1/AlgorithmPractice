package leetcode.text_justification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> rows = new ArrayList<>();
        List<Integer> wordWidths = new ArrayList<>();
        List<String> result = new ArrayList<>();

        int currentWidth = 0;
        int newLineAt = 0;

        for (int i = 0; i < words.length ; i++) {
            currentWidth += words[i].length() + 1;
            if (currentWidth - 1> maxWidth) {
                rows.add(List.of(Arrays.copyOfRange(words, newLineAt, i)));
                wordWidths.add(currentWidth - words[i].length() - 1 - rows.getLast().size());
                newLineAt = i;
                currentWidth = words[i].length() + 1;
            }
        }

        for (int i = 0; i < rows.size(); i++) {
            int totalSpaces = maxWidth - wordWidths.get(i);
            StringBuilder stringBuilder = new StringBuilder();

            if (rows.get(i).size() > 1) {
                int spacePerWord = totalSpaces / (rows.get(i).size() - 1);
                int extraSpaceRange = totalSpaces % (rows.get(i).size() - 1);
                for (int j = 0; j < rows.get(i).size() - 1; j++) {
                    stringBuilder.append(rows.get(i).get(j));
                    int space = j < extraSpaceRange ? spacePerWord + 1 : spacePerWord;
                    stringBuilder.append(" ".repeat(space));
                }
                stringBuilder.append(rows.get(i).getLast());
            } else {
                stringBuilder.append(rows.get(i).getLast());
                stringBuilder.append(" ".repeat(totalSpaces));
            }


            result.add(stringBuilder.toString());
        }

        StringBuilder lastLine = new StringBuilder();

        for (int i = newLineAt; i < words.length; i++) {
            lastLine.append(words[i]);
            lastLine.append(" ");
        }
        lastLine.deleteCharAt(lastLine.length() - 1);


        lastLine.append(" ".repeat(maxWidth - currentWidth + 1));
        result.add(lastLine.toString());

        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("zero repeat" + " ".repeat(0) +"|||");

        String[] arr = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result1 = solution.fullJustify(arr, 16);
        System.out.println(result1);

        String[] arr2 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        List<String > result2 = solution.fullJustify(arr2, 20);
        System.out.println(result2);

        String[] arr3 = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        List<String > result3 = solution.fullJustify(arr3, 16);
        System.out.println(result3);

    }
}
