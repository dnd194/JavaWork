package practice.gugu2;


//***  주석을 생활화~~~~  ***

public class Gugu2 {
	public static void main(String[] args) {

		for (int i = 2; i < 9; i += 3) {

			for (int j = 1; j <= 9; j++) {

				System.out.print(i + " x " + j + " = " + (i * j));

				System.out.print(" \t");

				System.out.print((i + 1) + " x " + j + " = " + ((i + 1) * j));

				System.out.print(" \t");

				if ((i + 2) != 10) {
					System.out.print((i + 2) + " x " + j + " = " + ((i + 2) * j));
				}

				System.out.println();

			}

			System.out.println();

		}
	}
}
