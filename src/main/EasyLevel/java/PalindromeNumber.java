import javax.sound.midi.Soundbank;

//    return true if number is palindrome, else return false
public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int temp = x;
        int reverse = 0;
        int rem = 0;
        while(temp != 0){
            rem = temp % 10;
            reverse = reverse*10 + rem;
            temp = temp/10;
        }
        return reverse == x;
    }
}
