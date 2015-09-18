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
		int filled = 0;
		int columnNumber = 0;
		boolean noMoreSolutions =false;
		solutionStack.push(columnNumber);
		System.out.println("Exit 1");
		while(noMoreSolutions )
		{	
			for(int j = 0; j < numOfQueens; j++)
			{
				if(solutionStack.size() == numOfQueens && filled == numOfQueens)
				{
					System.out.println("Exit 2");

					numOfSolutions++;
					printBoard(solutionStack);
					noMoreSolutions = false;
				}else
				if (solutionSpace(solutionStack, columnNumber) == true)
				{
					System.out.println("Exit 3");

					solutionStack.push(columnNumber);
					filled++;
				}else
				if(solutionSpace(solutionStack, columnNumber) == false)
				{
					System.out.println("Exit 4");

					solutionStack.push(solutionStack.pop()+1);
					filled--;
				}
						
				
				else 
				{
					columnNumber++;
				}
			}
		}
		System.out.println("Exit 1");
		
		return numOfSolutions;
	}

	// Boolean solution that returns true if space is a valid anwser. False for when it is not a solution space.

	public static boolean solutionSpace(Stack<Integer> workingStack, int columnNumber)
	{
		
			Boolean isSolution  = false;
			int rowNumber  = workingStack.peek();
		
				if(rowNumber == columnNumber)
				{
					isSolution = false;
				}
				else if(Math.abs(rowNumber- columnNumber) == Math.abs(rowNumber - solutionStack.size()))
				{
				isSolution = false;
				}
				else
				{
					isSolution = true;
				}
			return isSolution;
	}
	/* Using the solution stack this method prints the board using a Q to represent the queen and a * to represent the 
	 * an empty square
	 */
	public static void printBoard(Stack<Integer> solution)
	{
		for(int i = 0; i < solution.size(); i++)
		{
			for(int j = 0; j < solution.size();j++)
			{
				if( j == solution.get(i))
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
}



