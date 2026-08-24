

class Solution {
    public int leastInterval(char[] tasks, int n) {

        // 1. Đếm số lần xuất hiện của từng task
        int[] frequency = new int[26];

        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        // 2. Tạo Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : frequency) {
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }

        int time = 0;

        // 3. Xử lý cho đến khi hết task
        while (!maxHeap.isEmpty()) {

            // Lưu các task chưa hoàn thành
            List<Integer> temp = new ArrayList<>();

            // Một chu kỳ có tối đa n + 1 CPU cycle
            for (int i = 0; i <= n; i++) {

                if (!maxHeap.isEmpty()) {

                    int freq = maxHeap.poll();

                    // Sử dụng task này 1 lần
                    freq--;

                    // Task vẫn còn cần thực hiện
                    if (freq > 0) {
                        temp.add(freq);
                    }
                }

                // Một CPU cycle đã trôi qua
                time++;

                // Nếu không còn task nào nữa
                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }

            // Đưa các task chưa hoàn thành
            // trở lại Max Heap
            for (int freq : temp) {
                maxHeap.offer(freq);
            }
        }

        return time;
    }
}