package Lesson09_2;

public class Aplications {

	public static void main(String[] args) throws MyException {

		Methods m = new Methods(5, 0);

		Methods.Result(m.plus());
		Methods.Result(m.minus());
		Methods.Result(m.multiply());
		Methods.Result(m.devide());

	}

}
