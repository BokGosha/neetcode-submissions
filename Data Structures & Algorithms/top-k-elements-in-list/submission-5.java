class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> freq = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length + 1; i++) {
            freq.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> n : map.entrySet()) {
            freq.get(n.getValue()).add(n.getKey());
        }

        int[] res = new int[k];
        int t = 0;
        for (int i = freq.size() - 1; i > -1; i--) {
            for (Integer n : freq.get(i)) {
                res[t] = n;
                t++;
                if (t == k) return res;
            }
        }

        return new int[]{};
    }
}
