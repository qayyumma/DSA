Problem Description

Write a recursive function that checks whether string A is a palindrome or Not.
Return 1 if the string A is a palindrome, else return 0.

Note: A palindrome is a string that's the same when read forward and backward.

Problem Constraints

1 <= |A| <= 50000

String A consists only of lowercase letters.

Input Format

The first and only argument is a string A.
______________________________________________________________________________________________________________________________________________________

public class Solution {
    public int solve(String A) {

        int i = 0;

        int j = A.length()-1;

        if(check(A, i, j)){
            return 1;
        }

        return 0;

    }

    public boolean check(String A, int i, int j){

        if(i>=j){
            return true;
        }

        if( A.charAt(i) != A.charAt(j) ){
            return false;
        }

        return check(A, i+1, j-1);
    }
}
