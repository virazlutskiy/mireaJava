import java.util.Scanner;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		drunkard_game task1 = new drunkard_game();

	}

}
class drunkard_game {
	Stack<Integer> FirstPlayer = new Stack<Integer>();
	Stack<Integer> tmpFirstPlayer = new Stack<Integer>();
	Stack<Integer> SecondPlayer = new Stack<Integer>();
	Stack<Integer> tmpSecondPlayer = new Stack<Integer>();
	drunkard_game(){
		firstTask();
	}
	void firstTask(){
		Scanner in = new Scanner(System.in);
			//
		for(int i = 0;i<5;i++)
		{
			tmpFirstPlayer.push(in.nextInt());
		}
		for(int i = 0;i<5;i++)
		{
			tmpSecondPlayer.push(in.nextInt());
		}
		for(int i = 0;i<5;i++)
		{
			//Перезапись в обратном порядке. 
			FirstPlayer.push(tmpFirstPlayer.pop());
			SecondPlayer.push(tmpSecondPlayer.pop());
		}
		
		int counter = 0;
		while(counter<106)
		{
			counter ++;
			
			int a,b;
			a = FirstPlayer.pop();
			b = SecondPlayer.pop();
			if(whoWon(a,b))
			{
				tmpFirstPlayer.push(a);
				tmpFirstPlayer.push(b);
				
			}else
			{
				tmpSecondPlayer.push(a);
				tmpSecondPlayer.push(b);
			}
			
			if(FirstPlayer.isEmpty())
			{
				while(!tmpFirstPlayer.isEmpty())
				{
					FirstPlayer.push(tmpFirstPlayer.pop());
				}
			}
			if(SecondPlayer.isEmpty())
			{
				while(!tmpSecondPlayer.isEmpty())
				{
					SecondPlayer.push(tmpSecondPlayer.pop());
				}
			}
			
			//end game checker
			if(FirstPlayer.isEmpty() && !SecondPlayer.isEmpty())
			{
				System.out.println("second at " + (counter));
				break;
			}else if(!FirstPlayer.isEmpty() && SecondPlayer.isEmpty())
			{
				System.out.println("first at " + (counter));
				break;
			}
			else if (counter == 106)
			{
				System.out.println("botva");
				break;
			}
		}
		
	}
	boolean whoWon(int first, int second)
	{
		if(first == 0 && second == 9)
			return true;
		if(second == 0 && first == 9)
			return false;
		return first>second ? true : false;
	}
}