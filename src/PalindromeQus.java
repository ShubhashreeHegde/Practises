
public class PalindromeQus {

	public static void main(String[] args) {
		
			int num=455;
			int temp=num;
			int rev=0;
			while(num>0)
			{
			int d=num%10;  //finding last digit of that number
			rev=rev*10+d;
			num=num/10;
			}
			if(temp==rev)
			{
			System.out.println(temp +" "+"is palindrome");
			}
			else
			{
				System.out.println(temp +" "+"is not palindrome");
			}
	}

}
