Problem Description

An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.

Problem Constraints
1 <= N <= 105

Input Format
The only argument given is string array A.

Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.


Example Input
Input 1:
A =   ["2", "1", "+", "3", "*"]
Input 2:
A = ["4", "13", "5", "/", "+"]


Example Output
Output 1:
9
Output 2:
6


public class Solution {
    public int evalRPN(String[] A) {

       // int sum = Integer.MAX_VALUE;

        Stack<Integer> s = new Stack<Integer>();

        for(int i = 0; i < A.length; i++){

            //int sum = 0;

            if( A[i].equals("+") || A[i].equals("-") || A[i].equals("/") || A[i].equals("*") ){

                int sum = 0;

                int a = s.pop();

                int b = s.pop();

                if(A[i].equals("+")) sum = b + a;

                else if (A[i].equals("-")) sum = b - a;

                else if (A[i].equals("*") ) sum = b * a;

                else if (A[i].equals("/") ) sum =  b / a;

                s.push(sum);
                
            }

            else{

                int temp = Integer.valueOf(A[i]);

                s.push(temp);
            }

        }


        return s.pop();

    }
}


