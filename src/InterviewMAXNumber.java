
public class InterviewMAXNumber {
	public static void main(String[] args) {

//		2 4 5
//		3 4 7
//		1 2 9   pick the Maximum number

		int[][] abc = { { 10, 4, 5 }, { 100, 0, 7 }, { 1, 2, 9 } };
		int max = abc[0][0];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (abc[i][j] > max) {
					max = abc[i][j];

				}
			}
		}

		System.out.println(max);

	}

}
