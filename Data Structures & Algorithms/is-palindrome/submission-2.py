class Solution:
    def isPalindrome(self, s: str) -> bool:
        from string import ascii_lowercase, digits
        alpha = digits + ascii_lowercase
        s = s.lower().replace(" ", "")
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] not in alpha:
                left += 1
                continue
            if s[right] not in alpha:
                right -= 1
                continue
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True