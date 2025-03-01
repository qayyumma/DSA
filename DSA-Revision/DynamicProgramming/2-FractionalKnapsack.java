Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

NOTE:

You can break an item for maximizing the total value of the knapsack



Problem Constraints

1 <= N <= 105

1 <= A[i], B[i] <= 103

1 <= C <= 103




Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.




Output Format

Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {


    class Iteam{

        int value;
        int weight;
        double ratio;

        Iteam(int v, int w){

            this.value = v;
            this.weight = w;
            this.ratio = (double)v/w;
        }
    }

    class customComparator implements Comparator<Iteam>{

        public int compare(Iteam i1, Iteam i2){

            if(i1.ratio < i2.ratio ){
                return 1;
            }
            else if(i1.ratio >= i2.ratio){
                return -1;
            }
            else{
                return 0;
            }


        }

    }

    public int solve(int[] A, int[] B, int C) {

        Iteam[] iteams = new Iteam[A.length];

        for(int i = 0; i < A.length; i++){

            iteams[i] = new Iteam(A[i], B[i]);

        }

        Arrays.sort(iteams, new customComparator());

        double ans = 0;

        for(int i = 0; i < A.length; i++){

            if(iteams[i].weight <= C){

                ans += iteams[i].value;

                C -= iteams[i].weight;

            }
            else{

                ans += C * iteams[i].ratio;

                break;

            }

        }

        ans = (ans * 1000);

        return (int) (ans/10);

    }
}
