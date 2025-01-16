Problem Description

You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.


Problem Constraints
1 <= |A| <= 100000


Input Format
First and only argument is string A.

Output Format
Return the final string.

Example Input

Input 1:
 A = "abccbc"

Input 2:
 A = "ab"


Example Output
Output 1:
 "ac"
Output 2:
 "ab"


public class Solution {
    public String solve(String A) {
        // we maintain a stack for the characters of the string
        Stack < Character > st = new Stack < Character > ();
        for (int i = A.length()-1; i >= 0; i--) {
            // if the current character is equal to the top of the stack then they form 
            // a pair of consecutive similar characters therefore we pop from the stack,
            // else we push the charcter in the stack
            if (!st.empty() && st.peek() == A.charAt(i)) {
                st.pop();
            } else st.push(A.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.peek());
            st.pop();
        }
   //     sb.reverse();
        return sb.toString();
    }
}

