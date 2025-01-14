Problem Description

Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.

Your task is to calculate the total amount of water that can be trapped in these valleys.

Example:
The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below. The total amount of rain water trapped in A is 11.

Problem Constraints
1 <= |A| <= 105
0 <= A[i] <= 105

Input Format
First and only argument is the Integer Array, A.

Output Format
Return an Integer, denoting the total amount of water that can be trapped in these valleys


Example Input
Input 1:
A = [0, 1, 0, 2]

Input 2:
A = [1, 2]


public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {

        int N = A.length;

        int ans = 0;

        int[] L = new int[N];

        int[] R = new int[N];

         L[0] = 0;

         R[N-1] = 0;

        for(int i = 1; i < N; i++){

            L[i] = Math.max(L[i-1], A[i-1]);

        }

        for(int i = N-2; i >= 0; i--){

            R[i] = Math.max(R[i+1], A[i+1]);

        }

        for(int i = 0; i < N; i++){

            int temp = Math.min(L[i], R[i]);

            int count = temp - A[i];

            if(count > 0){

                ans += count;

            }
        }

        return ans;

    }
}

==========================================================================================================================


public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {

        ArrayList<Integer> GL = new ArrayList<>();

        ArrayList<Integer> GR = new ArrayList<>();

        int[] L = new int[A.length];

        int[] R = new int[A.length];

        int N = A.length;

        GL.add(A[0]);

        for(int i = 1; i < N; i++){

            while( GL.size()!=0 && GL.get(GL.size()-1) < A[i] ){

                GL.remove(GL.size()-1);

            }

            if(GL.size() != 0){
                
                L[i] = GL.get(0); 
            }
            else{
                L[i] = 0;
            }

            GL.add(A[i]);

        }

        GR.add(A[N-1]);

        for(int i = N-2; i >=0; i--){

            while( GR.size()!=0 && GR.get(GR.size()-1) < A[i] ){

                GR.remove(GR.size()-1);

            }

            if(GR.size() != 0){
                
                R[i] = GR.get(0); 
            }
            else{
                R[i] = 0;
            }

            GR.add(A[i]);

        }

        int ans = 0;

        for(int i = 1; i < N-1; i++){

            int min = Math.min(L[i], R[i]);

            if(min==0){ 
                continue;
            }
            else {

                ans += min-A[i];
            }

        }


        return ans;

    }
}



