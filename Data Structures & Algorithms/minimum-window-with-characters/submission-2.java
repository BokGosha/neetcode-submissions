class Solution {
    public static String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (Character ch : t.toCharArray()) {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        int have = 0;
        int need = countT.size();
        int left = 0;
        int resLen = Integer.MAX_VALUE;
        String line = "";
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (countT.containsKey(c) && Objects.equals(window.get(c), countT.get(c))) {
                have++;
            }
            System.out.println(countT + " " + window);
            while (have == need) {
                while ((right - left + 1) < resLen) {
                    line = s.substring(left, right + 1);
                    resLen = right - left + 1;
                }

                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                if (countT.containsKey(s.charAt(left)) && window.get(s.charAt(left)) < countT.get(s.charAt(left))) {
                    have--;
                }

                left++;
            }
        }

        return line;
    }
}
