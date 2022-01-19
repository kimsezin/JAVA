package com;
import java.util.*;
public class B_3052 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int modular[] = new int[42];
		Arrays.fill(modular, 0);
		for(int i=0;i<10;i++)
		{
			int temp=sc.nextInt();
			modular[temp%42]++;
		}
		
		int cnt=0;
		for(int i=0;i<42;i++)
		{
			if(modular[i]!=0)
			{
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
