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
	int[] left = new int[(hi-low)/2+1];
	int[] right = new int[(hi-low)/2+1];
	if (((hi-low)/2) % 2 == 1) {
	    right = new int[(hi-low)/2];
	}
	System.out.println("left length: " + left.length);
	System.out.println("right length: " + right.length);
	for(int i = 0; i < left.length; i++) {
	    left[i] = data[i+low];
	}
	for(int i = 0; i < right.length; i++) {
	    right[i] = data[i+left.length+low];
	}
	System.out.println(Arrays.toString(left));
	System.out.println(Arrays.toString(right));
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
	    System.out.println("low: " + lo + " high: " + hi);
	    mergesortH(data, lo, (hi+lo)/2);
	    mergesortH(data, (hi+lo)/2+1, hi);
	    merge(data, lo, hi);
	}
    }
    public static void main(String[] args) {
	int[]data = new int[]{38, 27,43,3,9,82,10};
	mergesort(data);
	System.out.println(Arrays.toString(data));
    }
}
