class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        // Duyệt từng phần tử trong nums
        // và lấy số lần xuất hiện
        for (int num : nums) {
            
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Sử dụng hàng đợi ưu tiên
        // để sắp xếp 
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        // Xét các key đã lưu và thêm vào hàng đợi
        for (int num : map.keySet()) {

            pq.add(num);
            
        }

        // Tạo một danh sách kết quả
        // ứng với k phần tử 
        int[] res = new int[k];

        // Lấy đúng k phần tử
        for (int i = 0; i < k; i++) {
            
            res[i] = pq.poll();
        }

        return res;
        
    }
}
