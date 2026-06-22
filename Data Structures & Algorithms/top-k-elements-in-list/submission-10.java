class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> freq = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq.add(new int[]{entry.getValue(), entry.getKey()});
        }

        freq.sort((a, b) -> b[0] - a[0]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = freq.get(i)[1];
        }

        return res;
    }
}
