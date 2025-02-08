//https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1



public class MissinginArray {
    
    int missingNumber(int arr[]) {
        int i = 0;
        int n = arr.length + 1; // The actual range of numbers is from 1 to n.

        // Step 1: Place each number at its correct index using Cyclic Sort.
        while (i < arr.length) {
            int correct = arr[i] - 1; // The correct index for arr[i]
            
            // Swap if arr[i] is within range (1 to n) and not in its correct position
            if (arr[i] > 0 && arr[i] < n && arr[i] != arr[correct]) {
                int temp = arr[correct];
                arr[correct] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }

        // Step 2: Find the missing number by checking the index where the number is incorrect.
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return index + 1; // The missing number
            }
        }

        // If no number is missing in the range 1 to n-1, then n is the missing number.
        return n;
    }
}



// second approach 

// //JAVA
// class Solution {
//     int missingNumber(int arr[]) {
//         // code here
//         long n = arr.length+1;
//         long sum = n*(n+1)/2;
//         long sumOfArr = 0;
        
//         for(int num:arr){
//             sumOfArr += num;
//         }
//         return (int)(sum - sumOfArr);
//     }
// }

