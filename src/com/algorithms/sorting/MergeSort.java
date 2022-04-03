package com.algorithms.sorting;

public class MergeSort {



    public void merge(int[] arr,int left, int mid, int right){
        int temp[] = new int[right - left + 1];

        int i = left; int j = mid+1;
                int k =0;


                while(i <= mid && j <=right){
                    if(arr[i] <= arr[j]){
                        temp[k] = arr[i];
                        i++;
                    } else {
                        temp[k] = arr[j];
                       j++;
                    }
                    k++;
                }

                while(i <= mid) {
                    temp[k] = arr[i];
                    i++; k++;
                }

                while(j <= right){
                    temp[k] = arr[j];
                    j++; k++;
                }

    for (int l = left; l <= right; l++) {
        arr[l] = temp[l - left];
    }
   }


    public void mergeSort(int[] arr,int left,int right){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
}
