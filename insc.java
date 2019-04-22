public class insc 
{ //chua 2 diem danh va score cua 2 diem danh nay

    int score;
    int index;

    public insc(int score, int index) 
    {
        this.score = score;
        this.index = index;
    }
    public String toString()
    {
    	return "[" + score + " ,  " + index + "]";
    }
}