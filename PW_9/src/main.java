import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		task1 t1 = new task1();
	}

}


class userDoesntFoundException 
extends RuntimeException {
	public userDoesntFoundException(String errorMessage) {
		super(errorMessage);
	}
}

class task1{
	 Map<Integer, String> db = new HashMap<Integer, String>();
	 void prepareDb()
	 {
		db.put(123,"Tom");
		db.put(124,"Bob");
		db.put(125,"Carl");	 
	 }
	 task1(){
		//initilizinf db
		prepareDb();
		Scanner myScanner = new Scanner( System.in ); 
		
		System.out.print("Enter your name: ");
		String name = myScanner.nextLine();
		System.out.print("Enter your name: ");
		int inn = myScanner.nextInt();
		
		try {
			if(db.get(inn).contentEquals(name))
			{
				System.out.println("Access granted");
			}else
			{
				throw new userDoesntFoundException("User doesn't found");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
//LabClass
class Student{}
class EmptyStringException{}
class LabClassUI{}
class LabClass{}
class LabClassDriver{}
class StudentNotFoundException{}