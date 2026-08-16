


class Solution {
    public boolean hasDuplicate(int[] nums) {
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();

        for (int x : nums) {

            if (seen.contains(x)) {
                return true;
            }

            seen.add(x);
        }

        return false;
    } 
}