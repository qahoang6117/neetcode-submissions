class Solution {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int num : nums) {
            cnt[num]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (cnt[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }
}