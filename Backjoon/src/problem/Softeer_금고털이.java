package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Softeer_금고털이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int maxWeight = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> bag = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			list.add(price);
			bag.put(price, weight);
		}
		
		Collections.sort(list);
		int result=0;
		for(int i=list.size()-1;i>=0;i--)
		{
			int price = list.get(i);
			int weight = bag.get(price);
			
			if(maxWeight > weight)
			{
				result+= price*weight;
				maxWeight-=weight;
			}
			else
			{
				result+=price*maxWeight;
				maxWeight=0;
			}
		}
		System.out.println(result);
	}

}
