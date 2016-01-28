 /**
 * 
 */
package sorting;

/**
 * @author M Rich
 *
 */
public class sort {
	/**
	 * Sorts the imported array by method of a selection sort;
	 * going over each item and comparing each to a given item.
	 * @param numArray
	 */
	public static void selectionSort(int[] numArray){
		int totalItems = numArray.length;
		for (int i = 0; i < totalItems; i++){
			for (int subI = i; subI < totalItems; subI++){
				if (numArray[subI] < numArray[i]){
					int temp = numArray[i];
					numArray[i] = numArray[subI];
					numArray[subI] = temp;
					
				}
			}
	
		}
		System.out.println("Selection" + numArray[0]+""+numArray[1]+""+numArray[2]+""+numArray[3]+""+numArray[4]+""+numArray[5]);
		
	}
	/**
	 * Sorts the array by inserting items in a list between the first two items, until everything is organized.
	 * @param numArray
	 */
	public static void insertionSort(int[] numArray){//based off content in the textbook, however it doesnt work
		int temp, previousIndex;
		int totalItems = numArray.length;
		for (int i = 1; i < totalItems; i++){
			temp = i;
			previousIndex = i - 1;
			while ( (previousIndex >= 0) && (numArray[temp] < numArray[previousIndex])){
				if (numArray[previousIndex] > numArray[temp]) 
					swap(numArray, temp, previousIndex);
				
				temp = previousIndex;
				previousIndex = temp - 1;

			}



		}

		System.out.println("Insertion" +numArray[0]+""+numArray[1]+""+numArray[2]+""+numArray[3]+""+numArray[4]+""+numArray[5]);
	}
//	public static void insertionSort(int[] numArray) {
//	      int i, j, newValue;
//	      for (i = 1; i < numArray.length; i++) {
//	            newValue = numArray[i];
//	            j = i;
//	            while (j > 0 && numArray[j - 1] > newValue) {
//	            	numArray[j] = numArray[j - 1];
//	                  j--;
//	            }
//	            numArray[j] = newValue;
//	      }
//	      System.out.println("Insertion" +numArray[0]+""+numArray[1]+""+numArray[2]+""+numArray[3]+""+numArray[4]+""+numArray[5]);
//	}
	/**
	 * Should "bubble" the highest numbers in a given list to the top.
	 * @param numArray
	 */
	public static void bubbleSort(int[] numArray){//Had to search this one up, didn't fully understand it.
		for (int j = 0 ;j <numArray.length -1 ; j++){
			for(int i=0; i < numArray.length -1 ;i++){
				if (numArray[i] > numArray[i+1]){
					swap(numArray,i, i+1);
				}
					
		}

		}
		System.out.println("BubbleSort" +numArray[0]+""+numArray[1]+""+numArray[2]+""+numArray[3]+""+numArray[4]+""+numArray[5]);

	}
	public static void quickSort(int[] numArray, int left, int right){//also not working 
		if(right > left){
			if ((right - left) > 1){
				int mid = partition(numArray, right, left);
				quickSort(numArray, left, mid-1); //Left side
				quickSort(numArray, mid +1 , right); //right side
			}
			else{
				if (numArray[right] < numArray[left])
					swap(numArray, left, right);	
			}
		}
	}
	
	private static int partition(int[] numArray, int right, int left){
		int pivot = left;
		int low = left+1;
		for(int j = low;  j < right; j++){
			if (numArray[j]<numArray[pivot]){
				swap(numArray, low, j);
				low ++;
			}

		}
		swap(numArray, low-1, pivot);
		return(low-1);
	}
	
	public static void mergeSort(int[] numArray){//Should technically work, based off content in the textbook
		int total = numArray.length;
		int end = numArray[total-1];
		int mid = numArray[total/2];
		int[] temp= new int[numArray.length];
		int pos1 = numArray[0];
		int pos2 = numArray[total/2];
		int spot = pos1;
		
		while (!(pos1>mid && pos2 > end)){
			if ((pos1 > mid) || (pos2<= end && (numArray[pos2] < numArray[pos1]))){
				temp[spot] = numArray[pos2+1];
				pos2 +=1;
		} else {
			temp[spot] = numArray[pos1];
			pos1 +=1;
		}
			spot +=1;
		}
		for (int i = numArray[0]; i <= end; i++){
			numArray[i] = temp[i];
		}
			
		}
	private static void merge(int [] numArray){
		int start = numArray[0];
		int end = numArray[numArray.length];
		int mid = numArray[numArray.length/2];
		if (start < end){
			 mid = (start + end) / 2;
			mergeSort (numArray);
			mergeSort (numArray);
			merge(numArray);
		}
	}
	
	private static void swap(int[] numArray, int i, int j){
		int temp = numArray[i];
		numArray[i] = numArray[j];
		numArray[j] = temp;

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int MAX = 20;
		int[] numArray = {2,5,6,3,1,9};//I don't know 
		insertionSort(numArray);
		int[] numArray2 = {2,5,6,3,1,9};//I don't know 
		selectionSort(numArray2);
		int[] numArray3 = {2,5,6,3,1,9};//I don't know 
		bubbleSort(numArray3);
		int[] numArray4 = {2,5,6,3,1,9};
		quickSort(numArray4,0, numArray4.length-1);
		System.out.print("Quick: ");
		for(int i = 0; i < numArray4.length; i++)
			System.out.print(numArray4[i] + " ");
	}

}
