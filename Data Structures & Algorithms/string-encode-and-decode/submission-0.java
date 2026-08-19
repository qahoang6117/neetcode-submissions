class Solution {

    public String encode(List<String> strs) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        java.util.List<String> result = new java.util.ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(
                str.substring(i, j)
            );

            int start = j + 1;

            String word = str.substring(
                start,
                start + length
            );

            result.add(word);

            i = start + length;
        }

        return result;
    }
}
