package lab_9;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		ThrowsDemo TD = new ThrowsDemo();
		TD.getKey();

	}

}
class Exception1 { 
    public void exceptionDemo() { 
       try{
                            System.out.println( 2 / 0 ); 
           } catch ( ArithmeticException e ) {
                             System.out.println("Attempted division by zero"); 
           }
     } 
}

class Exception2 { 
    public void exceptionDemo() { 
    	try {
          Scanner myScanner = new Scanner( System.in ); 
          System.out.print( "Enter an integer ");
                        String intString = myScanner.next();
                        int i = Integer.parseInt(intString); System.out.println( 2 / i ); 
    	}
    	catch ( ArithmeticException e ) {
            System.out.println("Attempted division by zero"); 
    	}
    	catch (Exception e)
    	{
    		System.out.println(e);
    	}
    	finally {
    		System.out.println("Programm finished it work");
    	}
     } 
} 


class ThrowsDemo { 
	public void getKey(){ 
		while(true) {
			try {
				Scanner myScanner = new Scanner( System.in ); 
				System.out.print("Enter Key ");
				String key = myScanner.nextLine();
				printDetails( key );
				break;
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	} 
	public void printDetails(String key) throws Exception { 
		String message = getDetails(key); 
		System.out.println( message ); } 
	
		private String getDetails(String key) throws Exception { 
			if(key.equals("")) {
				throw new Exception( "Key set to empty string" ); 
			} 
				return "data for " + key; 
	} 
} 

