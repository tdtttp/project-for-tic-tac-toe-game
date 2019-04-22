//ngay mai xem lai y nghia cua viec cat tia alpha beta
import java.util.Scanner;
import java.util.Random;
import java.util.*;
public class Humantocp
{
	private String human;
	private String cp;
	private int check[]= new int[50];
	private String table[][]= new String[3][3];
	private String markO="O";
	private String markX="X";
	private int saveindex1[]= new int[50];
	private int saveindex2[]= new int[50];
	private List<insc> scoresofmove;
	private List<Integer> firstmin;
	private List<Integer> firstmax;
	public Humantocp()
	{
		createTable();
		Human();
		ShowTable();
		Play();
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
	public void ShowTestTable(String arr[][])
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.printf("[%s]", arr[i][j]);
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
	private void StickTest(int index, String turn, String[][] testTable)
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
					testTable[0][0]=mark;
					break;
				}
				case 2:
				{
					testTable[0][1]=mark;
					break;
				}
				case 3:
				{
					testTable[0][2]=mark;
					break;
				}
				case 4:
				{
					testTable[1][0]=mark;
					break;
				}
				case 5:
				{
					testTable[1][1]=mark;
					break;
				}
				case 6:
				{
					testTable[1][2]=mark;
					break;
				}
				case 7:
				{
					testTable[2][0]=mark;
					break;
				}
				case 8:
				{
					testTable[2][1]=mark;
					break;
				}
				case 9:
				{
					testTable[2][2]=mark;
					break;
				}
			}
		
	}
	private int convert(int i, int j) //ham chuyen doi vi tri i, j thanh mot vi tri tuong ung tu 1 den 9 trong bang caro
	{
		if(i==0 && j==0)
		{
			return 1;
		}
		else if ( i==0 && j==1)
		{
			return 2;
		}
		else if ( i==0 && j==2)
		{
			return 3;
		}
		else if ( i==1 && j==0)
		{
			return 4;
		}
		else if ( i==1 && j==1)
		{
			return 5;
		}
		else if ( i==1 && j==2)
		{
			return 6;
		}
		else if ( i==2 && j==0)
		{
			return 7;
		}
		else if ( i==2 && j==1)
		{
			return 8;
		}
		else
		{
			return 9;
		}
	}
	private List<Integer> getSpace()//ham tra ve cac vi tri con trong
	{
		List<Integer> space= new ArrayList<Integer>();
		for(int i=0; i<3;i++)
		{
			for(int j=0; j<3; j++)
			{
				if(table[i][j].equals("O")==false && table[i][j].equals("X")==false )
				{
					
					space.add(convert(i, j)); //neu o tri i, j chua danh o nao thi them vi tri i, j da duoc bien doi vao space
				}
			}
		}
		
		return space; //tra ve cac tri tri chua danh
	}
	private int findmove()
	{
		int max=scoresofmove.get(0).score;;
		int bestmove=0;
		for (int i = 1; i < scoresofmove.size(); ++i) 
		{ 
            if (max < scoresofmove.get(i).score) 
            {
                max = scoresofmove.get(i).score;
                bestmove = i;
            }
        }

        return scoresofmove.get(bestmove).index; 

	}
	public int reMin(List<Integer> coreslist) 
	{
        int min = coreslist.get(0), index=0; //gan = gia tri dau tien trong list diem
        int n=coreslist.size();
        for (int i = 1; i < n; ++i) 
        {
        	int tmp=coreslist.get(i);
            if (tmp < min) 
            {
                min = tmp;
                index = i;
            }
        }
        return coreslist.get(index);
    }

    public int reMax(List<Integer> coreslist)
     {
        int max = coreslist.get(0), index=0;//gan = gia tri cuc tieu
        int n=coreslist.size();
        for (int i = 1; i < n; ++i) 
        {
        	int tmp=coreslist.get(i);
            if (coreslist.get(i) > max) 
            {
                max = tmp;
                index = i;
            }
        }
        return coreslist.get(index);//tra ve gia tri o vi tri index
    }
    public void StartFind(int times, int depth, String turn) //depth so lan thuc hien viec de quy tim max min
    { //ham tim kiem minimax
        scoresofmove = new ArrayList<insc>();
        minimax(times, depth, turn);
    }

    public int minimax(int times, int depth, String turn) 
    {//la x hoac o
    	List<Integer> indexcanuse = getSpace(); //chua cac vi trong
    	List<Integer> scores = new ArrayList<Integer>(); //tao list chua diem
    	int block=0; 
    	 if (findtestcpwin())
        {
        	return 9999; //tra ve gia tri vo cung neu X win
        }
        else if (findtesmanwin())
        { 
        	return -9999; //tra ve gia tri am vo cung neu O win
        }
        
        for (int i = 0; i < indexcanuse.size(); ++i) 
        {
							//kiem tra so luong vi tri con trong
            int index = indexcanuse.get(i);
            if (turn.equals("X")==true) 
            {
                Stick(index, cp); //danh thu cho may
                
               
                times=times+1;
                int currentScore = minimax(times, 1, "O"); //chay de quy danh thu cho nguoi
                if(times==1) //tim duoc nut max de so sanh
                {
                	firstmax= new ArrayList<Integer>();
                	firstmax.add(currentScore);
                }
                scores.add(currentScore);
                if (depth == 0)
                {
                    scoresofmove.add(new insc(currentScore, index));
                }
            } 
            else if (turn.equals("O")==true) 
            {
                Stick(index, human); //danh thu cho nguoi
                if(times==1) //neu times = 1 thi lay gia tri nay lam goc de tim ra gia tri max
                {
                	
                	
	                if (findtesmanwin())
			        { 
			        	scores.add(-9999);; //tra ve gia tri am vo cung neu O win
			        }
			        else
			        {
	                	scores.add(countXwin()-countOwin());
	            	}
            	}
            	else
            	{
            		
            			int tmp;
            			if (findtesmanwin())
				        { 
				        	tmp=(-9999);; //tra ve gia tri am vo cung neu O win
				        }
				        else
				        {
		                	tmp=(countXwin()-countOwin());
		            	}

		            	if(tmp >= firstmax.get(0))
		            	{
		            		scores.add(tmp);
		            		
		            	}
		            	else
		            	{
		            		 scores.add(tmp);
		            		 // System.out.println(scores);
		            		 table[returnI(index)][returnJ(index)] = Integer.toString(convert(returnI(index), returnJ(index))); // xoa cac diem da danh thu
		            		 break;
		            	}
		            	// System.out.println("min= " + scores.get(0));
		            	// System.out.println("max= " +firstmax);
		            	 
            		
            	}
                
            }
            table[returnI(index)][returnJ(index)] = Integer.toString(convert(returnI(index), returnJ(index))); // xoa cac diem da danh thu
        }
        System.out.println(scores);
        // System.out.println(scoresofmove);
        if(turn.equals("O")==true)
        {
            return reMin(scores);
        }
        else
        {
            return reMax(scores);
        }
        // return reMin(scores);
    }
    public List<iat> Checkused(List<iat> array) //kiem tra o da danh 
    {
		for(int i=0; i<3;i++)
		{
			for(int j=0; j<3; j++)
			{
					if(table[i][j].equals("O")==true)
					{
						array.add(new iat(convert(i,j), human));
					}
					else if(table[i][j].equals("X")==true)
					{
						array.add(new iat(convert(i,j), cp));
					}
			}
		}
		
		return array; //tra ve cac tri tri chua danh
    }
    public int countXwin() //dem so lan thang cua X
    {
    	List<Integer> indexcanuse = getSpace();
    	String[][] testTable= new String[3][3];
    	List<iat> array= new ArrayList<iat>();
    	List<iat> newarray=Checkused(array);
    	// System.out.println(newarray);
    	for(int i=0; i<newarray.size();i++) //danh nhung o da ton tai
    	{
    		StickTest(newarray.get(i).index, newarray.get(i).turn, testTable);
    	}
    	
    	for(int i=0; i<indexcanuse.size(); i++) //danh X vao nhung o chua ton tai
    	{
    		StickTest(indexcanuse.get(i), cp, testTable);
    	}
    	// ShowTestTable(testTable);
    	int tongX=0;
    	for(int i=0; i<3; i++)
    	{
    		for(int j=0; j<3; j++)
    		{
    			tongX=tongX+countwin(testTable, i, j, cp); //dem so lan thang cua X
    		}
    	}
    	
    	return tongX;
    }
    public int countOwin() //dem so lan thang cua O
    {
    	List<Integer> indexcanuse = getSpace();
    	String[][] testTable= new String[3][3];
    	List<iat> array= new ArrayList<iat>();
    	List<iat> newarray=Checkused(array);
    	for(int i=0; i<newarray.size();i++) //danh nhung o da ton tai
    	{
    		StickTest(newarray.get(i).index, newarray.get(i).turn, testTable);
    	}
    	for(int i=0; i<indexcanuse.size(); i++) //danh O vao nhung o chua ton tai
    	{
    		StickTest(indexcanuse.get(i), human, testTable);
    	}
    	int tongO=0;
    	for(int i=0; i<3; i++)
    	{
    		for(int j=0; j<3; j++)
    		{
    			tongO=tongO+countwin(testTable, i, j, human); //dem so lan thang cua O
    		}
    	}
    	// System.out.println(tongO);
    	return tongO;
    }
    private int returnI(int index)
    {
    	if(index==1 ||index==2 ||index==3)
    	{
    	    return 0;
    	}
    	else if (index==4 || index==5 || index==6)
    	{
    		return 1;
    	}
    	else if (index==7 || index==8)
    	{
    		return 2;
    	}
    	else
    	{
    		return 2;
    	}
    }
    private int returnJ(int index)
    {
    	if(index==1 ||index==4 ||index==7)
    	{
    	    return 0;
    	}
    	else if (index==2 || index==5 || index==8)
    	{
    		return 1;
    	}
    	else if (index==3 || index==6)
    	{
    		return 2;
    	}
    	else
    	{
    		return 2;
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
			Stick(index1, human);
			saveindex1[i]=indexone; //luu vi tri danh cua nguoi
			check[i]=indexone;
			ShowTable();
			if(findWinner()==true)
			{
				System.out.printf("%s is winner\n", human);
				// scoresofman++;
				break;
			}
			if(i==9-1)
			{
				if(findWinner()==false)
				{
					// scoresofcp++;
					System.out.println("No one is winner");
					break;
				}
			}
			i++;
			System.out.printf("Turn of %s \n", cp);
			StartFind(0,0, "X");
			Stick(findmove(), cp);
			int indextwo=checkindex(findmove());
			saveindex2[i]=indextwo; //luu vi tri danh cua may
			check[i]=indextwo;
			ShowTable();
			if(findWinner()==true)
			{
				System.out.printf("%s is winner\n", cp);
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
			for(;exits(index)==true || (index < 1 || index >9);)
			{
				if(exits(index)==true)
				{
					System.out.println("Index that you entered is exist , please enter index again");
					index=num.nextInt();
				}
				else if(index < 1 || index >9)
				{
					System.out.println("Index that you entered is more than number of table's index, please enter index again");
					index=num.nextInt();
				}
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
	private boolean findtestcpwin()//tim may thang
	{
			boolean find= false;
			if(table[0][0].equals(table[1][0])==true && table[2][0].equals(table[0][0])==true && table[0][0].equals("X")==true)
			{
				find=true;
			}
			else if(table[0][1].equals(table[1][1])==true && table[0][1].equals(table[2][1])==true && table[0][1].equals("X")==true)
			{
				find=true;
			}
			else if(table[0][2].equals(table[1][2])==true && table[0][2].equals(table[2][2])==true && table[0][2].equals("X")==true)
			{
				find=true;
			}
			else if(table[0][0].equals(table[0][1])==true && table[0][0].equals(table[0][2])==true && table[0][0].equals("X")==true)
			{
				find=true;
			}
			else if(table[1][0].equals(table[1][1])==true && table[1][0].equals(table[1][2])==true && table[1][0].equals("X")==true)
			{
				find=true;
			}
			else if(table[2][0].equals(table[2][1])==true && table[2][0].equals(table[2][2])==true && table[2][0].equals("X")==true)
			{
				find=true;
			}
			else if(table[0][0].equals(table[1][1])==true && table[0][0].equals(table[2][2])==true && table[0][0].equals("X")==true)
			{
				find=true;
			}
			else if(table[0][2].equals(table[1][1])==true && table[0][2].equals(table[2][0])==true && table[0][2].equals("X")==true)
			{
				find=true;
			}
			return find;
	}
	private boolean findtesmanwin()//tim nguoi thang
	{
			boolean find= false;
			if(table[0][0].equals(table[1][0])==true && table[2][0].equals(table[0][0])==true && table[0][0].equals("O")==true)
			{
				find=true;
			}
			else if(table[0][1].equals(table[1][1])==true && table[0][1].equals(table[2][1])==true && table[0][1].equals("O")==true)
			{
				find=true;
			}
			else if(table[0][2].equals(table[1][2])==true && table[0][2].equals(table[2][2])==true && table[0][2].equals("O")==true)
			{
				find=true;
			}
			else if(table[0][0].equals(table[0][1])==true && table[0][0].equals(table[0][2])==true && table[0][0].equals("O")==true)
			{
				find=true;
			}
			else if(table[1][0].equals(table[1][1])==true && table[1][0].equals(table[1][2])==true && table[1][0].equals("O")==true)
			{
				find=true;
			}
			else if(table[2][0].equals(table[2][1])==true && table[2][0].equals(table[2][2])==true && table[2][0].equals("O")==true)
			{
				find=true;
			}
			else if(table[0][0].equals(table[1][1])==true && table[0][0].equals(table[2][2])==true && table[0][0].equals("O")==true)
			{
				find=true;
			}
			else if(table[0][2].equals(table[1][1])==true && table[0][2].equals(table[2][0])==true && table[0][2].equals("O")==true)
			{
				find=true;
			}
			return find;
	}
	private int countwin(String[][] cmw, int i, int j, String turn)
	{
			boolean find= false;
			int count=0;
			String t;
			if(turn==human)
			{
				t="O";
			}
			else
			{
				t="X";
			}
			if(i==0 && j==0)
			{
				if(cmw[i][j].equals(cmw[i+1][j])==true && cmw[i+2][j].equals(cmw[i][j])==true && cmw[i][j].equals(t)==true)
				{
					count=count+1;
				}
				if(cmw[i][j].equals(cmw[i][j+1])==true && cmw[i][j].equals(cmw[i][j+2])==true && cmw[i][j].equals(t)==true)
				{
					count=count+1;
				}
				if(cmw[i][j].equals(cmw[i+1][j+1])==true && cmw[i][j].equals(cmw[i+2][j+2])==true && cmw[i][j].equals(t)==true)
				{
					count=count+1;
				}
			}
			else if(i==0 && j==1)
			{
				if(cmw[i][j].equals(cmw[i+1][j])==true && cmw[i+2][j].equals(cmw[i][j])==true && cmw[i][j].equals(t)==true)
				{
					count=count+1;
				}
			}
			else if(i==0 && j==2)
			{
				if(cmw[i][j].equals(cmw[i+1][j])==true && cmw[i+2][j].equals(cmw[i][j])==true && cmw[i][j].equals(t)==true)
				{
					count=count+1;
				}
				if(cmw[i][j].equals(cmw[i+1][j-1])==true && cmw[i][j].equals(cmw[i+2][j-2])==true && cmw[i][j].equals(t)==true)
				{
					count=count+1;
				}
			}
			else if(i==1 && j==0)
			{
				if(cmw[i][j].equals(cmw[i][j+1])==true && cmw[i][j].equals(cmw[i][j+2])==true && cmw[i][j].equals(t)==true)
				{
					count=count+1;
				}
			}
			else if(i==2 && j==0)
			{
				if(cmw[i][j].equals(cmw[i][j+1])==true && cmw[i][j].equals(cmw[i][j+2])==true && cmw[i][j].equals(t)==true)
				{
					count=count+1;
				}
			}
			return count;
	}
}