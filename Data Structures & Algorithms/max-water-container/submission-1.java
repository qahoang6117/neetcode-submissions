class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length -1;
        
        int maxWater = 0;
        while (l < r) {
            int height = Math.min(heights[l], heights[r]);

            int width = r - l;

            int water = height * width;
            maxWater = Math.max(maxWater, water);

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxWater;
    }
}
