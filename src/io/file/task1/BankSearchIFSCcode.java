package io.file.task1;
import java.io.*;
import java.util.Scanner;
public class BankSearchIFSCcode 
{
	public static void main(String args[])throws IOException
	{
		int n,i;
		String a;
		String s="\t";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the IFSC code");
		a=sc.next();
		File file=new File("C:\\Users\\Tathagata\\Downloads\\Bank.Txt");
		FileReader freader=new FileReader(file);
		n=freader.read();
		Scanner fcheck=new Scanner(file);
		System.out.println("The details are:");
		while(fcheck.hasNextLine())
		{
			String ss[]=fcheck.nextLine().split("\t");
			for(i=0;i<ss.length;i++)
			{
				if(a.equals(ss[i]))
				{
					for(i=0;i<ss.length;i++)				
					{
						System.out.print(ss[i]);
					}
				}
			}
		}
		
		
	}
}

