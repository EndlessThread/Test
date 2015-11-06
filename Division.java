import java.util.Scanner;
//import java.io.*;

public class Division 
{
	private static Scanner in;

	public static void main(String[] args) 
	{
		in = new Scanner(System.in);
		
		System.out.println("Coefficients of polynomial p (Eg: p = 1.2,1,1,4.9)");
		System.out.print("p = ");
		String polyp = in.nextLine();
		
		System.out.println("Coefficients of polynomial q (Eg: q = 1.2,1,1,4.9)");
		System.out.print("q = ");
		String polyq = in.nextLine();
		
		String[] ppol = polyp.split(",");
		int sizep = ppol.length;
		
		String[] qpol = polyq.split(",");
		int sizeq = qpol.length;
		
		int arrSize = (sizep >= sizeq ? sizep : sizeq);
		
		double[] p = new double[arrSize];
		double[] q = new double[arrSize];
		
		for(int j = 0; j < arrSize; j++)
		{
			if(j >= sizep)
			{
				p[j] = 0;
			}
			else
			{
				p[j] = Double.parseDouble(ppol[sizep-j-1]);
			}
			if(j >= sizeq)
			{
				q[j] = 0;
			}
			else
			{
				q[j] = Double.parseDouble(qpol[sizeq-j-1]);
			}
			
		}
		
		System.out.println("Input interpretation: ");
		System.out.print("p(x) = ");
		for(int i = order(p); i >= 0 ; i--)
		{
			if(p[i] != 0)
			{			
				if(i > 0)
				{
					System.out.print("(" + p[i] + ")" + "x^" + i + " ");				
				}
				else
				{
					System.out.print("(" + p[i] + ")");
				}
			}
			if(i > 0 && p[i-1] != 0)
			{
				System.out.print("+ ");
			}
			
		}
		System.out.println("");
