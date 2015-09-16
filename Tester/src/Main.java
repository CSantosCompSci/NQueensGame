import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	//Stack used to hold the solutions that are pushed to the stack
		Stack<Integer> solutionStack = new Stack<Integer>();
	
	//Main method for interaction with user to get the number of Queens used for game.
	
	public static void main(String[] args)
	{
		int userInput;
		System.out.println("Welcome to the Queens game");
		System.out.println("Enter the number of Queens to be placed.");
		System.out.println("The number of queens determine the size of the board");
		System.out.println("For example 9 queens create a board thats 9x9");
		
		
		Scanner kb = new Scanner(System.in);
		userInput = kb.nextInt();
	
		int totalSolutions = solve(userInput);
		
		System.out.println("THe number of solututions for " + userInput + " is " + totalSolutions);
		
	}
	
	/*Method to solve problem. Using a Boolean value themethod will continue to search for possible solutions
	 * until all possible solutions are found
	 */
	public static int solve(int numbOfQueens)
	{
		Boolean moreSolutions = true;
				
				while(moreSolutions)
				{
					
				}
		
		return number;
	}
	
	
	/* Using the solution stack this method prints the board using a Q to represent the queen and a * to represent the 
	 * an empty square
	 */
	public static void printBoard(Stack<Integer> solution)
	{
		for(int i = 0; i <= solution.size(); i++)
		{
			for(int j = 0; j < solution.size();j++)
			{
				if( j == solution.get(i))
					System.out.print("Q");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
}



