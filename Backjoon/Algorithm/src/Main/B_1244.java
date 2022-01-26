package Main;

import java.util.Scanner;

public class B_1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int switchState[] = new int[N];
		
		for(int i=0;i<N;i++)
		{
			switchState[i]=sc.nextInt();
		}
		
		int tc = sc.nextInt();
		for(int i=0;i<tc;i++)
		{
			int gender = sc.nextInt();
			if(gender == 1)
			{
				//남자 
				int Natural = sc.nextInt();
				for(int j=Natural-1;j<N;j+=Natural)
				{
					if(switchState[j]==0)
						switchState[j]=1;
					else
						switchState[j]=0;
						
				}
			}
			else
			{
				int Natural =sc.nextInt()-1;
				if(switchState[Natural]==0)
					switchState[Natural]=1;
				else
					switchState[Natural]=0;
				for(int j=1;j<=N-Natural;j++)
				{
					if(Natural-j>=0 && Natural+j<N)
					{
						if(switchState[Natural-j]==switchState[Natural+j])
						{
							if(switchState[Natural+j]==0)
								switchState[Natural+j]=1;
							else
								switchState[Natural+j]=0;
							
							if(switchState[Natural-j]==0)
								switchState[Natural-j]=1;
							else
								switchState[Natural-j]=0;
						}
						else
							break;	
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(switchState[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}

	}

}
