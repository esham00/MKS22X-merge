import java.util.*;
public class Merge {
    public static void mergesort(int[] data) {
	mergesortH(data, 0, data.length-1);
    }
    public static void mergesortH(int[] data, int lo, int hi) {
	if (lo >= hi) {
	    return;
	} else {
	    mergesortH(data, lo, hi/2);
	    mergesortH(data, hi/2, lo);
	    for(int i = 0; i < data.length-1; i++) {
		if (data[i+1] < data[i]) {
		    int old = data[i+1];
		    data[i+1] = data[i];
		    data[i] = old;
		}
	    }
	}
    }
    public static void main(String[] args) {
	int[]data = new int[]{100,10,2,3,4,999,1,79,999};
	mergesort(data);
	System.out.println(Arrays.toString(data));
    }
}
