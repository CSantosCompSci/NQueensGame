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
		int columnNumber = 0;
		boolean noMoreSolutions =false;
		solutionStack.push(columnNumber);
		while(!noMoreSolutions)
			{
					if(solutionStack.size() == numOfQueens)
					{
						numOfSolutions++;
						printBoard();
						columnNumber = backTrack(numOfQueens);
					}
					if(solutionStack.isEmpty() && columnNumber == numOfQueens )
					{
						noMoreSolutions = true;
					}
					if(isValid(columnNumber))
					{
						solutionStack.push(columnNumber);
						columnNumber = 0;
					
					}
					
					if(!isValid(columnNumber))
					{
						columnNumber++;
						
						if(columnNumber == numOfQueens)
						{
							columnNumber = backTrack(numOfQueens);
						
						}
					}
					
			}
			return numOfSolutions;
	}
	/* Using the solution stack this method prints the board using a Q to represent the queen and a * to represent the 
	 * an empty square
	 */
	public static void printBoard()
	{
		for(int i = 0; i < solutionStack.size(); i++)
		{
			for(int j = 0; j < solutionStack.size();j++)
			{
				if( j == solutionStack.get(i))
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static boolean isValid(int colNum)
	{
		boolean valid = true;
		for(int i = 0 ; i < solutionStack.size(); i ++)
		{
	
			if(solutionStack.get(i) == colNum || (Math.abs(solutionStack.get(i) - colNum) == Math.abs(i - solutionStack.size())))
					valid = false;
		}
		return valid;
		
	}
	public static int backTrack(int queens)
	{
		int number = 0;
		if(solutionStack.size()== 1 && solutionStack.get(0) == queens -1)
		{	
			solutionStack.pop();
			 return number = queens;
		}
		number = solutionStack.peek() ;
		if(number == queens -1 )
		{
			solutionStack.pop();
			number = solutionStack.pop()+1;
		}
		else
			number = solutionStack.pop()+1;
		return number;
		
	}
}



