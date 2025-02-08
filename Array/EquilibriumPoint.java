//https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1

public class EquilibriumPoint {
    public static int findEquilibrium(int arr[]) {
        // code here
        int n=arr.length;

        int total=0;

        for(int num:arr){

            total+=num;

        }

        int leftsum=0,rightsum=0;

        for(int i=0;i<n;i++){

            rightsum=total-leftsum-arr[i];

            if(leftsum==rightsum){

                return i;

            }

            leftsum+=arr[i];

           

        }

        return -1;
}
}
