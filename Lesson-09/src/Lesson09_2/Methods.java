package Lesson09_2;

public class Methods {

	static double a;
	static double b;

	public Methods(double a1, double b1) {
		super();
		this.a = a1;
		this.b = b1;
	}

	public double plus() throws MyException {
		
		return a + b;
	}

	public double minus() throws MyException {
		return a - b;
	}

	public double multiply() throws MyException {
		return a * b;
	}

	public double devide() throws MyException {
		return a / b;
	}
	static void Result(double result) {
		System.out.println("Результат операції дорівнює " + result);
	}

	public static void exp() throws MyException {
		if ((a < 0) && (b < 0)) {
			throw new IllegalArgumentException();
		}
		if (((a == 0) && (b != 0)) || ((a != 0) && (b == 0))) {
			throw new ArithmeticException();
		}
		if ((a == 0) && (b == 0)) {
			throw new IllegalArgumentException();
		}
		if ((a > 0) && (b > 0)) {
			throw new MyException("Щось пішло не так або щось не працює");
		}

	}

}
