package lab_8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		FilesApp fa = new FilesApp();
	}
}

class FilesApp {
	FilesApp(){
		try(FileWriter writer = new
			FileWriter("notes.txt", false))
			{
				writer.write("Мама мыла раму, раму мыла мама");
				writer.flush();
			 }
			 catch(IOException ex){
				 System.out.println(ex.getMessage());
			 }
	//append to the end
	try(FileWriter writer = new
			FileWriter("notes.txt", true))
			{
				writer.append("\nОт топота копыт, пыль по полю летит");
				writer.flush();
			 }
			 catch(IOException ex){
				 System.out.println(ex.getMessage());
			 }
	try(FileReader reader = new
			FileReader("notes.txt"))
			 {
				 int c;
				 while((c=reader.read())!=-1){
					 System.out.print((char)c);
				 }
			 }
			 catch(IOException ex){
				 System.out.println(ex.getMessage());
			 } 
	}
}