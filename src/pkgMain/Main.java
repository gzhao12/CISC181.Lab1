package pkgMain;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//creates a variable of type Scanner for user input
		Scanner input = new Scanner(System.in);
		//defines variables for user input
		int workYrs;
		int retiredYrs;
		double income;
		double monthlySSI;
		double investValue = -1;
		double paybackValue = -1;
		
		//asking user to input values for variables
		System.out.print("Enter the amount of years you plan to work: ");
		workYrs = input.nextInt();
		
		//repeats until the user inputs a valid number
		while (investValue < 0 || investValue > .2) {
			System.out.print("Enter your investment interest rate between 0 and 20 (in %): ");
			investValue = input.nextDouble()/100;
		}
		
		System.out.print("Enter the amount of years you plan to be retired for: ");
		retiredYrs = input.nextInt();
		
		while (paybackValue < 0 || paybackValue > .03) {
			System.out.print("Enter your payback interest rate between 0 and 3 (in %): ");
			paybackValue = input.nextDouble()/100;
		}
		
		System.out.print("Enter how much money you need each month during retirement: ");
		income = input.nextDouble();
		
		System.out.print("Enter your monthly SSI: ");
		monthlySSI = input.nextDouble();
		
		input.close();
		
		//calculates the amount of money needed saved in total and monthly
		double amountSaved = (income-monthlySSI)*((1-(1/(Math.pow(1+(paybackValue)/12, 12*retiredYrs)))))/(paybackValue/12);
		double monthlySavings = amountSaved*(((investValue/12)/((Math.pow(1+(investValue/12),12*workYrs))-1)));

		//rounds the calculated values to the nearest hundredth
		amountSaved = Math.round(amountSaved*100)/100.0;
		monthlySavings = Math.round(monthlySavings*100)/100.0;
		
		//prints out the rounded calculated values
		System.out.println("You must save: $" + amountSaved + " before you retire.");
		System.out.println("You must save: $" + monthlySavings + " each month in order to retire after " + workYrs + " years.");
	}
}
