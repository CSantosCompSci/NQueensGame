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
				System.out.println("stack = " + solutionStack.size());
				System.out.println();

				for(int j = 0; j < solutionStack.size(); j++)
				{
					System.out.println("For loop");
					System.out.println("j = " + j);
					System.out.println("stack " + solutionStack.toString());
					System.out.println("size " + solutionStack.size());
					System.out.println("col = " +columnNumber);
					System.out.println();

					
					if(solutionStack.get(j) == columnNumber)
					{
				
						System.out.println("1st if");
					System.out.println("j = " +	solutionStack.get(j));
				
					System.out.println("stack " + solutionStack.toString());
					System.out.println("size " + solutionStack.size());
					System.out.println("col = " + columnNumber);
					columnNumber++;
					System.out.println();
					break;

					}
					 
					if(Math.abs(solutionStack.get(j) - columnNumber) == Math.abs(j - solutionStack.size()))
					{	
					System.out.println("get j = " + solutionStack.get(j));
					System.out.println("col = " + columnNumber);
					System.out.println("j =" + j);
					System.out.println("size = " + solutionStack.size());
					System.out.println("rowdif = " + Math.abs(solutionStack.get(j) - columnNumber));
					System.out.println("colDif = " + Math.abs(j - solutionStack.size()));
					System.out.println("2nd if");
					System.out.println("stack" + solutionStack.toString());
					System.out.println("size " + solutionStack.size());
					System.out.println("col = " +columnNumber);
					columnNumber++;
					break;
					}
					 if(columnNumber == numOfQueens)
					{
						columnNumber = solutionStack.pop() ;
					
					System.out.println("3rd if");
					System.out.println("stack = " + solutionStack.toString());
					System.out.println("size" + solutionStack.size());
					System.out.println("col = " +columnNumber);
					System.out.println();
					}
					if(solutionStack.size() == numOfQueens)
					{
						numOfSolutions++;
						printBoard(solutionStack);
					    columnNumber = solutionStack.pop() + 1 ;
						System.exit(1);
						
					}
					if(solutionStack.isEmpty() && columnNumber == numOfQueens)
					 	noMoreSolutions = true;
					if(solutionStack.get(j) != columnNumber && Math.abs(solutionStack.get(j) - columnNumber) != Math.abs(j - solutionStack.size()))
					{
					
						System.out.println("else");
						System.out.println("stack " +solutionStack.toString());
						System.out.println("size " +solutionStack.size());
						System.out.println(columnNumber);
						System.out.println();

						solutionStack.push(columnNumber);
						columnNumber = 0;
						break;
					}
					else 
					columnNumber++;
				}
			}
			return numOfSolutions;
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



