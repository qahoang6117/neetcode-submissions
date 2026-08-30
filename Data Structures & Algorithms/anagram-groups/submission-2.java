class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        // Duyệt qua mảng xâu đã cho 
        for (String str : strs) {
            
            // Chuyển chuỗi thành các mảng kí tự 
            char[] chars = str.toCharArray();

            // Sắp xếp các kí tự
            Arrays.sort(chars);

            // Khởi tạo một String từ mảng kí tự
            //rồi đưa nó cho biến key 
            String key = new String(chars);

            // Kiểm tra xem key(khác null) đã tồn tại 
            // trong map hay chưa
            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    
    }
}
