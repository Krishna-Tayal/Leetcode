class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long maxArea = 0;
        
        
        for (int i = 0; i <= n; i++) {
            int curHeight = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int leftIndex = stack.isEmpty() ? -1 : stack.peek(); 
                int width = i - leftIndex - 1; 
                long area = (long) height * width;
                if (area > maxArea) maxArea = area;
            }
            
            stack.push(i);
        }
        
        return (int) maxArea;
    }
}
