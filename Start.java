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
				// System.out.println("Enter times that you want to play with computer: ");
				// String n= num.nextLine();
				// int m=Integer.parseInt(n);
				System.out.println("Do you want to play first ? \n Yes or No");
				String player= num.nextLine();
				boolean first;
				if(player.equals("Yes")==true || player.equals("yes")==true)
				{
					// Humantocp game = new Humantocp();
					// for(int i=1; i<=m; i++)
					// {
					// 	game.run();

					// }
					// game.champ(m);
					new Humantocp();
					
				}
				else
				{
					new humantopc_first();
				}
				break;
			}
		}
	}
}