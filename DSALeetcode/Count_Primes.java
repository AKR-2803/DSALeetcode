//Leetcode 204. Count Primes
//https://leetcode.com/problems/count-primes/

class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        
        int rt=(int) Math.sqrt(n);
        boolean arr[]=new boolean[n];
        Arrays.fill(arr,false);
        
        for(int i=2;i<=rt;i++){
            if(arr[i]==false){
                for(int j=i*i;j<n;j=j+i){
                    arr[j]=true;
                }
            }
        }
        int cnt=0;
        for(int i=2;i<n;i++){
            if(arr[i]==false) cnt++;
        }
        return cnt;
    }
}
