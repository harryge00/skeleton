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
    private boolean pieceSelected;
    private boolean isMoved;
    private int selectX,selectY;

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
		selectX=-1;selectY=-1;
		isMoved=false;pieceSelected=false;
	}
	private  void drawBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i + j) % 2 == 0) StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
				else                  StdDrawPlus.setPenColor(StdDrawPlus.RED);
				StdDrawPlus.filledSquare(i + .5, j + .5, .5);
				
			}
		}
		if(pieceSelected && selectX>=0 && selectX<8 && selectY<8 && selectY>=0){ 
		    StdDrawPlus.setPenColor(StdDrawPlus.WHITE);                
		    StdDrawPlus.filledSquare(selectX+.5,selectY+.5,.5);
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
                                                        pieces[i][j]=new Piece(true,this,i,j,"pawn");
							break;
						case 1:
                                                        pieces[i][j]=new Piece(true,this,i,j,"shield");
							break;
						case 2:
                                                        pieces[i][j]=new Piece(true,this,i,j,"bomb");
							break;
						case 5:
                                                        pieces[i][j]=new Piece(false,this,i,j,"bomb");
							break;
						case 6:
                                                        pieces[i][j]=new Piece(false,this,i,j,"shield");
							break;
						case 7:
                                                        pieces[i][j]=new Piece(false,this,i,j,"pawn");
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
                                        //(pieces[i][j]).print();
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
		    pieces[p.x][p.y]=null;//original place will have no piece
			p.move(x,y);
			pieces[x][y]=p;
		}

	}
	public boolean canSelect(int x,int y)
	{
	    if(x<0||x>7||y>7||y<0)
		return false;
	    if((pieceSelected==false || isMoved==false)&& pieces[x][y]!=null)
		return pieces[x][y].isFire()==playerIsFire;
	    if(pieceSelected==true && isMoved==false  && (selectX-1==x || selectX+1==x) && pieces[x][y]==null)
		if((playerIsFire && selectY+1==y) || (!playerIsFire && selectY-1==y))
		    return true;
	    if(pieceSelected==true && pieces[x][y]==null  && (selectX-2==x || selectX+2==x)){// wait for improvement
		if((playerIsFire && selectY+2==y) || (!playerIsFire && selectY-2==y))
		    return (pieces[(x+selectX)/2][(y+selectY)/2].isFire()!=playerIsFire);
	    }
		return false;
	}


	public void select(int x, int y) 
	{
                if(canSelect(x,y))
                {
		    if(pieces[x][y]!=null){
			/*	StdDrawPlus.setPenColor(StdDrawPlus.WHITE);                
			StdDrawPlus.filledSquare(i + .5, j + .5, .5);
			if(pieceSelected==false) */
			selectX=x;selectY=y;
			pieceSelected=true;
		    }
		    else {
			place(pieces[selectX][selectY],x,y);
			isMoved=true;
		    }
		}

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
		
		System.out.println();
		bd.InitializePieces();
		/** Monitors for mouse presses. Wherever the mouse is pressed,
            a new piece appears. */

                while(true) {

                    if (StdDrawPlus.mousePressed()) {
                                double x = StdDrawPlus.mouseX();
                                double y = StdDrawPlus.mouseY();
				bd.select((int) x,(int) y);
                            }

                            bd.drawBoard();
                            bd.drawPieces();
			StdDrawPlus.show(100);
		}
	}
}
