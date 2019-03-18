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
	int[] left = new int[(hi-low)/2+1];
	int[] right = new int[(hi-low)/2+1];
	//if the half is odd then create an array that is 1 smaller than half
	if (((hi-low)/2) % 2 == 1) {
	    right = new int[(hi-low)/2];
	}
	// System.out.println("left length: " + left.length);
	// System.out.println("right length: " + right.length);
	//input values from the left half of the data
	for(int i = 0; i < left.length; i++) {
	    left[i] = data[i+low];
	}
	for(int i = 0; i < right.length; i ++) {
	    if (i + left.length+low == 31250) {
		System.out.println("index: " + i);
		System.out.println("right length: " + right.length);
		System.out.println("left length: " + left.length);
		System.out.println("low: " + low);
		System.out.println("high: " + hi);
		System.out.println("data length: " + data.length);
	    }
	}
	// System.out.println("low: " + low);
	// System.out.println("right: " +right.length);
	// System.out.println("high: " + hi);
	//input values from the right half of the array
	for(int i = 0; i < right.length; i++) {
	    //System.out.println(i);
	    right[i] = data[i+left.length+low];
	}
	// System.out.println(Arrays.toString(left));
	// System.out.println(Arrays.toString(right));
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
    public static void mergesortH(int[] data, int lo, int hi) {
	if (lo >= hi) {
	    return;
	} else {
	    // System.out.println("low: " + lo + " high: " + hi);
	    mergesortH(data, lo, (hi+lo)/2);
	    mergesortH(data, (hi+lo)/2+1, hi);
	    merge(data, lo, hi);
	}
    }
    public static void main(String[] args) {
	int[]data = new int[]{38, 27,43,3,9,82,10};
	mergesort(data);
	System.out.println(Arrays.toString(data));
	System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
	int[]MAX_LIST = {1000000000,500,10};
	for(int MAX : MAX_LIST){
	    for(int size = 31250; size < 2000001; size*=2){
		long qtime=0;
		long btime=0;
		//average of 5 sorts.
		for(int trial = 0 ; trial <=5; trial++){
		    int []data1 = new int[size];
		    int []data2 = new int[size];
		    for(int i = 0; i < data1.length; i++){
			data1[i] = (int)(Math.random()*MAX);
			data2[i] = data1[i];
		    }
		    long t1,t2;
		    t1 = System.currentTimeMillis();
		    Merge.mergesort(data2);
		    t2 = System.currentTimeMillis();
		    qtime += t2 - t1;
		    t1 = System.currentTimeMillis();
		    Arrays.sort(data1);
		    t2 = System.currentTimeMillis();
		    btime+= t2 - t1;
		    if(!Arrays.equals(data1,data2)){
			System.out.println("FAIL TO SORT!");
			System.exit(0);
		    }
		}
		System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
	    }
	    System.out.println();
	}
    }
}
