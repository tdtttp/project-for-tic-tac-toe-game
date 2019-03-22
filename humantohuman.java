import java.util.*;
public class humantohuman
{
	private String human1;
	private String human2;
	private String table[][]= new String[3][3];
	private String markX="X";
	private String markO="O";
	private int check[]= new int[50];
	public humantohuman()
	{
		CreateTable();
		Showtable();
		Human();
		HumanPlay();
	}
	public void CreateTable()
	{
		int index=1;
		for(int i=0 ; i< 3; i++)
		{
			for(int j=0; j<3; j++)
			{
				String stranindex= Integer.toString(index);
				table[i][j]=stranindex;
				index=index+1;
			}
		}
	}
	public void Showtable()
	{
		for(int i=0; i<3;i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.printf("[%s]", table[i][j]);
			}
			System.out.printf("\n");
		}
	}
	public void Human()
	{
		Scanner name= new Scanner(System.in);
		System.out.println("Enter Human1's name: ");
		human1= name.nextLine();
		System.out.println("Enter Human2's name: ");
		human2= name.nextLine();
		for(;human1.equals(human2)==true;)
		{
			System.out.println("Name of Human2 is exist, please enter again Human2's name:  ");
			human2= name.nextLine();
		}
	}
	private void Play(int index, String turn)
	{
		String mark;
		if(turn==human1)
		{
			mark=markO;
		}
		else
		{
			mark=markX;
		}
		
				switch(index)
			{
				case 1:
				{
					table[0][0]=mark;
					break;
				}
				case 2:
				{
					table[0][1]=mark;
					break;
				}
				case 3:
				{
					table[0][2]=mark;
					break;
				}
				case 4:
				{
					table[1][0]=mark;
					break;
				}
				case 5:
				{
					table[1][1]=mark;
					break;
				}
				case 6:
				{
					table[1][2]=mark;
					break;
				}
				case 7:
				{
					table[2][0]=mark;
					break;
				}
				case 8:
				{
					table[2][1]=mark;
					break;
				}
				case 9:
				{
					table[2][2]=mark;
					break;
				}
			}
		
	}
	public void HumanPlay()
	{
		Scanner num= new Scanner(System.in);
		int index1=0;
		int index2=0;
		int i;
		for(i=0; i<9; i++)
		{
			System.out.printf("Turn of %s, please enter index that you want to mark on table\n", human1);
			index1=num.nextInt();
			int indexone=checkindex(index1);
			Play(indexone, human1);
			check[i]=indexone;
			Showtable();
			if(findWinner()==true)
			{
				System.out.printf("%s is winner", human1);
				break;
			}
			if(i==9-1)
			{
				if(findWinner()==false)
				{
					System.out.println("No one is winner");
					break;
				}
			}
			i++; //su dung no de den nguoi thu hai danh thi no se tang so lan danh len
			System.out.printf("Turn of %s, please enter index that you want to mark on table\n", human2);
			index2=num.nextInt();
			int indextwo=checkindex(index2);
			Play(indextwo, human2);
			check[i]=indextwo;
			Showtable();
			if(findWinner()==true)
			{
				System.out.printf("%s is winner", human2);
				break;
			}
		}
	}
	public boolean exits(int index)
	{
		boolean test=false;
		for(int i=0; i < 9; i++)
		{
			if(index==check[i])
			{
				test=true;
				break;
			}
			
		}
		return test;
	}
	public int checkindex(int index)
	{
		Scanner num= new Scanner(System.in);

			for(;index < 0 && index >10;)
			{
				System.out.println("Index that you entered is more than number of table's index, please enter index again");
				index=num.nextInt();
			}
			for(;exits(index)==true;)
			{
				System.out.println("Index that you entered is exist , please enter index again");
				index=num.nextInt();
			}
			return index;
	}
	public boolean findWinner()
	{
			boolean find= false;
			if(table[0][0].equals(table[1][0])==true && table[2][0].equals(table[0][0])==true)
			{
				find=true;
			}
			else if(table[0][1].equals(table[1][1])==true && table[0][1].equals(table[2][1])==true)
			{
				find=true;
			}
			else if(table[0][2].equals(table[1][2])==true && table[0][2].equals(table[2][2])==true)
			{
				find=true;
			}
			else if(table[0][0].equals(table[0][1])==true && table[0][0].equals(table[0][2])==true)
			{
				find=true;
			}
			else if(table[1][0].equals(table[1][1])==true && table[1][0].equals(table[1][2])==true)
			{
				find=true;
			}
			else if(table[2][0].equals(table[2][1])==true && table[2][0].equals(table[2][2])==true)
			{
				find=true;
			}
			else if(table[0][0].equals(table[1][1])==true && table[0][0].equals(table[2][2])==true)
			{
				find=true;
			}
			else if(table[0][2].equals(table[1][1])==true && table[0][2].equals(table[2][0])==true)
			{
				find=true;
			}
			return find;
	}
}