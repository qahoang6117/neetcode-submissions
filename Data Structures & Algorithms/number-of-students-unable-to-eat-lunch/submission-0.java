class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        int n = students.length;
        for (int student : students) {
            q.offer(student);
        }

        int res = n;
        for (int sandwich : sandwiches) {
            int cnt = 0;
            while (cnt < n && sandwich != q.peek()) {
                q.offer(q.poll());
                cnt++;
            }

            if (q.peek() == sandwich) {
                q.poll();
                res--;
            } else {
                break;
            }
        }

        return res;
    }
}