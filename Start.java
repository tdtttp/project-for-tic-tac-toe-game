import java.util.*;
public class Start
{
	public static void main(String arr[])
	{
		System.out.println("Choose play way \n Enter 1 to choose human to human \n Enter 2 to choose human to computer");
		Scanner num= new Scanner(System.in);
		String way1= num.nextLine();
		int way2= Integer.parseInt(way1);
		switch(way2)
		{
			case 1:
			{
				new humantohuman();
				break;
			}
			case 2:
			{
				System.out.println("Do you want to play first ? \n Yes or No");
				String player= num.nextLine();
				boolean first;
				if(player.equals("Yes")==true)
				{
					first=true;
				}
				else
				{
					first=false;
				}
				
				new humantocp(first);
				break;
			}
		}
	}
}