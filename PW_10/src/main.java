
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;


public class main {

	public static void main(String[] args) {
		//task1
		/*
		Complex comp = new ConcreteFactory().createComlex();
		System.out.println(comp.toString());
		comp = new ConcreteFactory().createComplex(1,1);
		System.out.println(comp.toString());
		//
		
		//task2
		Client cli = new Client();
		ChairFactory CF = new ChairFactory();
		cli.setChair(CF.createFunctionalChair());
		cli.sit();
		
		*/
		//task 3
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type 1 for TextDocument \nType 2 for ImageDocument \nType 3 for MusicDocument");
		int type = scanner.nextInt();
		
		JFrame.setDefaultLookAndFeelDecorated(true);
        new JMenuTest(type);
        
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

//task 3
interface IDocument{
	String toString();
}
interface ICreateDocument
{
	IDocument CreateNew();
	IDocument CreateOpen();
}
class TextDocument implements IDocument{
	TextDocument(){
		System.out.println("New TextDocument created!");
	}
}
class ImageDocument implements IDocument{
	ImageDocument(){
		System.out.println("New ImageDocument created!");
	}
}
class MusicDocument implements IDocument{
	MusicDocument(){
		System.out.println("New MusicDocument created!");
	}
}

class CreateTextDocument implements ICreateDocument{

	@Override
	public IDocument CreateNew() {
		return new TextDocument();
	}

	@Override
	public IDocument CreateOpen() {
		return new TextDocument();
	}

}
class CreateImageDocument implements ICreateDocument{

	@Override
	public IDocument CreateNew() {
		return new ImageDocument();
	}

	@Override
	public IDocument CreateOpen() {
		return new ImageDocument();
	}

}
class CreateMusicDocument implements ICreateDocument{

	@Override
	public IDocument CreateNew() {
		return new MusicDocument();
	}

	@Override
	public IDocument CreateOpen() {
		return new MusicDocument();
	}

}

class JMenuTest extends JFrame 
{
	
	private static final long serialVersionUID = 1L;
	ICreateDocument fabric;
    //--------------------------------------------------------
    /**
     * Конструктор класса
     */
    public JMenuTest(int type) 
    {
        super("Системное меню");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        // Устанавливае фабрику
        
    	switch(type)
    	{
    	case 1:
    		fabric = new CreateTextDocument();
    		break;
    	case 2:
    		fabric = new CreateImageDocument();
    		break;
    	case 3:
    		fabric = new CreateMusicDocument();
    		break;
    	default:
    		break;
    	}
        // Создание строки главного меню
        JMenuBar menuBar = new JMenuBar();
        // Добавление в главное меню выпадающих пунктов меню  
        menuBar.add(createFileMenu());
        // Подключаем меню к интерфейсу приложения
        setJMenuBar(menuBar);
        // Открытие окна
        setSize(300, 200);
        setVisible(true);
        
    }
    //--------------------------------------------------------
    /**
     * Функция создания меню "Файл"
     * @return
     */
    private JMenu createFileMenu()
    {
        // Создание выпадающего меню
        JMenu file = new JMenu("Файл");
        
        JMenuItem open = new JMenuItem("Открыть", 
        new ImageIcon("images/open.png"));
        
        JMenuItem _new = new JMenuItem("Создать");
        JMenuItem save = new JMenuItem("Сохранить");
        
        JMenuItem exit = new JMenuItem(new ExitAction());
        exit.setIcon(new ImageIcon("images/exit.png"));
        file.add(_new);
        file.addSeparator();
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.addSeparator();
        file.add(exit);

        ActionListener NewOpenAction = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	fabric.CreateOpen();
            }
        };
        open.addActionListener(NewOpenAction);
        _new.addActionListener(NewOpenAction);
        return file;
    }
    
    //--------------------------------------------------------
    /**
     * Вложенный класс завершения работы приложения 
     */
    class ExitAction extends AbstractAction
    {
        private static final long serialVersionUID = 1L;
        ExitAction() {
            putValue(NAME, "Выход");
        }
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
