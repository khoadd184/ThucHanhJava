/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.math.BigInteger;
public class Main
{
	public static void main(String[] args) {
		int n =90;
		BigInteger f1 = BigInteger.ONE;
		BigInteger f2 = BigInteger.ONE;
		System.out.println("1: "+f1);
		System.out.println("2: " + f2);
		
	
	for(int i =3;i<=n;i++){
	    BigInteger f3 = f1.add(f2);
	    System.out.println(i+": "+ f3);
	    f1 = f2;
	    f2 = f3;
	}
}
}