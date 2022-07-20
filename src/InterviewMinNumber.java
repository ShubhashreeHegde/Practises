

public class InterviewMinNumber {

	public static void main(String[] args) {

//		2 4 5
//		3 4 7
//		1 2 9   pick the Minimun number
		
		int[][] abc= {{2,4,5},{3,0,7},{1,2,9}};
		int min=abc[0][0];
		int mincoloumn = 0;


		for(int i=0;i<3;i++)
			{
			for(int j=0;j<3;j++)
				{
				if(abc[i][j]<min)//2<2 , 4<2, 5<2, 1<2
					{
						min=abc[i][j];  //assiign the min found. thatis first time 1
						
					}
				}
			}
		 
		System.out.println(min);

	}	
		

	}
	


