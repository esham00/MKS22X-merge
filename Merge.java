import java.util.*;
public class Merge {
    public static void mergesort(int[] data) {
	mergesortH(data, 0, data.length-1);
    }
    public static void merge(int[] data, int hi){
	int[] left = new int[hi/2];
	int[] right = new int[hi/2];
	for(int i = 0; i < left.length; i++) {
	    left[i] = data[i];
	    right[i] = data[i+left.length];
	}
	int i = 0;
	int j = 0;
	int dataIndex = 0;
	while(i < left.length && j < right.length) {
	    if (left[i] < right[i]) {
		data[dataIndex] = left[i];
		i++;
	    } else {
		data[dataIndex] = right[j];
		j++;
	    }
	}
    }
    public static void mergesortH(int[] data, int lo, int hi) {
	if (lo >= hi) {
	    return;
	} else {
	    mergesortH(data, lo, hi/2);
	    mergesortH(data, (hi-lo)/2 + (data.length/2), hi);
	    merge(data, hi);
	}
    }
    public static void main(String[] args) {
	int[]data = new int[]{100,10,2,3,999,1,79,999,4};
	mergesort(data);
	System.out.println(Arrays.toString(data));
    }
}
