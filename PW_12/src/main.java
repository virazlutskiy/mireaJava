import java.util.Arrays;
import java.util.StringTokenizer;
public class main {

	public static void main(String[] args) {
		//new TestPerson();
		//new TestAdress();
		//new TestShirt();
		new TestphoneNumber();
	}

}
//task1
class TestPerson{
	TestPerson(){
		Person p1 = new Person("SurName");
		System.out.println(p1.get());
		Person p2 = new Person("SurName","Name","SecondName");
		System.out.println(p2.get());
	}
}
class Person{
	String Name;
	String SecondName;
	String Surname;
	
	Person(String _surname){
		Surname = _surname;
	}
	Person(String _surname, String _name, String _secondname){
		Surname = _surname;
		Name = _name;
		SecondName = _secondname;
	}
	String get()
	{
		if(SecondName == null || Name == null)
		{
			return Surname;
		}else
		{
			return Surname + " " + Name + " " + SecondName;
		}
	}
}

//task2
class TestAdress
{
	TestAdress()
	{
		try {
			Adress ad1 = new Adress("Россия, Москва, Москва, Уличная, 2, 8, 256");
			System.out.println(ad1.toString());	
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		try {
			Adress ad1 = new Adress("Россия. Москва, Москва, Уличная, 2, 8, 256");
			System.out.println(ad1.toString());	
		}catch(Exception e)
		{
			System.out.println(e);
		}
		try {
			Adress ad1 = new Adress("Россия, Москва, Москва, Уличная, 2, 8");
			System.out.println(ad1.toString());	
		}catch(Exception e)
		{
			System.out.println(e);
		}
		try {
			Adress ad1 = new Adress("Россия, Москва. Москва; Уличная, 2, 8; 256");
			System.out.println(ad1.toString());	
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
class Adress{
	String country;
	String region;
	String city;
	String street;
	String house;
	String building;
	String appartment;
		
	Adress(String adress)
	{
		//func1(adress);
		func2(adress);
	}
	public String toString()
	{
		return  country +
		 region +
		 city +
		 street +
		 house +
		 building +
		 appartment;
	}
	void func1(String adress){
		String arr[] = adress.split(",");
		country = arr[0].trim();
		region = arr[1].trim();
		city = arr[2].trim();
		street = arr[3].trim();
		house = arr[4].trim();
		building = arr[5].trim();
		appartment = arr[6].trim();
	}
	void func2(String adress){
		StringTokenizer st = new StringTokenizer(adress, ",.;");
		country = st.nextToken().trim();
		region = st.nextToken().trim();
		city = st.nextToken().trim();
		street = st.nextToken().trim();
		house = st.nextToken().trim();
		building = st.nextToken().trim();
		appartment = st.nextToken().trim();
	}
}

//task3
class TestShirt
{
	TestShirt(){
		String shirts[] = new String[11];
		shirts[0] = "S001,Black Polo Shirt,Black,XL";
		shirts[1] = "S002,Black Polo Shirt,Black,L";
		shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
		shirts[3] = "S004,Blue Polo Shirt,Blue,M";
		shirts[4] = "S005,Tan Polo Shirt,Tan,XL";
		shirts[5] = "S006,Black T-Shirt,Black,XL";
		shirts[6] = "S007,White T-Shirt,White,XL";
		shirts[7] = "S008,White T-Shirt,White,L";
		shirts[8] = "S009,Green T-Shirt,Green,S";
		shirts[9] = "S010,Orange T-Shirt,Orange,S";
		shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";
		
		Shirt ShirtArray[] = new Shirt[11];
		for(int i =0;i<11;i++)
		{
			ShirtArray[i] = new Shirt(shirts[i]);
		}
		for(Shirt shirt : ShirtArray)
		{
			System.out.println(shirt.toString());
		}
	}
}
class Shirt{
	String id;
	String name;
	String color;
	String size;
	Shirt(String shirt)
	{
		String arr[] = shirt.split(",");
		id = arr[0];
		name = arr[1];
		color = arr[2];
		size = arr[3];
	}
	public String toString()
	{
		return " Id: "+ id + " |Name: " + name + " |Color: "+ color + " |Size: "+ size;
	}
}

//task4
class TestphoneNumber{
	TestphoneNumber(){
		String str1 = "89161112222";
		String str2 = "+79001113333";
		String str3 = "+104289652211";
		phoneNumber pn;
		pn = new phoneNumber(str1);
		System.out.println("Before: " + str1 + "\nAfter: " + pn.get());
		pn = new phoneNumber(str2);
		System.out.println("Before: " + str2 + "\nAfter: "+ pn.get());
		pn = new phoneNumber(str3);
		System.out.println("Before: " + str3 + "\nAfter: "+ pn.get());
		
	}
}
class phoneNumber{
	String num;
	String get() {
		return num;
	}
	phoneNumber(String number){
		number = stringParser(number);
		String countryCode;
		String operatorCode;
		String num3;
		String num4;
		int size = number.length();
		num4 = number.substring(size-4, size);
		num3 = number.substring(size-7, size-4);
		operatorCode = number.substring(size-10, size-7);
		countryCode = number.substring(0,size-10);
		num = countryCode+operatorCode+ "-"+ num3 + "-"+ num4;
	}
	String stringParser(String str){
		if(str.startsWith("8"))
		{
			return str.replaceFirst("8", "+7");
		}
		return str;
	}
}

//task5
/*
 * В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом. В методе getLine() используя StringBuilder расставьте все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр. Каждое слово должно участвовать 1 раз.
 */