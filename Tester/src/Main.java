import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	//Stack used to hold the solutions that are pushed to the stack
		static Stack<Integer> solutionStack = new Stack<Integer>();
	
	//Main method for interaction with user to get the number of Queens used for game.
	
	public static void main(String[] args)
	{
		int userInput;
		System.out.println("Welcome to the Queens game");
		System.out.println("Enter the number of Queens to be placed.");
		System.out.println("The number of queens determine the size of the board");
		System.out.println("For example 9 queens create a board thats 9x9");
		
		
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		userInput = kb.nextInt();
	
		int totalSolutions = solve(userInput);
		
		System.out.println("THe number of solututions for " + userInput + " is " + totalSolutions);
		
	}
	
	/*Method to solve problem. Using a Boolean value the method will continue to search for possible solutions
	 * until all possible solutions are found
	 */
	public static int solve(int numOfQueens)
	{
		int numOfSolutions = 0;
		Boolean solution = true;
		Boolean noMoreSolutions;
		while(noMoreSolutions)
		{	
				int Queen = 0;
				for(int index = 0; index < numOfQueens; index ++)
				{
					if(solutionStack.empty()== true)
						solutionStack.push(index)
					else if(solutionStack.get(Queen) == Queen)
						solution = false;
						break;
						else if(solutionStack.get(index) == 
						solution = true;
						break;
					}
					if (solutionStack.empty() == true)
					{
						solutionStack.push(i);
					}
					else if(solutionStack.)
					
				}
			printBoard(solutionStack);
			
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



