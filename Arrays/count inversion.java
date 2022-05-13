// gfg : https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#:~:text=Inversion%20Count%3A%20For%20an%20array,inversion%20count%20is%20the%20maximum.



class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long temp[] = new long[(int)N];
        long ans = mergeSort(arr, temp, 0, (int)N-1);
        return ans;
    }
    static long merge(long arr[], long temp[], int left, int mid, int right){
        long invC = 0;
        int i = left;
        int j = mid;
        int k = left;
        while((i <= mid-1) && (j <= right)){
            if(arr[i] <= arr[j]) temp[k++] = arr[i++];
            else {temp[k++] = arr[j++];
                invC = invC + (mid - i);
            }
        }
        while(i <= mid -1) temp[k++] = arr[i++];
        while(j <= right) temp[k++] = arr[j++];
        
        for(i = left; i <= right; i++) arr[i] = temp[i];
        
        return invC;
    }
    static long mergeSort(long arr[], long temp[], int left, int right){
        int mid;
        long invC = 0;
        if(right > left){
            mid= (left + right) / 2;
            invC += mergeSort(arr, temp, left, mid);
                        invC += mergeSort(arr, temp, mid + 1, right);
                        invC += merge(arr, temp, left, mid + 1, right);
}
return invC;
    }
}
