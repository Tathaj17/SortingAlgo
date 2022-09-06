package io.file.task1;

public class Recursion
{
	boolean PalindromeNum(int N)
	{
	int rev=0;
	int num=N;
	while(num>0) 
	{
		int f=num/10;
		int s=f*10;
		int digit=num-s;
		rev=rev+digit;
		num/=f;
	}
	if(rev==N)
		return true;
	else
		return false;
	}

	public static void main(String[] args) 
	{
		int a=121;
		Recursion ob= new Recursion();
		System.out.println(ob.PalindromeNum(a));
	}
}
