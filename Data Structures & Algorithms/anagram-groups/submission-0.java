class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        java.util.Map<String, List<String>> map = new java.util.HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();

            java.util.Arrays.sort(chars);

            String key = new String(chars);

            map.putIfAbsent(key, new java.util.ArrayList<>());  

            map.get(key).add(str);
        }

        return new java.util.ArrayList<>(map.values());
    }
}
