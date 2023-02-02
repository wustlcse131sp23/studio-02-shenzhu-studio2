package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Starting amount between 0 and 50: ");
		double startAmount = in.nextDouble();
		System.out.print("The win probability in decimals: ");
		double winChance = in.nextDouble();
		System.out.print("The win limit: ");
		double winLimit = in.nextDouble();
		System.out.print("Total # of simulations: ");
		double totalSimulations = in.nextDouble();
		int count=0;
		int numberLose = 0;
		while (count<=totalSimulations)
		{
			double newAmount = startAmount;
			int numberPlay =0;
			
			while (newAmount>0 && newAmount<winLimit)
				{
					boolean win = Math.random()>(1-winChance);
					if (win==true)
					{
						newAmount++;
						numberPlay++;
					}
					else 
					{
						newAmount--;
						numberPlay++;		
					}
					
				}
			if (newAmount==0)
			{
				System.out.println("Day " + count + ": " + numberPlay + " LOSE");
				numberLose++;
			}
			else
			{	
				System.out.println("Day " + count + ": " + numberPlay + " WIN");
			}
			count++;
		}
		System.out.println("Losses: " + numberLose + " Simulations: "+ totalSimulations);
		System.out.println("Ruin rate from Simulation: "+ numberLose/totalSimulations);
		double a = (1-winChance)/winChance;
		double expectedRuin = (Math.pow(a, startAmount) -Math.pow(a, winLimit)) /(1-Math.pow(a, winLimit));
		System.out.println("Expected ruin rate: " + expectedRuin);
	}

}
