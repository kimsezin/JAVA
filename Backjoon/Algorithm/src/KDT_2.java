import java.util.ArrayList;
import java.util.StringTokenizer;

public class KDT_2 {

	public static void main(String[] args) {
		String[] records = { "john share", "mary comment", "jay share", "check notification", "check notification",
	            "sally comment", "james share", "check notification", "lee share", "laura share", "will share",
	            "check notification", "alice comment", "check notification" };
		String[] result = solution(records);
		for(int i=0;i<result.length;i++)
		{
			System.out.println(result[i]);
		}
		System.out.println();
		String[] records2 = { "john share", "mary share", "jay share", "james comment", "lee share",
				"check notification", "sally comment", "laura comment", "check notification", "will share", "ruby share",
	            "check notification" };
		input=new ArrayList<String>();
		answer = new ArrayList<String>();
		String[] result2 = solution(records2);
		for(int i=0;i<result2.length;i++)
		{
			System.out.println(result2[i]);
		}

	}
	static ArrayList<String> answer = new ArrayList<String>();// 보관함
	static ArrayList<String> input = new ArrayList<String>(); //알림함
	public static String[] solution(String[] records)
	{
		for(int i=0;i<records.length;i++)
		{
			StringTokenizer st = new StringTokenizer(records[i]," ");
			String name = st.nextToken();
			String action = st.nextToken();
			if(name.equals("check"))
			{
				pop();
				input.remove(input.size()-1);
			}
			else
			{
				if(input.size()==0)
				{
					String temp = name + " " + action+ " ";
					if(action.equals("share"))
						temp+="your post";
					else
						temp+="on your post";
					input.add(temp);
				}
				else
				{
					String input_last = input.get(input.size()-1); // 알림창의 마지막 문자열
					StringTokenizer st2 = new StringTokenizer(input_last," "); 
					String name_input = st2.nextToken();
					String action_input = st2.nextToken();
					
					String temp = name +" ";
					if(action_input.equals("and"))
					{
						String check = st2.nextToken(); // 2명일땐 이름, 3명부터는 숫자
						String check2 = st2.nextToken(); // 2명일땐 action(shared, commented) 3명일땐 others
						if(check2.equals("others"))
						{
							int cnt = Integer.parseInt(check)+1;
							temp+=cnt+" ";
							String temp_action = st2.nextToken(); //shared, commented
							if(temp_action.equals("share"))
								temp+="share your post";
							else
								temp+="comment on your post";
							input.remove(input.size()-1);
						}
						else
							{
								temp=name_input + " and 2 others " ;
								if(check2.equals("share"))
									temp+=check2+" your post";
								else
									temp+=check2+" on your post";
								input.remove(input.size()-1);
							}
					}
					else if(action_input.equals(action))
					{
						temp=name_input +" and " + temp;
						if(action.equals("share"))
							temp+=action+" your post";
						else
							temp+=action+" on your post";
						input.remove(input.size()-1);
					}
					else
					{
						if(action.equals("share"))
							temp+=action+" your post";
						else
							temp+=action+" on your post";
					}
						input.add(temp);
				}
			}
	}
	String[] result = new String[answer.size()];
	for(int i=0;i<answer.size();i++)
	{
		result[i] = answer.get(i);
	}
	return result;
}
	
	static void pop()
	{
		String input_last = input.get(input.size()-1);
		StringTokenizer st = new StringTokenizer(input_last);
		
		String result = "";
		while(true)
		{
			String temp = st.nextToken();
			if(temp.equals("post"))
			{
				result+=temp;
				break;
			}
			if(temp.equals("share"))
				result+="shared";
			else if(temp.equals("comment"))
				result+="commented";
			else
				result+=temp;
			result+=" ";
		}
		answer.add(result);
	}

}
