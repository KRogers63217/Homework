import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery {

	public Scanner input = new Scanner(System.in);
	public Random rand = new Random();
	public int randomNums[] = new int[7];
	public int chosenNums[] = new int[6];

	public Lottery() {
		for (int i = 0; i < randomNums.length; i++) {
			while (randomNums[i] == 0) {
				int random = rand.nextInt(49) + 1;
				if (random >= 1 && random <= 49 && random != randomNums[0] && random != randomNums[1] && random != randomNums[2] && random != randomNums[3] && random != randomNums[4] && random != randomNums[5] && random != randomNums[6]) {
					randomNums[i] = random;
				}
			}
		}
		
		for (int i = 0; i < chosenNums.length; i++) {
			while (chosenNums[i] < 1 || chosenNums[i] > 49) {
				System.out.println("Enter number " + (i + 1) + ":");
				int inputNum = input.nextInt();
				if (inputNum >= 1 && inputNum <= 49 && inputNum != chosenNums[0] && inputNum != chosenNums[1] && inputNum != chosenNums[2] && inputNum != chosenNums[3] && inputNum != chosenNums[4] && inputNum != chosenNums[5]) {
					chosenNums[i] = inputNum;
				} else {
					System.out.println("Number invalid. Enter another one:");
				}
			}
		}
		getResult();
	}

	public void getResult() {
		System.out.println("Winning numbers = " + Arrays.toString(randomNums));
		System.out.println("Your numbers = " + Arrays.toString(chosenNums));
		
		int matches = 0;
		boolean bonus = false;
		
		for (int i = 0; i < randomNums.length - 1; i++) {
			for (int ii = 0; ii < chosenNums.length; ii++) {
				if (randomNums[i] == chosenNums[ii]) matches += 1;
				if (chosenNums[i] == randomNums[6]) bonus = true;
			}
		}

		if (matches == 3) {
			System.out.println("Won £10!");
		} else if (matches == 4) {
			System.out.println("Won £100!");
		} else if (matches == 5) {
			System.out.println("Won £10,000!");
		} else if (matches == 5 && bonus) {
			System.out.println("Won £100,000!");
		} else if (matches == 5 && bonus) {
			System.out.println("Won £1,000,000!");
		} else {
			System.out.println("Didn't win");
		}
	}

	public static void main(String[] args) {
		Lottery lottery = new Lottery();
	}

}