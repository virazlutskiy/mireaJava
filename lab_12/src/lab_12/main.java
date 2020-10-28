package lab_12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	public static void main(String[] args) {
		//new task1();
		//new task2();
		//new task3();
		//new task4();
		//new task5();
		//new task6();
		new task7();
	}

}
class task1{
	task1(){
	String input = "abdcxyz";
	myMatches("([a-z]*)([a-z]+)", input);
	myMatches("([a-z]?)([a-z]+)", input);
	myMatches("([a-z]+)([a-z]*)", input);
	myMatches("([a-z]?)([a-z]?)", input);
	}
	public static void myMatches(String regex,
		String input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if(matcher.matches()) {
		System.out.println("First group: "
		+ matcher.group(1));
		System.out.println("Second group: "
		+ matcher.group(2));
		} else
		System.out.println("nothing");
		System.out.println();
	}
}
class task2
{
	task2(){
		Pattern p1 = Pattern.compile("abcdefghijklmnopqrstuv18340");
		Matcher m1 = p1.matcher( "abcdefghijklmnopqrstuv18340" );
		boolean b = m1.matches();
		System.out.println(b);
		m1 = p1.matcher( "abcdefghijklmnoasdfasdpqrstuv18340" );
		b = m1.matches();
		System.out.println(b);
	}
}
class task3{
	task3(){
		String toParse = "100 USD, 100 EUR,99 RUB,100 SUD,25.98 USD,44 ERR, 0.004 EU, asd RUB"; 
		StringTokenizer st = new StringTokenizer(toParse,","); 
		
		Pattern p1 = Pattern.compile("\\d+.??\\d*? (USD|EUR|RUB)");
		Matcher m1;
		
		while(st.hasMoreTokens()){
			String token = st.nextToken().trim();
			m1 = p1.matcher(token);
			System.out.println(token + " " + m1.matches());
		}
	}
}
class task4{
	task4(){
		String str1 = "(1 + 8) – 9 / 4";
		String str2 = "6 / 5 – 2 * 9 ";
		Pattern p1 = Pattern.compile("\\d+ \\+");
		Matcher m1 = p1.matcher(str1);
		System.out.println(m1.find() + ": " + str1);
		m1 = p1.matcher(str2);
		System.out.println(m1.find() + ": " + str2);
	}
}
class task5{
	task5(){
		String dates[] = {"29/02/2000", "30/04/2003", "01/01/2003","29/02/2001", "30-04-2003", "1/1/1899"};
		Pattern p1 = Pattern.compile("\\d\\d/\\d\\d/[1-9][0-9]\\d\\d");
		Matcher m1;
		for(String date: dates)
		{
			m1 = p1.matcher(date);
			System.out.println((m1.find() && isValidDate(date)) + ": " + date);
		}
	}
	private static boolean isValidDate(String input) {
        String formatString = "dd/MM/yyyy";

        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);
            format.parse(input);
        } catch (ParseException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}

class task6{
	task6(){
		String emails[] = {"user@example.com", "root@localhost", "myhost@@@com.ru", "@my.ru", "Julia String","my@exemple.ru.com","my@ex..mple"};
		Pattern p1 = Pattern.compile("\\w+@\\w+((\\.)??\\w+)+");
		Matcher m1;
		for(String email: emails)
		{
			m1 = p1.matcher(email);
			System.out.println(m1.matches() + ": " + email);
		}
	}
}
class
task7{
	task7(){
		String passwords[] = {"F032_Password", "TrySpy11","TrySpy1", "smart_pass", "A007","Not@Good 123"};
		Pattern p1 = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}");
		p1 = Pattern.compile("(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])[_\\w]{8,}+");
		Matcher m1;
		for(String password: passwords)
		{
			m1 = p1.matcher(password);
			System.out.println(m1.matches() + ": " + password);
		}
	}
}