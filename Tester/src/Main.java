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
		System.out.println(solutionStack.toString());
		while(columnNumber < numOfQueens)
			{
			
				if(solutionStack.size() == numOfQueens  )//filled == numOfQueens)
				{
					System.out.println("Exit 2");

					numOfSolutions++;
					printBoard(solutionStack);
					//noMoreSolutions = true;
				}else
				if (solutionSpace(solutionStack, columnNumber) == true)
				{
					System.out.println("Exit 3");
					solutionStack.push(columnNumber);
					System.out.println(solutionStack.toString());
					System.out.println(solutionStack.size());
					System.out.println("colNum = " +columnNumber);

					filled++;
					
				}else
				if(solutionSpace(solutionStack, columnNumber) == false)
				{
					System.out.println("Exit 4");
					columnNumber++;
					System.out.println("colNum = " +columnNumber);
					System.out.println(solutionStack.peek());
					solutionStack.push(solutionStack.pop()+1);
					System.out.println("Stack after pop " + solutionStack.toString());

					filled--;
					
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
			for( int j = 0; j < workingStack.size(); j++)
			{	
				if(workingStack.get(j) == columnNumber)
				{
					System.out.println("j " + j);
					System.out.println("colNum = " +columnNumber);
					System.out.println(workingStack.get(j));
					isSolution =  false;
				
				}
				else if(Math.abs(workingStack.get(j)- j ) == Math.abs(columnNumber -j))
				{
					System.out.println(Math.abs(rowNumber- columnNumber) + "hello"+Math.abs(rowNumber - solutionStack.size()) );
					isSolution = false;
					
				}
				else
				{
					isSolution = true;
				
				}
			}
			System.out.println(isSolution);
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



