//Leetcode 140. Word Break II
//https://leetcode.com/problems/word-break-ii/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res=new ArrayList<>();
        int n=s.length();
        String ans="";
        wordBreakUtil(n, s, wordDict, ans,res);
        return res;
    }
    static void wordBreakUtil(int n, String s, List<String> dict, String ans,List<String> res)
  {
    for(int i = 1; i <= n; i++)
    {
 
      String prefix=s.substring(0, i);
      if(dict.contains(prefix))
      {
        if(i == n)
        {
          ans += prefix;
            res.add(ans);
          return;
        }
        wordBreakUtil(n - i, s.substring(i,n), dict, ans+prefix+" ",res);
      }
    }
  }
}
