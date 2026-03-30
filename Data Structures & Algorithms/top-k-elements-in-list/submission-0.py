class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d = Counter(nums)
        d = sorted(d.items(), key=lambda x: x[1], reverse=True)
        res = []
        for i in range(k):
            res.append(d[i][0])
        return res