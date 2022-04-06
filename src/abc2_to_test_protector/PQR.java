package abc2_to_test_protector;

import abc_to_test_protector.ABC;

public class PQR extends ABC {
	protected void pqr2() {
		System.out.println("from package 2");
	}
	public static void main(String [] args) {
		PQR a1 = new PQR();
		a1.abc2();
		a1.pqr2();
	}

}
