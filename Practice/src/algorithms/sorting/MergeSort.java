package algorithms.sorting;

public class MergeSort {
	
	private void merge(int[] arr, int l, int m, int r) {

	}

	public void sort(int arr[], int l, int r)
    {
		if(l<r){
			int m  = (l + r)/2;
			
			//sort first and second halves
			sort(arr, l , m);
			sort(arr, m+1, r);
			
			//merge the sorted halves
			merge(arr, l , m , r);
		}
	}
	
	 /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	public static void main(String[] args) {
		
		  int arr[] = {12, 11, 13, 5, 6, 7};
		  
	        System.out.println("Given Array");
	        printArray(arr);
	 
	        MergeSort ob = new MergeSort();
	        ob.sort(arr, 0, arr.length-1);
	 
	        System.out.println("\nSorted array");
	        printArray(arr);
		
	}
}
