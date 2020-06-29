---megamart---
import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
	    int percentage = 0;
	    double releasevalue = 0;
	    Scanner i = new Scanner(System.in);
	    System.out.println("Enter the Customer Id");
	    int id1=i.nextInt();
	    if(id1<=0)
	    {
	    	System.out.println(id1+" is not a valid Customer Id");
	    }
	   if(id1>=1) {
	    System.out.println("Enter the Bill amount");
	    double bil=i.nextDouble();
	   		if(bil<=0) {
	   			releasevalue = bil;
	   			int value = (int)releasevalue;
		        System.out.println(value+" is not a valid Bill Amount");
	   					}
	   		else if(bil>0 && bil<1000) 
	   				{
	   			releasevalue = bil;
		        System.out.printf("Total Price is %.2f\n",releasevalue); 
	   					}
    else if(bil>=1000 && id1>=1 && id1<=100)
	   	  {
	        percentage = 15;
	        releasevalue = (bil*(100-percentage)/100);
	        System.out.printf("Total Price is %.2f\n",releasevalue); 
	    	    }
	    else if(id1>= 101 && id1<=250 )
	    {
	        percentage = 18;
	        releasevalue = (bil*(100-percentage)/100);
	        System.out.printf("Total Price is %.2f\n",releasevalue); 
	    }
	    else if(id1>=251 && id1<=500)
	    {
	        percentage = 23;
	        releasevalue = (bil*(100-percentage)/100);
	        System.out.printf("Total Price is %.2f\n",releasevalue); 
	    }
	    else if(id1>=501 && id1<=1000)
	    {
	        percentage = 28;
	        releasevalue = (bil*(100-percentage)/100);
	        System.out.printf("Total Price is %.2f\n",releasevalue); 
	    }
	    else if(id1>=1001)
	    {
	        percentage = 32;
	        releasevalue = (bil*(100-percentage)/100);
	        System.out.printf("Total Price is %.2f\n",releasevalue); 
	    }
	   	}
	   }
	    }

----wheretopark----
import java.util.*;
public class Main
{
		public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int check=0; int carcount = 0;		
		int a[]=new int[4];		
		System.out.println("B1");
	     a[0]=sc.nextInt();
	     if(a[0]<0){
	    	 check=1;
	    	 System.out.println(""+a[0]+" is not a valid input");
	     }
		if(check==0){
			System.out.println("B2");
		    a[1]=sc.nextInt();
		    if(a[1]<0){
		    	 check=1;
		    	 System.out.println(""+a[1]+" is not a valid input");
		     }
		}
		if(check==0){
	    System.out.println("B3");
	    a[2]=sc.nextInt();
	    if(a[2]<0){
			check=1;
	    	System.out.println(""+a[2]+" is not a valid input");
	    }
	    }
	    if(check==0){
		System.out.println("B4");
	    a[3]=sc.nextInt();
	    if(a[3]<0){
			check=1;
	    	System.out.println(""+a[3]+" is not a valid input");
	    }
	    }
		if(check==0){
	    System.out.println("Car count");
	    carcount=sc.nextInt();
	    if(carcount<0){
	   	check=1;
	   	System.out.println(""+carcount+" is not a valid input");
	    }
	    }
	   	if(check==0){
	    int addval=0;int tot= 0;int count=0;
	    for( int i=0;i<a.length;i++){
	    tot= addval+a[i];
	    if(tot>=carcount){
	    int bnum=i+1;
		System.out.println("The car can be parked at B"+bnum+"");
		count=1;
	    break;
	    }
		addval=tot;
	    }
	    if(count==0){
	    if(carcount>tot){
	    System.out.println("Parking slots in full");
	    }
	    }
		}
		}
}

----Fuel----
import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int count=0;
		double liters; 
		double distance = 0;
		System.out.println("Enter the no of liters to fill the tank");
		liters=sc.nextDouble();
		if(liters<=0){
			count=1;
			int value = (int)liters; 
			System.out.println(value+" is an Invalid Input");
			System.exit(0);
		}
		if(count==0){
			 System.out.println("Enter the distance covered");
			     distance=sc.nextDouble();
			    if(distance<=0){
					count=1;
					int value1 = (int)distance; 
					System.out.println(value1+" is an Invalid Input");
					System.exit(0);
				}   
		}
		if(count>=0){
	       	double distanceinmiles=0f,fuelconsumption=0f,fuelingallons=0f,milespergalon=0f;
	       	if(liters!=0 && distance!=0){
	    		if(liters==0) {
		    		fuelconsumption=0f;
		    		  fuelingallons=0f;
		    	}else {
		    		 fuelconsumption=(liters/distance)*100;
		    		 fuelingallons=(double) (liters*0.2642);
		    	}
		   	if(distance==0) {
		    		  distanceinmiles=0f;
		    	}else {
		    		  distanceinmiles=(double) (distance*0.6214);
		    	}
		   	if(distanceinmiles==0 || fuelingallons==0) {
		    		  milespergalon=0f;
		    	}else {
		    		milespergalon=(distanceinmiles/fuelingallons);
		    	}
	    	}
	  	    System.out.println("Liters/100KM");
	  	    System.out.println(String.format("%.2f",fuelconsumption));
	  	    System.out.println("Miles/gallons");
	  	    System.out.println(String.format("%.2f", milespergalon));
	    }
	}
}

----traingle----
import java.util.*;
public class Main
{
   public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter three sides of triangle");
		int a = s.nextInt();
		if(a<=0 ) 
		{
			System.out.println(""+a+" is an Invalid Length");
		}
	    int b = s.nextInt();
		if(b<=0 ) 
		{
			System.out.println(""+b+" is an Invalid Length");
		}
		int c = s.nextInt();
		if(c<=0) 
		{
			System.out.println(""+c+" is an Invalid Length");
		}
		else if (a>0 && a==b && b>0 && b==c && c>0) 
		{
		    System.out.println(""+a+","+b+","+c+" are the sides of Equilateral Triangle");
		}
		else if((a>0 && a==b) || (a>0 && a==c) || (b>0 && b==c)) //check whether two sides are equal  
		{	    
			System.out.println(""+a+","+b+","+c+" are the sides of Isosceles Triangle");
		}
		else if (a>0 && a!=b && a>0 &&a!=c && b>0 && b!=c) 
		{ 
		    System.out.println(""+a+","+b+","+c+" are the sides of Scalene Triangle");
		}
	}	   
}

----dinner----
import java.util.Scanner;
public class Main {
	static int i=2;  
	long lcmCal(long n1,long n2,long temp,long res) 
		{
				  if(res%n2!=0 || res%n1!=0)
					{
					res=temp*i;
					i=i+1;
					return lcmCal(n1,n2,temp,res);
					}
				  return res;
	 	 }
	public static void main(String arg[]) 
		{
				    long a,b,r,t,lc;
			        Scanner sc=new Scanner(System.in);
				    System.out.println("Enter the day interval of Sam:");
			        a=sc.nextLong();
				    System.out.println("Enter the day interval of Riya:");
			        b=sc.nextLong();
				    if(a<=0 || b<=0)
				    {
				    System.out.println(""+a+" to "+b+" is not a valid interval");
				    System.exit(0);
				    }
			    Main l=new Main();
				    if(a>b) 
					r=a;
				    else
					r=b;
				    t=r;
				    lc=l.lcmCal(a,b,t,r);
				    System.out.println("Sam and Riya will have their dinner on day " +lc);
				}
			}


----Postpaid----
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count=0;int exceed=0;int noofsms = 0;int noofcalls;
		System.out.println("Enter the number of calls:");
		 noofcalls = sc.nextInt();
		if(noofcalls<0){
			count=1;
			System.out.println(""+noofcalls+" is an Invalid Input");
		}
		if(noofcalls>1000){
			exceed=1;
			System.out.println(""+noofcalls+" exceeds the maximum limit");
		}
		if(count==0 && exceed==0){
		System.out.println("Enter the number of SMS:");
		 noofsms = sc.nextInt();
		if(noofsms<0){
				count=1;
				System.out.println(""+noofsms+" is an Invalid Input");
			}
		if(noofsms>1000){
			exceed=1;
			System.out.println(""+noofsms+" exceeds the maximum limit");
		}
		}
		if(count==0 && exceed==0){
		int extracalls=0, extrasms=0 ;
		if(noofcalls<100) {
			 extracalls = 0;
		}
		else {
			 extracalls = (noofcalls - 100);
			
		}
		if(noofsms<100) {
			 extrasms =0;
		}
		else {
			 extrasms = (noofsms - 100);
		}
		float totcallamount =  (float) (extracalls * 1.5);
		float totsmsamount =  (float) (extrasms * 0.5);
		float finalplanbill = (float) (totcallamount + totsmsamount + 150
				+ (0.055 * (totcallamount + totsmsamount + 150)));
		System.out.println("Amount to be paid is Rs."+String.format("%.2f", finalplanbill)+"");
	}
	}
	}
  
  ----Countdigit---
  import java.util.Scanner;
  public class Main {
	static int count = 0;
	static int length = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		long n = num;
		if (num > 0) 
		{
			if(String.valueOf(num).length()<=9)
			{
			    int d = sc.nextInt();
			    if (d <= 9) 
			    {
				    if(String.valueOf(num).contains(String.valueOf(d)))
				    {
			    	    while (num > 0) 
				        {
					        if (num % 10 == d) 
					        {
						        count++;
					        }
					        num = num / 10;
					        length++;
				        }
				        System.out.println("Count of " + d + " in " + n + " is " + count);
			        } 
			        else
			        {
				        System.out.println(d+" is not available in "+num);
			        }
		        }	
		        else 
		        {
			        System.out.println(d + " is not valid");
		        }
	        }
			else
			{
				System.out.println(n + " exceeds the limit");
			}
		} 
		else 
		{
			System.out.println(n + " falls behind the limit");
		}
	}
}

----Holiday----

import java.util.Scanner;
public class Main {
  static int price = 0;
	public static void main(String[] args) 
	{
    Scanner sc = new Scanner(System.in);
		System.out.println("Enter the flight name");
		String fname = sc.nextLine();
		System.out.println("Enter the class");
		String cls = sc.nextLine();
		System.out.println("Enter the number of seats");
		int seats = sc.nextInt();
		System.out.println("Card Payment");
		String cp = sc.next();
		if (fname.equalsIgnoreCase("Air India")) 
		{
			if (cls.equalsIgnoreCase("Travel class")) 
			{
				price = 3200;
			}
			if (cls.equalsIgnoreCase("Economy class")) 
			{
				price = 6950;
			}
			if (cls.equalsIgnoreCase("Business class")) 
			{
				price = 10340;
			}
			if (cp.equalsIgnoreCase("y")) 
			{
				double p = 10.5;
				double c = ((price * seats) - (price * seats * (p / 100)));
				int value = (int) c;
				System.out.println(value);
			}
			else 
			{
				int value = price*seats;
				System.out.println(value);
			}
		} 
		else if (fname.equalsIgnoreCase("Spice Jet")) 
		{
			if (cls.equalsIgnoreCase("Travel class")) 
			{
				price = 3450;
			}
			if (cls.equalsIgnoreCase("Economy class")) 
			{
				price = 7945;
			}
			if (cls.equalsIgnoreCase("Business class")) 
			{
				price = 9500;
			}
			if(seats>5)
			{
				price = price-((price*10)/100);
			}
			if(seats>10)
			{
				price = price-((price*15)/100);
			}
			if (cp.equalsIgnoreCase("y")) 
			{
				double p = 7.5;
				double c = ((price * seats) - (price * seats * (p / 100)));
				int value = (int) c;
				System.out.println(value);
			} 
			else 
			{
				int value = price*seats;
				System.out.println(value);
			}
		} 
		else if (fname.equalsIgnoreCase("Go Air")) 
		{
			if (cls.equalsIgnoreCase("Travel class")) 
			{
				price = 3300;
			}
			if (cls.equalsIgnoreCase("Economy class")) 
			{
				price = 7250;
			}
			if (cls.equalsIgnoreCase("Business class")) 
			{
				price = 9890;
			}
			if (cp.equalsIgnoreCase("y")) 
			{
				double p = 9.5;
				double c = ((price * seats) - (price * seats * (p / 100)));
				int value = (int) c;
				System.out.println(value);
			} 
			else 
			{
				int value = price*seats;
				System.out.println(value);
			}
		} 
		else if (fname.equalsIgnoreCase("IndiGo")) 
		{
			if (cls.equalsIgnoreCase("Travel class")) 
			{
				price = 3490;
			}
			if (cls.equalsIgnoreCase("Economy class")) 
			{
				price = 7560;
			}
			if (cls.equalsIgnoreCase("Business class")) 
			{
				price = 9990;
			}
			if(seats>5)
			{
				price = price-((price*10)/100);
			}
			if(seats>10)
			{
				price = price-((price*15)/100);
			}
			if (cp.equalsIgnoreCase("y")) 
			{
				double p = 8.5;
				double value = ((price * seats) - (price * seats * (p / 100)));
				System.out.println(value);
			} 
			else 
			{
				int value = price*seats;
				System.out.println(value);
			}
		}
	}
}
