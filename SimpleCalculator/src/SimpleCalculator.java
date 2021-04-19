import java.util.Scanner;

public class SimpleCalculator {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a[] = new int[2];
		String temp = input.nextLine();
		String operator = temp.replaceAll("[0-9]","");
		args = temp.split("\\"+operator);
		a[0] = Integer.parseInt(args[0]);
		a[1] = Integer.parseInt(args[1]);
		int answer=0;

		Calculation c = new Calculation();
		try {
			if (operator.equals("+"))
				answer = c.Addition(a[0], a[1]);
			else if (operator.equals("-"))
				answer = c.Subtraction(a[0], a[1]);
			System.out.println(answer);
		} catch(AddZeroException e) {
			System.out.println(e);
		} catch(SubtractZeroException e) {
			System.out.println(e);
		} catch(OutOfRangeException e) {
			System.out.println(e);
		}
	}
}

class OutOfRangeException extends Exception{ }
class AddZeroException extends Exception{ }
class SubtractZeroException extends Exception{ }
class Calculation{
	public Calculation(){ }
	
	public int Addition(int a, int b) throws OutOfRangeException,AddZeroException{
		int sum = a+b;
		if(a == 0 || b == 0)
			throw new AddZeroException();
		if(a>1000 || a<0 || b>1000 || b<0 || sum>1000 || sum<0)
			throw new OutOfRangeException();
		return sum;
	}
	public int Subtraction(int a, int b) throws OutOfRangeException,SubtractZeroException{
		int difference = a-b;
		if(a == 0 || b == 0)
			throw new SubtractZeroException();
		if (a>1000 || a<0 || b>1000 || b<0 || difference>1000 || difference<0)
			throw new OutOfRangeException();
		return difference;
	}

}