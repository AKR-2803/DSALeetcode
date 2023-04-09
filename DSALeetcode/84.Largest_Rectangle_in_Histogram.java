//Leetcode 84. Largest Rectangle in Histogram 
//https://leetcode.com/problems/largest-rectangle-in-histogram/

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int maxA=0;
        for(int i=0;i<=n;i++){
            while(!st.empty() && (i==n || heights[st.peek()]>=heights[i])){
                int height=heights[st.peek()];
                st.pop();
                int width;
                if(st.empty()) width=i;
                else width=i-st.peek()-1;
                maxA=Math.max(maxA,height*width);
            }
            st.push(i);
        }
        return maxA;
    }
}
