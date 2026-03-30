class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        dicts, dictt = {}, {}
        for i in range(len(s)):
            dicts[s[i]] = 1 + dicts.get(s[i], 0)
        for i in range(len(t)):
            dictt[t[i]] = 1 + dictt.get(t[i], 0)

        for i in dicts:
            if dicts[i] != dictt.get(i, 0):
                return False

        return True