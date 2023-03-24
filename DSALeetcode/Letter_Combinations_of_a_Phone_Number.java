//Leetcode 17. Letter Combinations of a Phone Number 
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    String ST[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<String>();
        if("".equals(digits))
            return Collections.emptyList();
        combination("",digits,0,res);
        return res;
    }
    public void combination(String tmp,String str,int ind, List<String> res){
        if(ind==str.length()){
            res.add(tmp);
            return;
        }
        String let=ST[Integer.parseInt(String.valueOf(str.charAt(ind)))];
        for(int i=0;i<let.length();i++){
            combination(tmp+let.charAt(i),str,ind+1,res);
        }
    }
}
