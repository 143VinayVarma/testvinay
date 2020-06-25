--requirement---
Shoot it!!!
Sidhu wants to make her students to participate in the air pistol state-level contest. Students are trained with the concentric circle board. She followed the rules such that When a student correctly hits the center of the concentric circles, his score is 100. The score gets reduced depending on the circle hit. When the student hits outside of the board, his score is 0. She will not allow a student out unless they score 100. Write a program to determine the number of turns a student takes to score 100 points in the pistol shooting
Sample Input 1:
45
21
34
Sample Output 1:
The number of turns is 3
Sample Input 2:
99
10
Sample Output 2:
The number of turns is 2
Sample Input 3:
100
Sample Output 3:
The number of turns is 1
---------------

import java.util.*;
public class Main{
  public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
        int a[] = new int[100];
        int count =0;
        int total = 0;
        a[0]=sc.nextInt();
    if (a[0] >= 100){
			System.out.println("The number of turns is 1"); 
		}
		else 
		{
		    for (int i= 0; i<a.length; i++ )
		    {
		        a[i] = sc.nextInt();
		        count = count+1;
		        total = total + a[i];
		    }
		}
		if (total >= 100)
		    {
		        System.out.println("The number of turns is "+count); 
		    }
		    else
		    {
		        System.out.println("The number of turns is "+count); 
	        }
			if (count > 10)
		    {
		        System.out.println("The number of turns is "+count); 
		    }
		    else
		    {
		        System.out.println("The number of turns is "+count); 
	        }
   }
}
