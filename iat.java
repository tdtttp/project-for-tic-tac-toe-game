public class iat //class chua vi tri va turn
{
	int index;
	String turn;
	public iat(int index, String turn)
	{
		this.index=index;
		this.turn=turn;
	}
	public String toString()
	{
		return "[" + index + " ,  " + turn + "]";
	}
}