class Solution {
    private void merge(int[] nums, int[] indices, int[] count, int low, int mid, int high) {
        int left = low;      // Start index of left half
        int right = mid + 1; // Start index of right half
        int index = 0;
        int[] tempIndices = new int[high - low + 1]; // Temporary array for sorting indices

        int rightCount = 0; // Count of numbers from right half placed before left half

        while (left <= mid && right <= high) {
            if (nums[indices[left]] <= nums[indices[right]]) {
                count[indices[left]] += rightCount; // Update count for left index
                tempIndices[index++] = indices[left++];
            } else {
                rightCount++; // A smaller number is encountered
                tempIndices[index++] = indices[right++];
            }
        }

        // Copy remaining elements from left half
        while (left <= mid) {
            count[indices[left]] += rightCount;
            tempIndices[index++] = indices[left++];
        }

        // Copy remaining elements from right half
        while (right <= high) {
            tempIndices[index++] = indices[right++];
        }

        // Copy sorted indices back to the original indices array
        for (int i = low; i <= high; i++) {
            indices[i] = tempIndices[i - low];
        }
    }

    private void mergeSort(int[] nums, int[] indices, int[] count, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(nums, indices, count, low, mid);  // Sort left half
        mergeSort(nums, indices, count, mid + 1, high); // Sort right half
        merge(nums, indices, count, low, mid, high); // Merge the two halves
    }
    public List<Integer> countSmaller(int[] nums) {
         int n = nums.length;
        int[] count = new int[n];  // Store the count of smaller numbers after self
        int[] indices = new int[n]; // Store the original indices of elements

        // Initialize indices array with 0 to n-1
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Perform merge sort with tracking
        mergeSort(nums, indices, count, 0, n - 1);

        // Convert count array to a list
        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }
        return result;
    }
}