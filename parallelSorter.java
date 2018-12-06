package main_;
import java.util.*; import java.io.*; import java.math.*; import java.text.*;

public class parallelSort {
	
	static Scanner scan = new Scanner(System.in);
	static int MAX = 100, THREAD_MAX = 100; static long[] arr = new long[MAX];
	static doraemon[] threads = new doraemon[THREAD_MAX];
	static class doraemon extends Thread{
		int left , right; 
		doraemon(int left, int right){this.left=left; this.right=right;}
		
		public void run() {
			try {
				if(arr[left] > arr[right]) {
					long temp = arr[left]; arr[left] = arr[right]; arr[right] = temp;
				}
			}
			catch(Exception e) {System.out.println(e.getStackTrace());}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		
		for(int i=0; i<MAX; i++) {arr[i] = (int)((Math.random()*100))%50;}
		for(int i=0; i<MAX; i++) {System.out.printf(arr[i]+" ");} System.out.println();
		boolean chance = false; 
		for(int k=0; k<100; k++) {
			int thread_count = 0;
			int start = 0; if(chance) {start = 1; chance= false;} else {chance = true;}
			for(int i= start; i< MAX && i+1 < MAX; i+=2) {
				threads[thread_count] = new doraemon(i, i+1); 
				threads[thread_count++].start();
			}
			int tempIndex = 0; 
			while(tempIndex < THREAD_MAX && threads[tempIndex]!=null) {
				threads[tempIndex].join(); tempIndex++; 
			}
				
		}
		for(int i=0; i<MAX; i++) {System.out.printf(arr[i]+" ");}
	}

}
