package pkgMain;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double investValue = -1;
		double paybackValue = -1;
		
		System.out.print("Enter the amount of years you plan to work: ");
		int workYrs = input.nextInt();
		
		while (investValue < 0 || investValue > .2) {
			System.out.print("Enter your investment interest rate between 0 and 20 (in %): ");
			investValue = input.nextDouble()/100;
		}
		
		System.out.print("Enter the amount of years you plan to be retired for: ");
		int retiredYrs = input.nextInt();
		
		while (paybackValue < 0 || paybackValue > .03) {
			System.out.print("Enter your payback interest rate between 0 and 3 (in %): ");
			paybackValue = input.nextDouble()/100;
		}
		
		System.out.print("Enter how much money you need each month during retirement: ");
		double income = input.nextDouble();
		
		System.out.print("Enter your monthly SSI: ");
		double monthlySSI = input.nextDouble();
		
		double anualWithdraw = 12*(income-monthlySSI);      
		double amountWithdrawn = retiredYrs*anualWithdraw;
		
		double amountSaved = ((Math.pow(1 + paybackValue,retiredYrs) - 1)*(anualWithdraw/paybackValue))/Math.pow(1 + paybackValue, retiredYrs);
		double monthlySavings = amountSaved/((Math.pow(1 + investValue,workYrs)-1)*(1/investValue));
		System.out.println("You must save: $" + amountSaved + " before you retire.");
		System.out.println("You must save: $" + monthlySavings + " each month in order to retire after " + workYrs + " years.");
	}
}
