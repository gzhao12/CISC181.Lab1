package pkgMain;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the amount of years you plan to work: ");
		int workYrs = input.nextInt();
		
		System.out.print("Enter your investment interest rate (in %): ");
		double investInterest = input.nextDouble()/100;
		
		System.out.print("Enter the amount of years you plan to be retired for: ");
		int retiredYrs = input.nextInt();
		
		System.out.print("Enter your payback interest rate (in %): ");
		double paybackInterest = input.nextDouble()/100;
		
		System.out.print("Enter how much money you would like to withdraw each month during retirement: ");
		double income = input.nextDouble();
		
		System.out.print("Enter your monthly SSI: ");
		double monthlySSI = input.nextDouble();
		
		double anualWithdraw = 12*(income-monthlySSI);
		//double amountWithdrawn = retiredYrs*anualWithdraw;
		
		double amountSaved = ((Math.pow(1 + paybackInterest,retiredYrs) - 1)*(anualWithdraw/paybackInterest))/Math.pow(1 + paybackInterest, retiredYrs);
		double monthlySavings = amountSaved/((Math.pow(1 + investInterest,workYrs)-1)*(1/investInterest));
		System.out.println("You must save: $" + amountSaved);
		System.out.println("You must save: $" + monthlySavings + " each month.");
	}
}
