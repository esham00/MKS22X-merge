import java.util.*;
public class Merge {
    public static void mergesort(int[] data) {
	if (data.length == 0) {
	    return;
	}
	mergesortH(data, 0, data.length-1);
    }
    public static String toString(int[] data, int low, int hi) {
	String output = "";
	for(int i = low; i < hi; i++) {
	    output += data[i];
	}
	return output;
    }
    //dividing the array into two
    public static void merge(int[] data, int low, int hi){
	//half the array (left and right)
	int length = hi-low+1;
	//initializing the left and right arrays
	int[] right = new int[(length)/2];
	int[] left = new int[length - right.length];
    	//input values from the left half of the data & right half of the data
	for(int i = 0; i < left.length; i++) {
	    left[i] = data[i+low];
	    if (i < right.length) {
		right[i] = data[i+left.length+low];
	    }
	}
	// for(int i = 0; i < right.length; i++) {
	//     right[i] = data[i+left.length+low];
	// }
	//calling insertion sort if sorting less than 10 values
	if(right.length+left.length<10) {
	    // insertionsort(left);
	    //insertionsort(right);
	    insertionsort(data, low, hi);
	    // System.out.println(Arrays.toString(data));
	    
	    // System.out.println(Arrays.toString(left));
	    // System.out.println(Arrays.toString(right));
	    return;
	}
	//left index tracking
	int i = 0;
	//right index tracking
	int j = 0;
	//data tracking
	int dataIndex = low;
	while(i < left.length && j < right.length) {
	    //if the value from left array is less than or equal to right upload it to data
	    if (left[i] <= right[j]) {
		data[dataIndex] = left[i];
		i++;
	    } else {
		//if not upload the right value to data
		data[dataIndex] = right[j];
		j++;
	    }
	    dataIndex++;
	}
	//if there are still leftover values bc right is less than then upload the rest to data
	while (i < left.length) {
	    data[dataIndex] = left[i];
	    i++;
	    dataIndex++;
	}
	//same except if there are leftover values for right
	while (j < right.length) {
	    data[dataIndex] = right[j];
	    j++;
	    dataIndex++;
	}
    }
    //insertionsort
    public static void insertionsort(int[] data, int lo, int hi) {
	for(int i = lo+1; i < hi+1; i++) {
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
    //calling mergesort
    public static void mergesortH(int[] data,  int lo, int hi) {
	if (lo >= hi) {
	    return;
	} else {
	    //calling it on half
	    mergesortH(data, lo, (hi+lo)/2);
	    //calling it on the other half
	    mergesortH(data,(hi+lo)/2+1, hi);
	    //merging/sorting
	    merge(data, lo, hi);
	}
    }
  // private static final int INCREASE = 0;
  // private static final int DECREASE = 1;
  // private static final int STANDARD = 2;
  // private static final int SMALL_RANGE = 3;

  // private static String name(int i){
  //   if(i==INCREASE)return "Increassing";
  //   if(i==DECREASE)return "Decreassing";
  //   if(i==STANDARD)return "Normal Random";
  //   if(i==SMALL_RANGE)return "Random with Few Values";
  //   return "Error categorizing array";

  // }

  // private static int create(int min, int max){
  //   return min + (int)(Math.random()*(max-min));
  // }

  // private static int[]makeArray(int size,int type){
  //   int[]ans =new int[size];
  //   if(type == STANDARD){
  //     for(int i = 0; i < size; i++){
  //       ans[i]= create(-1000000,1000000);
  //     }
  //   }
  //   else if(type == INCREASE){
  //     int current = -5 * size;
  //     for(int i = 0; i < size; i++){
  //       ans[i]= create(current,current + 10);
  //       current += 10;
  //     }
  //   }
  //   else if(type == DECREASE){
  //     int current = 5 * size;
  //     for(int i = 0; i < size; i++){
  //       ans[i]= create(current,current + 10);
  //       current -= 10;
  //     }
  //   }
  //   else if(type == SMALL_RANGE){
  //     for(int i = 0; i < size; i++){
  //       ans[i]= create(-5,5);
  //     }
  //   }
  //   else{
  //     ans = new int[0];//empty is default
  //   }
  //   return ans;
  // }

  // public static void main(String[]args){
  //   if(args.length < 2)return;
    
  //   int size =  Integer.parseInt(args[0]);
  //   int type =   Integer.parseInt(args[1]);

  //   int [] start = makeArray(size, type);
  //   int [] result = Arrays.copyOf(start,start.length);
  //   Arrays.sort(result);
    
  //   long startTime = System.currentTimeMillis();
  //   /*
  //    * Test your sort here //yoursort(start);
  //    * Add code to switch which sort is tested by changing one of the args!
  //    */
  //   long elapsedTime = System.currentTimeMillis() - startTime;
  //   if(Arrays.equals(start,result)){
  //     System.out.println("PASS Case "+name(type)+"\t array, size:"+start.length+"\t"+elapsedTime/1000.0+"sec ");
  //   }else{
  //     System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
  //   }
  // }
    // public static void main(String[] args) {
    // 	int[] data = new int[]{38, 27, 43, 3, 9, 82, 10};
    // 	mergesort(data);
    // 	System.out.println(Arrays.toString(data));
    // 	int[]MAX_LIST = {1000000000,500,10};
    // 	for(int MAX : MAX_LIST){
    // 	    for(int size = 31250; size < 2000001; size*=2){
    // 		long qtime=0;
    // 		long btime=0;
    // 		//average of 5 sorts.
    // 		for(int trial = 0 ; trial <=5; trial++){
    // 		    int []data1 = new int[size];
    // 		    int []data2 = new int[size];
    // 		    for(int i = 0; i < data1.length; i++){
    // 			data1[i] = (int)(Math.random()*MAX);
    // 			data2[i] = data1[i];
    // 		    }
    // 		    long t1,t2;
    // 		    t1 = System.currentTimeMillis();
    // 		    Merge.mergesort(data2);
    // 		    t2 = System.currentTimeMillis();
    // 		    qtime += t2 - t1;
    // 		    t1 = System.currentTimeMillis();
    // 		    Arrays.sort(data1);
    // 		    t2 = System.currentTimeMillis();
    // 		    btime+= t2 - t1;
    // 		    if(!Arrays.equals(data1,data2)){
    // 			System.out.println("FAIL TO SORT!");
    // 			System.exit(0);
    // 		    }
    // 		}
    // 		System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    // 	    }
    // 	    System.out.println();
    // 	}
    // }
}
