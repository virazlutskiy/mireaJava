import java.util.Scanner;

public class calculator {
	calculator(){
		//test1();
		//test2();
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		new ExpressionParser().TripleExpressionParser(str);
	}
	void test1(){
		System.out.println(
				new Subtract(
			              new Multiply(
			                  new Const(2),
			                  new Variable("x")
			                  ),
			                   new Const(3)
			             ).evaluate(5)
		);
	}
	void test2() {
		Scanner in = new Scanner(System.in);
		System.out.println("x = ?");
		System.out.println(
				new Add(
					new Const(1),
					new Subtract(
						new Multiply(new Variable("x"),new Variable("x")),
						new Multiply(new Const(2),new Variable("x"))
					)
			    ).evaluate(in.nextInt())
		);
		
	}
}

interface Operation
{
	double evaluate(double num);
}
abstract class Operations implements Operation
{
	Operation o1; 
	Operation o2;
	
	Operations(Operation o1, Operation o2)
	{
		this.o1 = o1;
		this.o2 = o2;
	}
}
class Const implements Operation{
	double c;
	Const(double c){this.c = c;}
	
	@Override
	public double evaluate(double num) {
		return c;
	}
	public double evaluate() {
		return c;
	}
}
class Variable implements Operation
 {
	 String variable;
	 Variable(String v)
	 {
		 variable = v;
	 }
	@Override
	public double evaluate(double num) {
		return num;
	}

 }
 
 class Add extends Operations implements Operation{
	
	Add(Operation o1, Operation o2) {
		super(o1, o2);
	}

	@Override
	public double evaluate(double num) {
		return o1.evaluate(num) + o2.evaluate(num);
	}
	
}
 class Subtract extends Operations implements Operation{
	Subtract(Operation o1, Operation o2)
	{
		super(o1,o2);
	}
	@Override
	public double evaluate(double num) {
		return o1.evaluate(num) - o2.evaluate(num);
	}
}
 class Multiply extends Operations implements Operation{
	 Multiply(Operation o1, Operation o2)
		{
			super(o1,o2);
		}
		@Override
		public double evaluate(double num) {
			return o1.evaluate(num) * o2.evaluate(num);
		}
	}
 class Divide extends Operations implements Operation{
	 Divide(Operation o1, Operation o2)
		{
			super(o1,o2);
		}
		@Override
		public double evaluate(double num) {
			return o1.evaluate(num) / o2.evaluate(num);
		}
	}
