import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

//    Use a stack of character
//    iterate through string till length of string
//    - any type of opening bracket is there put it in stack
//    - if any type of closing bracket it there check following
//         1. if stack is not empty => if its empty that means a closing bracket doesn't have matching opening bracket.
//                                  => if not empty, take out top of stack. match the closing bracket with opening bracket(element took out of stack).
//                                  => if they match, do nothing
//                                  => if they don't match, return false as string is not having valid parentheses
//         2. After completion of loop execution, check if stack is empty
//                                  => if its empty that means all closing brackets are having opening brackets and those are matching
//                                  => if its not empty that means there are some opening brackets which do not have closing brackets


    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }
            else{
                if(st.empty())
                    return false;
                else {
                    char ch = st.pop();
                    if (!((s.charAt(i) == ')' && ch == '(') || (s.charAt(i) == ']' && ch == '[') || (s.charAt(i) == '}' && ch == '{')))
                        return false;
                }
            }
        }
        return st.empty();
    }
}
