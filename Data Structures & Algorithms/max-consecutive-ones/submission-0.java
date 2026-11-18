class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    break;
                }

                cnt++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}