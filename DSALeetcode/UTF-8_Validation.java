//393. UTF-8 Validation
//https://leetcode.com/problems/utf-8-validation/

class Solution {
    public boolean validUtf8(int[] data) {
         int count = 0;
        for (int i = 0; i < data.length; i ++) {
            if (count == 0) {
                if (data[i]>>>5 == 0b110) {
                    count = 1;
                }
                else if (data[i]>>>4 == 0b1110) {
                    count = 2;
                }
                else if (data[i]>>>3 == 0b11110) {
                    count = 3;
                }
                else if (data[i]>>>7 == 1) {
                    return false;
                }
            }
            else {
                if (data[i]>>>6 != 2) {
                    return false;
                }
                count --;
            }
        }
        return count == 0;
    }
}
