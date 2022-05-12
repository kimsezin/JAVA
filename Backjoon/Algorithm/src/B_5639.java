import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_5639 {
	static class node {
		int value;
		node left, right;

		public node(int value)
		{
			this.value = value;
		}

		void insert(int value)
		{
			if(value < this.value)
			{
				if (this.left == null) 
					this.left = new node(value);
				else 
					this.left.insert(value);
				
			}
			else {
				if(this.right == null)
					this.right = new node(value);
				else
					this.right.insert(value);
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		node order = new node(Integer.parseInt(br.readLine()));
		while(true)
		{
			String temp = br.readLine();
			if(temp == null || temp.length()<=0)
				break;
			
			order.insert(Integer.parseInt(temp));
		}
		post(order);
	}
	private static void post(node order) {
		if(order.left != null)
			post(order.left);
		if(order.right!=null)
			post(order.right);
		System.out.println(order.value);
		
	}

}
