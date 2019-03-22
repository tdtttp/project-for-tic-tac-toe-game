import java.util.Scanner;
public class humantocp
{
	private String human;
	private String cp;
	private int check[]= new int[50];
	private String table[][]= new String[3][3];
	private String markO="O";
	private String markX="X";
	public humantocp(Boolean first)
	{
		createTable();
		ShowTable();
		Human();
	}
	public void createTable()
	{
		int index=1;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3;j++)
			{
				table[i][j]=Integer.toString(index);
				index++;
			}
		}
	}
	public void ShowTable()
	{
		for(int i=0; i<3; i++)
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
		System.out.println("Enter Human's name: ");
		human= name.nextLine();
		cp="God of Tic Tac Toe";
	}
	private void Stick(int index, String turn)
	{
		String mark;
		if(turn==human)
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
	public void Play()
	{
		Scanner num= new Scanner(System.in);
		int index1=0;
		int index2=0;
		
		for(int i=0; i<9; i++)
		{
			System.out.printf("Turn of %s, please enter index that you want to mark on table\n", human);
			index1=num.nextInt();
			int indexone=checkindex(index1);
			Stick(indexone, human);
			check[i]=indexone;
			ShowTable();
			i++;
			System.out.printf("Turn of %s, please enter index that you want to mark on table\n", cp);
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
	private int AI()

}