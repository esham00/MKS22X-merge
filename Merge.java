import java.util.*;
public class Merge {
    public static void mergesort(int[] data) {
	mergesortH(data, 0, data.length-1);
    }
    public static String toString(int[] data, int low, int hi) {
	String output = "";
	for(int i = low; i < hi; i++) {
	    output += data[i];
	}
	return output;
    }
    public static void merge(int[] data, int low, int hi){
	//half the array (left and right)
	int length = hi-low+1;
	int[] right = new int[(length)/2];
	int[] left = new int[length - right.length];
    	//input values from the left half of the data
	for(int i = 0; i < left.length; i++) {
	    left[i] = data[i+low];
	}
	for(int i = 0; i < right.length; i++) {
	    right[i] = data[i+left.length+low];
	}
	if(right.length<3) {
	    // insertionsort(left);
	    // insertionsort(right);
	    insertionsort(data, low, hi);
	    System.out.println(Arrays.toString(left));
	    System.out.println(Arrays.toString(right));
	    return;
	}
	int i = 0;
	int j = 0;
	int dataIndex = low;
	while(i < left.length && j < right.length) {
	    if (left[i] <= right[j]) {
		data[dataIndex] = left[i];
		i++;
	    } else {
		data[dataIndex] = right[j];
		j++;
	    }
	    dataIndex++;
	}
	while (i < left.length) {
	    data[dataIndex] = left[i];
	    i++;
	    dataIndex++;
	}
	while (j < right.length) {
	    data[dataIndex] = right[j];
	    j++;
	    dataIndex++;
	}
    }
    public static void insertionsort(int[] data, int lo, int hi) {
	for(int i = lo+1; i < hi; i++) {
	    int current = data[i];
	    int j = i-1;
	    while(j >= lo && current < data[j]) {
		data[j+1] = data[j];
		j--;
	    }
	    data[j+1] = current;
	}
    }
    public static void insertionsort(int[] data) {
	for(int i = 1; i < data.length; i++) {
	    int current = data[i];
	    int j = i-1;
	    while(j >= 0 && current < data[j]) {
		data[j+1] = data[j];
		j--;
	    }
	    data[j+1] = current;
	}
    }
	
    public static void mergesortH(int[] data,  int lo, int hi) {
	if (lo >= hi) {
	    return;
	} else {
	    mergesortH(data, lo, (hi+lo)/2);
	    mergesortH(data,(hi+lo)/2+1, hi);
	    merge(data, lo, hi);
	}
    }
    public static void main(String[] args) {
	int[] data = new int[]{38, 27, 43, 3, 9, 82, 10};
	mergesort(data);
	System.out.println(Arrays.toString(data));
	// int[]MAX_LIST = {1000000000,500,10};
    	// for(int MAX : MAX_LIST){
    	//     for(int size = 31250; size < 2000001; size*=2){
    	// 	long qtime=0;
    	// 	long btime=0;
    	// 	//average of 5 sorts.
    	// 	for(int trial = 0 ; trial <=5; trial++){
    	// 	    int []data1 = new int[size];
    	// 	    int []data2 = new int[size];
    	// 	    for(int i = 0; i < data1.length; i++){
    	// 		data1[i] = (int)(Math.random()*MAX);
    	// 		data2[i] = data1[i];
    	// 	    }
    	// 	    long t1,t2;
    	// 	    t1 = System.currentTimeMillis();
    	// 	    Merge.mergesort(data2);
    	// 	    t2 = System.currentTimeMillis();
    	// 	    qtime += t2 - t1;
    	// 	    t1 = System.currentTimeMillis();
    	// 	    Arrays.sort(data1);
    	// 	    t2 = System.currentTimeMillis();
    	// 	    btime+= t2 - t1;
    	// 	    if(!Arrays.equals(data1,data2)){
    	// 		System.out.println("FAIL TO SORT!");
    	// 		System.exit(0);
    	// 	    }
    	// 	}
    	// 	System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    	//     }
    	//     System.out.println();
    	// }
    }
}
