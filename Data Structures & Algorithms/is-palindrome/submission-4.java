class Solution {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replace(" ", "");

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!Character.isDigit(l) && !Character.isAlphabetic(l)) {
                left += 1;
                continue;
            }

            if (!Character.isDigit(r) && !Character.isAlphabetic(r)) {
                right -= 1;
                continue;
            }

            if (l != r) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
