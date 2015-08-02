public class Piece {
        public boolean isFire;
        private Board b;
        public int x,y;
        public String type;
        private boolean Kinged;

        public Piece(boolean isF, Board bd, int x0, int y0, String str)
        {
                isFire=isF;
                b=bd;
                x=x0;
                y=y0;
                type=str;
                Kinged=false;
        }

	
	public void print(){
		System.out.println(x+","+y+" "+type+" isFire? "+isFire);
	}
        public boolean isFire(){
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
