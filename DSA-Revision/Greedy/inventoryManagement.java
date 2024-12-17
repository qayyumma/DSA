public class Solution {

    class items{

        int exp;

        int pro;

        public items(int i, int j){

            this.exp = i;

            this.pro = j;

        }
    }

    public int solve(int[] A, int[] B) {

        items[] inventories = new items[A.length];

        for(int i = 0; i < A.length; i++){

            inventories[i] = new items(A[i], B[i]); 

        }

        Arrays.sort(inventories, (a, b) -> a.exp - b.exp);

        long date = 0;

        long sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(items i : inventories){

            if(date < i.exp){

                sum = sum + i.pro;

                pq.add(i.pro);

                date++;

            }
            else{

                if(pq.peek() < i.pro){

                    sum = sum-pq.poll();

                    sum = sum + i.pro;

                    pq.add(i.pro);

                   // date = i.exp;

                }

            }

        }

        return (int)( sum % 1000000007) ;

    }
}
