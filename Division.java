import java.util.Scanner;
import java.io.*;

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
		
		System.out.print("q(x) = ");
		for(int i = order(q); i >= 0 ; i--)
		{
			if(q[i] != 0)
			{
				if(i > 0)
				{
					System.out.print("(" + q[i] + ")" + "x^" + i + " ");
				}
				else
				{
					System.out.print("(" + q[i] + ")");
				}	
			}
			
			if(i > 0 && q[i-1] != 0)
			{
				System.out.print("+ ");
			}
			
		}
		System.out.println("");
		
		System.out.println("Order of p: "+order(p));
		System.out.println("Order of q: "+ order(q));
		
		longDiv(p,q);
		
	}
	
	public static int order(double[] polynomial)
	{
		for(int i = polynomial.length - 1; i >= 0 ; i--)
		{
			if(polynomial[i] != 0)
			{
				return i;
			}
		}
		return 0;
	}
	
	public static void longDiv(double[] p, double[] q)
	{
		int op = order(p);
		int oq = order(q);
		
		//int nop = op; //new op
		//int noq = oq; //new oq
		
		int n = p.length;
		
		if(op == 0 || oq == 0 || n == 0)
		{
			return;
		}
		
		double[] dividend = new double[n];
		double[] divisor = new double[n];
		
		dividend = op >= oq ? p : q;
		divisor = op >= oq ? q : p;
		
		int oa = order(dividend);
		int ob = order(divisor);
		
		//for(int i = 0; i < n; i++)
		//{
		//	System.out.println(dividend[i] + " " +divisor[i]);
		//}
		do
		{
			if(divisor[ob] == 0)
			{
				return;
			}
			
			double k = dividend[oa]/divisor[ob];
			
			
					
			System.out.println("(" + k + ")" + "x^" + (oa-ob) + ", ");
			
			for(int i = oa; i >= 0 ; i--)
			{
				if(i-(oa-ob) >= 0)
				{	
					dividend[i] -= k*divisor[i-(oa-ob)];
				}		
			}
			
			
			oa = order(dividend);
			ob = order(divisor);
			
			double[] buffer = new double[n];
			
			if(ob > oa)
			{
				buffer = divisor;
				divisor = dividend;
				dividend = buffer;
				oa = order(dividend);
				ob = order(divisor);
				System.out.println("(Order flipped)");
			}
			//for(int i = 0; i < n; i++)
			//{
			//	System.out.println(dividend[i] + " " +divisor[i]);
			//}
		}
		while(!(oa == 0 || ob == 0));
		
		System.out.println("Remainder: " + divisor[0]); 
	}
	
	
}	
