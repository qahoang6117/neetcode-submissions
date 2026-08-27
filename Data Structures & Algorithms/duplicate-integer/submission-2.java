class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Tạo bảng lưu các giá trị đã duyệt qua
        HashSet<Integer> seen = new HashSet<>();

        // Duyệt qua từng phần tử
        for (int num : nums) {
        // Nếu phần tử đã xuất hiện trong seen thì trả về true
            if (seen.contains(num)) {
                return true;
            }
        // Nếu chưa xuất hiện thì thêm nó vào seen
            seen.add(num);
        }

        // Duyệt xong các phần tử
        // Nếu không có sự lặp lại thì trả về false
        return false;
    }
}