class Solution {

    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }

        return res.toString();
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            int end = j + length + 1;
            res.add(str.substring(start, end));
            i = end;
        }
        return res;
    }
}
