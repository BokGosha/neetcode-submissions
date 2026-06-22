class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<List<Integer>, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            List<Integer> count = new ArrayList<>(26);
            for (int i = 0; i < 26; i++) {
                count.add(0);
            }

            for (char c : str.toCharArray()) {
                int idx = c - 'a';
                count.set(idx, count.get(idx) + 1);
            }

            if (!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
