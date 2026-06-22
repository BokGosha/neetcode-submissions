class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);

            map.putIfAbsent(newStr, new ArrayList<>());
            map.get(newStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
