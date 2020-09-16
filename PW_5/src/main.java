import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		//task_1 task1 = new task_1();
		//task_2 task2 = new task_2();
		//task_3 task3 = new task_3();
		task_4 task4 = new task_4();
		//task_5 task5 = new task_5();
		
		
	}

}
class task_1
{
	public int max;
	task_1()
	{
		Scanner in = new Scanner(System.in);  
		max = in.nextInt();
		recursion(1);
	}
	void recursion(int num){
		for(int i = 0;i<num;i++)
		{
			System.out.print(num + " ");
		}
		
		if(num < max)
		{
			recursion(num+1);
		}
	}
}
class task_2{
	int max;
	task_2()
	{
		Scanner in = new Scanner(System.in);  
		max = in.nextInt();
		recursion(1);
	}
	void recursion(int num) {
		System.out.print(num + " ");
		if(num < max)
			recursion(num+1);
	}
}
class task_3{
	task_3()
	{
		int A,B;
		Scanner in = new Scanner(System.in);  
		A = in.nextInt();
		B = in.nextInt();
		recursion(A,B);
	}
	void recursion(int a, int b) {
		if(a<b)
		{
			System.out.print(a + " ");
			recursion(a+1,b);
		}
		if(a>b)
		{
			System.out.print(a + " ");
			recursion(a-1,b);
		}
		if(a==b)
		{
			System.out.print(b + " ");
		}
	}
}
class task_4{
	task_4()
	{
		int k,d;
		int sum = 0;
		Scanner in = new Scanner(System.in);  
		k = in.nextInt();
		d = in.nextInt();
		for(int i = (int) Math.pow(10, k-1); i<Math.pow(10, k)-1;i++)
		{
			if(recursion(i) == d)
				sum++;
		}
		System.out.print(sum);
	}
	int recursion(int n) {
		if(n>0)
		{
			return  n%10 + recursion(n/10);
		}
			return 0;
	}
}
class task_5{
	task_5()
	{
		int N;
		Scanner in = new Scanner(System.in);  
		N = in.nextInt();
		System.out.println(recursion(N));
	}
	int recursion(int n) {
		if(n>0)
		{
			return 1 + recursion(n/10);
		}
			return 0;
	}
}