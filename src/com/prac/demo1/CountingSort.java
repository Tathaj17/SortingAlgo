package com.prac.demo1;

public class CountingSort {

	public static void main(String[] args) 
	{
		int arr[]= {3,2,3,4,5,6,6,6,1};
		int sum = 1;
		int maxLength=arr[0];
		for(int k=0;k<arr.length-1;k++)
		{
			if(maxLength<arr[k+1])
			{
				maxLength=arr[k+1];
			}
		}
		int result[] = new int[maxLength+1];
		for(int i=0;i<arr.length;i++)
		{
			int j= arr[i];
			if(result[j]>=1)
			{
				sum=result[j]+1;
				result[j]=sum;
			}
			else
			{
				result[j]=1;
			}
			sum=0;
		}
		for(int i=0;i<maxLength+1;i++)
		{
			int n=result[i];
			for(int f=0;f<n;f++)
			{
				System.out.println(i);
			}
			//System.out.println(result[i]);
		}
	}
}
