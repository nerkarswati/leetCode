public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

//    Need to compare each string's character at same position
//    To check, need to take 1st as reference and check each position of 1st string with same position of all others.
//    e.g.:- position = 0 => iterate through an array for same position => check 0th position character of 1st string is same for others string or not
//    if its same for all strings then add that character to result string. After for loop where iterating all strings of array and before for loop to iterate position.
//    if it doesn't match with any one of the string's 0th position then return the result.
//    Also, it is possible that other strings in array have small size than the position iterator condition. e.g. position iterator has condition to iterate till size of 1st string,
//    but 2nd string size is less than 1st string. This will throw index out of bound exception
//    To handle this, while checking char at specific position; also check if position is equal to size of current string. If yes, return the result as it is End for the comparison.



    public static String longestCommonPrefix(String[] strs) {
       String temp = strs[0];
       String res="";
       for(int i =0;i<temp.length();i++){
           for(String s:strs){
               if(i == s.length() || s.charAt(i)!=temp.charAt(i))
                   return res;
           }
           res=res+temp.charAt(i);
       }
        return res;
    }
}
