import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class File_create {
	
	public static void main(String args[]) {
		Runnable run1=new Runnable(){
			public void run(){
				Scanner sc=new Scanner(System.in);
				 PrintStream o1;
				try {
					o1 = new PrintStream("thread1.txt");
					
				 PrintStream console=System.out;
				 	System.out.println("enter the content into the file1");
				 		String s1=sc.nextLine();
				 		o1.printf(s1);
				
				 Date date = new Date();
			        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			        	String formattedDate = sdf.format(date);                  
			        		o1.println("\n\t\t\t--"+formattedDate); 
					} catch (FileNotFoundException e) {
							e.printStackTrace();
					  }
			}
			
		};
		
		Runnable run2=new Runnable(){
			public void run(){
				Scanner sc2=new Scanner(System.in);
				 PrintStream o2;
				 PrintStream console=System.out;
				 
				 try {
					o2 = new PrintStream("thread2.txt");
					
				 System.setOut(console);
				 System.out.println("enter the content into the file2");
				 	String s2=sc2.nextLine();
				 		
				 			o2.printf(s2);
				
				 Date date = new Date();
			        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			        	String formattedDate = sdf.format(date);                  
			        		o2.println("\n\t\t\t--"+formattedDate); 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable run3=new Runnable(){
			public void run(){
				Scanner sc3=new Scanner(System.in);
				 PrintStream o3;
				try {
					o3 = new PrintStream("thread3.txt");
					
				 PrintStream console=System.out;
				
				 System.out.println("enter the content into the file3");
				 	String s3=sc3.nextLine();
				 		o3.printf(s3);
				
				 Date date = new Date();
			        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			        	String formattedDate = sdf.format(date);                  
			        		o3.println("\n\t\t\t--"+formattedDate); 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				  }
		
			}
		};
		class Join extends Thread{
		public void run(){  
			  for(int i=1;i<=5;i++){  
			   try{  
				   Thread.sleep(5000);  
			   }catch(Exception e){System.out.println(e);}  
			   		System.out.println(i);  
			  	}  
		 	}
		 }

		Thread t1=new Thread(run1);
		t1.start();
		try{  
			  t1.join();  
			}
			catch(Exception e){
				System.out.println(e);
			 }
		Thread t2=new Thread(run2);
		t2.start();
		try{  
			t2.join();  
			}
			catch(Exception e){
				System.out.println(e);
			 }
		Thread t3=new Thread(run3);
		t3.start();
		try{  
			  t3.join();  
			}
			catch(Exception e){
				System.out.println(e);
			 }
		
	}
}