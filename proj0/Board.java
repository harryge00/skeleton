/** 
 *  @author HarryGe
 */

public class Board {
	/** Location of pieces. */
	//private static boolean[][] pieces;//0 empty;1 Normal;2 shields 3 Bombs
	private Piece[][] pieces;
	private static int N;
	private int numFirePieces;
	private int numWaterPieces;
	private boolean playerIsFire;
	/** Draws an N x N board. Adapted from:
        http://introcs.cs.princeton.edu/java/15inout/CheckerBoard.java.html
	 */

	public Board(boolean shouldBeEmpty) {
		N=8;
		pieces = new Piece[N][N];
		if(shouldBeEmpty)
		{
			numFirePieces=0;
			numWaterPieces=0;
		}
		else
		{
			numFirePieces=12;
			numWaterPieces=12;
		}
		playerIsFire=true;
	}
	private  void drawBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i + j) % 2 == 0) StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
				else                  StdDrawPlus.setPenColor(StdDrawPlus.RED);
				StdDrawPlus.filledSquare(i + .5, j + .5, .5);
				StdDrawPlus.setPenColor(StdDrawPlus.WHITE);                
			}
		}
	}
	
	private void InitializePieces(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				pieces[i][j]=null;
				if ((i + j) % 2 == 0) 
				{				
						switch(j) {
						case 0:
							pieces[i][j]=new Piece(true,this,i,j,"pawn");pieces[i][j].print();
							break;
						case 1:
							pieces[i][j]=new Piece(true,this,i,j,"shield");pieces[i][j].print();
							break;
						case 2:
							pieces[i][j]=new Piece(true,this,i,j,"bomb");pieces[i][j].print();
							break;
						case 5:
							pieces[i][j]=new Piece(false,this,i,j,"bomb");pieces[i][j].print();
							break;
						case 6:
							pieces[i][j]=new Piece(false,this,i,j,"shield");pieces[i][j].print();
							break;
						case 7:
							pieces[i][j]=new Piece(false,this,i,j,"pawn");pieces[i][j].print();
							//						System.out.println("case 7");
							break;
						default: 
							break;
						}					
				}
			}
		}
	}
	private void drawPieces(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if((pieces[i][j])!=null)
				{
					(pieces[i][j]).print();
					String picturePath=getPicPath(pieces[i][j]);
					StdDrawPlus.picture(i + .5, j + .5, picturePath, 1, 1);
				}
			}
		}
	}
	private String getPicPath(Piece p)//get the name of picture
	{
		
		String PicName="img/"; 
		if(p.isShield())
			PicName+="shield";
		else if(p.isBomb())
			PicName+="bomb";
		else
			PicName+="pawn";
		if(p.isFire())
			PicName+="-fire";
		else
			PicName+="-water";
		if(p.isKing())
			PicName+="-crowned";
		PicName+=".png";
		return PicName;
	}
	public Piece pieceAt(int x,int y)
	{
		if(x<0||x>8||y<0||y>8)
			return null;
		else
		{
			return pieces[x][y];
		}
	}
	public void place(Piece p,int x,int y)
	{
		if(x<0||x>8||y<0||y>8)
			return;
		else
		{
			p.move(x,y);
			pieces[x][y]=p;
		}

	}
	public boolean canSelect(int x,int y)
	{
		return true;
	}
	public void select(int x, int y) 
	{
		
	}
	public boolean canEndTurn() 
	{
		return false;
	}
	public Piece remove(int x,int y)
	{
		if(x<0||x>8||y<0||y>8)
		{
			System.out.println(x+","+y +" is out of bounds.");
			return null;
		}
		else
		{		
		
			Piece tmp=pieces[x][y];
			if(tmp==null)
				System.out.println(x+","+y +" No Pieces");
			pieces[x][y]=null;
			return tmp;
		}
	}
	public static void main(String[] args) {


		StdDrawPlus.setXscale(0, 8);
		StdDrawPlus.setYscale(0, 8); 

		Board bd=new Board(false);
		
		
//		Piece [] ps=new Piece[3];
//		ps[0]=new Piece(true,bd,0,0,"shield");
//		ps[1]=new Piece(true,bd,1,1,"bomb");
//		ps[2]=new Piece(true,bd,2,2,"pawn");				
//		ps[0].print();
//		ps[1].print();
//		ps[2].print();
		
		
		
		
		System.out.println();
		bd.InitializePieces();
		/** Monitors for mouse presses. Wherever the mouse is pressed,
            a new piece appears. */
		bd.drawBoard();
		bd.drawPieces();
		while(true) {			
			StdDrawPlus.show(100);
		}
	}
}
