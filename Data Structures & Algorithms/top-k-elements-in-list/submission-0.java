class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        java.util.HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(
            (a,b) -> map.get(b) - map.get(a)
        );

        for (int num : map.keySet()) {
            pq.add(num);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
