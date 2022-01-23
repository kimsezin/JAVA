package Main;
import java.util.Scanner;
public class B_10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
	    int num=sc.nextInt();
	    int max=-1000001;
	    int min = 1000001;
	
	    for(int i=0;i<num;i++)
	    {
	        int temp=sc.nextInt();
	        if(temp > max)
	            max=temp;
	        if(temp < min)
	            min=temp;
	    }
	
	    
	    System.out.println(min+" "+max);
		sc.close();
}
	
}

