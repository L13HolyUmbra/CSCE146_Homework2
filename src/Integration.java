//imports
import java.util.Scanner;

/**
 * @author Dion de Jong 
 * @version 1.0 15 January 2014
 * This program receives a number of inputs from the user in order 
 * to estimate or calculate an integration, such as the a, b, and c values for a quadratic function, 
 * the number of partitions, and the starting and ending points for the estimate.
 */ 

//main class
public class Integration {

	//Create the quadratic method that solves for the quadratic equation value
	public static double Quadratic(double QA, double QB, double QC, double QX)
	{
		return QA*QX*QX + QB*QX + QC; 
	}
	
	//The method that solves for the Right Sum when called, using the user inputs. 
	public static double RightRiemannSum(double QA, double QB, double QC, double Parts, double BeginPt, double width)
	{
		double RRsum = 0; 
		//needs a loop, starting at 1, since this is a right sum, that will find the sum of all partitions' areas. 
		for (int i = 1; i <= Parts; i++)
		{
			RRsum += Quadratic(QA,QB,QC,i*width + BeginPt) * width; 
		}
		return RRsum;
	}
	
	//The method that solves for the Left Sum when called, using the user inputs
	public static double LeftRiemannSum(double QA, double QB, double QC, double Parts, double BeginPt, double width)
	{
		double LRsum = 0; 
		//needs a loop, starting at 0, since this is a left sum, that will find the sum of all partitions' areas.
		for (int i = 0; i < Parts; i++)
		{
			LRsum += Quadratic(QA,QB,QC,i*width + BeginPt) * width; 
		}
		return LRsum;
	}
	//
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create a scanner
		Scanner keyboard = new Scanner(System.in);
		
		//Program's opening line.
		System.out.println("Welcome to Dion's Integration calculator!");
		
		//Retrieve required input values from the user. 
		System.out.println("In the equation Ax^2 + Bx + C, what is your A value?");
		double QA = keyboard.nextDouble();
		
		System.out.println("In the equation Ax^2 + Bx + C, what is your B value?");
		double QB = keyboard.nextDouble();
		
		System.out.println("In the equation Ax^2 + Bx + C, what is your C value?");
		double QC = keyboard.nextDouble();
		
		System.out.println("What is the starting point of the interval of integration?");
		double BeginPt = keyboard.nextDouble();
		
		System.out.println("What is the end point of the interval of integration?");
		double EndPt = keyboard.nextDouble();
		
		System.out.println("How many partitions do you want to estimate with?");
		double Parts = keyboard.nextDouble();

		//solve for the width the partitions using the given information
		double width = Math.abs((EndPt - BeginPt)/Parts);  
		
		//Print out the required data: The Left and Right Riemann Sums. 
		System.out.println("The left Riemann Sum is " + LeftRiemannSum(QA,QB,QC,Parts,BeginPt,width)); 
		System.out.println("The right Riemann Sum is " + RightRiemannSum(QA,QB,QC,Parts,BeginPt,width));
	}

}
