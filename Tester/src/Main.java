import java.util.Scanner;
import java.util.Stack;

public class Main {
	Stack<Integer> solutionStack = new Stack<Integer>();
	
	public static void main(String[] args)
	{
		int userInput;
		System.out.println("Welcome to the Queens game");
		System.out.println("Enter the number of Queens to be placed.");
		System.out.println("The number of queens determine the size of the board");
		System.out.println("For example 9 queens create a board thats 9x9");
		
		try{
		Scanner kb = new Scanner(System.in);
		userInput = kb.nextInt();
		}catch{Exception e}
		
		solve(userIntput);
		
	}
	
	public static void solve(int numbOfQueens)
	{
		
	}
	public static void printBoard(Stack<Integer> solution)
	{
		for
	}
}



