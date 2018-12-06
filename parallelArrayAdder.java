package main_;
import java.util.*; import java.math.*; import java.io.*; import java.text.*;

public class Hitoshishinso {
	
	static HashMap<Long, Long> map = new HashMap<>();  
	static Scanner scan = new Scanner(System.in);
	static int N = 100; static long[] arr = new long[N];
	static int THREAD_MAX = 10;
	static class doraemon extends Thread{
		int left, right; long answer = 0; 
		doraemon(){}
		doraemon(int left, int right){this.left = left; this.right = right;}
		
		public void run() {
			
			try {
				for(int i=left; i<=right; i++) {
					System.out.printf(Thread.currentThread().getName()+" ");
					answer+= arr[i];
				}
			}
			catch(Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		doraemon t1 = new doraemon(0,2), t2 = new doraemon(3,5), t3 = new doraemon(6,8);
		t1.start(); t2.start(); t3.start(); 
		
		doraemon[] threads = new doraemon[THREAD_MAX];
		
		for(int i=0; i<100; i++) {arr[i] = i+1;}
		
		for(int i=0; i<THREAD_MAX; i++) {
			int left = (N/THREAD_MAX)*i, right = (N/THREAD_MAX)*(i+1)-1;
			right = Integer.min(right, N);
			System.out.printf(left+" "+right+" ");
			threads[i] = new doraemon(left, right);
			threads[i].start();
			if(right >= N) {break;}
		} 	
		
		try {
			long answer = 0; 
			for(int i=0; i<THREAD_MAX; i++) {threads[i].join();}
			
			for(int i=0; i<THREAD_MAX; i++) {answer+= threads[i].answer;}
			System.out.println();
			System.out.println(answer);		
		}
		
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}

}
