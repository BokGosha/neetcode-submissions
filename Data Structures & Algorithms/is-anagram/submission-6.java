class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<String, Integer> maps = new HashMap<>();
        HashMap<String, Integer> mapt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            maps.put(String.valueOf(s.charAt(i)), maps.getOrDefault(String.valueOf(s.charAt(i)), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            mapt.put(String.valueOf(t.charAt(i)), mapt.getOrDefault(String.valueOf(t.charAt(i)), 0) + 1);
        }

        return maps.equals(mapt);
    }
}
