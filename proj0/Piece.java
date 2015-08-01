public class Piece {
	private static boolean isFire;
	private static Board b;
	private static int x,y;
	private static String type;
	private static boolean Kinged;
	public Piece (){
		isFire=false;
		b=null;
		x=0;y=0;type="";Kinged=false;
	}
	public Piece(boolean isFire, Board b, int x, int y, String type)
	{
		this.isFire=isFire;
		this.b=b;
		this.x=x;
		this.y=y;
		this.type=type;
		this.Kinged=false;
	}
	public void setPiece(boolean isFire, Board b, int x, int y, String type)
	{
		this.isFire=isFire;
		this.b=b;
		this.x=x;
		this.y=y;
		this.type=type;
		this.Kinged=false;
	}
	
	public void print(){
		System.out.println(x+","+y+" "+type+" isFire? "+isFire);
	}
	public static boolean isFire(){
		return isFire;
	}
	public int side(){
		if(isFire)
			return 0;
		else
			return 1;
	}
	public boolean isKing(){
		return Kinged;
	}
	public boolean isBomb(){
		return (type=="bomb");
	}
	public boolean isPawn(){
		return (type=="pawn");
	}
	public boolean isShield(){
		return (type=="shield");
	}
	public void move(int a, int b){
		x=a;
		y=b;
	}
}