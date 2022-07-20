
public class InterviewMINandMAXNumber {

	public static void main(String[] args) {

//		2 4 5
//		3 0 7
//		1 2 9   Find minimum number in the row and in the same column find the maximum number
		
		int[][] abc= {{2,4,10},{3,5,7},{1,2,0}};
		int min=abc[0][0];
		int mincoloumn = 0;


		for(int i=0;i<3;i++)
			{
			for(int j=0;j<3;j++)
				{
				if(abc[i][j]<min)//2<2 , 4<2, 5<2, 1<2
					{
						min=abc[i][j];  //assiign the min found. thatis first time 1
						mincoloumn=j;
					}
				}
			}
		 
		System.out.println(min);
		
		//=1
		int max=abc[0][mincoloumn];
		int k = 0;
		while(k<3)
			{
				if(abc[k][mincoloumn]>max)
					{
						max=abc[k][mincoloumn];
					}
				k++;
			}

		System.out.println(max);
	}	
		

}
