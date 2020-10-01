
public class main {

	public static void main(String[] args) {
		//task1
		///*
		Complex comp = new ConcreteFactory().createComlex();
		System.out.println(comp.toString());
		comp = new ConcreteFactory().createComplex(1,1);
		System.out.println(comp.toString());
		//*/
		
		//task2
		Client cli = new Client();
		ChairFactory CF = new ChairFactory();
		cli.setChair(CF.createFunctionalChair());
		cli.sit();
	}
}
//task1
class Complex{
	int real;
	int image;
	Complex(){real = 0; image = 0;}
	Complex(int real,int image){
		this.real = real;
		this.image = image;
	}
	public String toString()
	{
		return real + " " + image;
	}
}
interface CompexAbstractFactory{
	Complex createComlex();
	Complex createComplex(int real, int image);
}
class ConcreteFactory implements CompexAbstractFactory{

	@Override
	public Complex createComlex() {
		return new Complex();
	}

	@Override
	public Complex createComplex(int real, int image) {
		// TODO Auto-generated method stub
		return new Complex(real,image);
	}
}
//task2
interface Chair{
	void sit();
}
class Client{
	Chair chair;
	void sit() {
		chair.sit();
	}
	void setChair(Chair chair) {this.chair = chair;}
}

class VictorialChair implements Chair{
	private int age;
	public void sit() {System.out.println(getAge());}
	int getAge() {return age;}
	VictorialChair(int age){this.age = age;}
}
class MagicChair implements Chair {
	public void sit() {doMagic();}
	void doMagic() {System.out.println("Magic done!");}
}
class FunctionalChair implements Chair{
	public void sit() {System.out.println(sum(10,-5));}
	int sum(int a,int b) {return a+b;}
}

class ChairFactory implements AbstractChairFactory{

	@Override
	public VictorialChair createVictorialChair() {
		// TODO Auto-generated method stub
		return new VictorialChair(1);
	}

	@Override
	public MagicChair createMagicChair() {
		// TODO Auto-generated method stub
		return new MagicChair();
	}

	@Override
	public FunctionalChair createFunctionalChair() {
		// TODO Auto-generated method stub
		return new FunctionalChair();
	}}
interface AbstractChairFactory{
	VictorialChair createVictorialChair();
	MagicChair createMagicChair();
	FunctionalChair createFunctionalChair();
}
