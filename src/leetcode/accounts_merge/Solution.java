package leetcode.accounts_merge;

import java.util.*;

class Solution {
    public List<List<String>> accountsMergeSimpleVersion(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, Set<String>> children = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (List<String> nameAndAccount : accounts) {
            String name = nameAndAccount.get(0);
            String rootEmail = nameAndAccount.get(1);
            emailToName.put(rootEmail, name);
            parents.putIfAbsent(rootEmail, rootEmail);
            children.putIfAbsent(rootEmail, new HashSet<>());


            for (int i = 1; i < nameAndAccount.size(); i++) {

                children.get(rootEmail).add(nameAndAccount.get(i));
                if (parents.containsKey(nameAndAccount.get(i)) && !parents.get(nameAndAccount.get(i)).equals(rootEmail)) {
                    for (String child : children.get(rootEmail)) {
                        parents.put(child, parents.get(nameAndAccount.get(i)));
                        children.get(parents.get(nameAndAccount.get(i))).add(child);
                    }
                    children.remove(rootEmail);
                    rootEmail = parents.get(nameAndAccount.get(i));
                }


                parents.put(nameAndAccount.get(i), rootEmail);

            }
        }

        for (Map.Entry<String, Set<String>> child : children.entrySet()) {
            List<String> emails = new ArrayList<>(child.getValue());
            emails.sort(String::compareTo);
            emails.addFirst(emailToName.get(child.getKey()));
            result.add(emails);
        }


        return result;
    }


    int[] parents;
    int[] ranks;

    public int find(int n) {
        while (parents[n] != n) {
            n = parents[n];
        }
        return n;
    }
    public void union(int a, int b) {
        int parent1 = find(a);
        int parent2 = find(b);

        if (parent1 == parent2) {
            return;
        }

        if (ranks[parent1] > ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parents = new int[accounts.size()];
        ranks = new int[accounts.size()];
        Arrays.fill(parents, 1);
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        Map<String, Integer> emailToIndex = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            final List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                if (emailToIndex.containsKey(account.get(j))) {
                    union(i, emailToIndex.get(account.get(j)));
                } else {
                    emailToIndex.put(account.get(j), i);
                }
            }
        }

        Map<Integer, List<String>> groupedAccounts = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            final int accountIndex = find(entry.getValue());
            groupedAccounts.putIfAbsent(accountIndex, new ArrayList<>());
            groupedAccounts.get(accountIndex).add(entry.getKey());
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : groupedAccounts.entrySet()) {
            List<String> emails = entry.getValue();
            emails.sort(String::compareTo);
            String accountName = accounts.get(entry.getKey())
                    .getFirst();
            emails.addFirst(accountName);
            result.add(entry.getValue());
        }

        return result;
    }



}