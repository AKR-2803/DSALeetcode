//Leetcode 451. Sort Characters By Frequency
//https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();

        for(char c:s.toCharArray()) mp.put(c,mp.getOrDefault(c,0)+1);

        List<Character> ls=new ArrayList(mp.keySet());

        Collections.sort(ls,(a,b)->(mp.get(b)-mp.get(a)));

        StringBuilder sb=new StringBuilder();
        for (Object c : ls) {
            for (int i = 0; i < mp.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
