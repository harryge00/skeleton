/** 
 *  @author HarryGe
 */

public class Board {
	/** Location of pieces. */
	private static boolean[][] pieces;//0 empty;1 Normal;2 shields 3 Bombs
	private static Piece[][] ps;
	private static int N;
	private int numFirePieces;
	private int numWaterPieces;
	private boolean playerIsFire;
	/** Draws an N x N board. Adapted from:
        http://introcs.cs.princeton.edu/java/15inout/CheckerBoard.java.html
	 */

	public Board(boolean shouldBeEmpty) {
		N=8;
		pieces = new boolean[N][N];
		ps =new Piece[N][N];
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
	private static void drawBoard(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i + j) % 2 == 0) StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
                else                  StdDrawPlus.setPenColor(StdDrawPlus.RED);
                StdDrawPlus.filledSquare(i + .5, j + .5, .5);
                StdDrawPlus.setPenColor(StdDrawPlus.WHITE);                
            }
        }
    }
	private void InitializeBoard(){

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {            	
				if ((i + j) % 2 == 0) 
				{
					StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
					if(j<3||j>4)
					{
						pieces[i][j]=true;
						switch(j) {
						case 0:ps[i][j]=new Piece(true,this,i,j,"pawn");
						break;
						case 1:ps[i][j]=new Piece(true,this,i,j,"shield");
						break;
						case 2:ps[i][j]=new Piece(true,this,i,j,"bomb");
						break;
						case 5:ps[i][j]=new Piece(false,this,i,j,"bomb");
						break;
						case 6:ps[i][j]=new Piece(false,this,i,j,"shield");
						break;
						case 7:ps[i][j]=new Piece(false,this,i,j,"pawn");
						System.out.println("case 7");
						break;
						default: System.out.println(i+":"+j+"no such place");
						}
						ps[i][j].print();
						if(j>=2){
							System.out.println("-2:");
							ps[i][j-2].print();
						}
					}
					else
					{
						pieces[i][j]=false;
						ps[i][j]=new Piece(false,this,i,j,"");
					}

				}
				else                  
				{
					StdDrawPlus.setPenColor(StdDrawPlus.RED);
					pieces[i][j]=false;
					ps[i][j]=new Piece(false,this,i,j,"");
				}
				StdDrawPlus.filledSquare(i + .5, j + .5, .5);
//				if (shouldBeEmpty==false && (i + j) % 2 == 0) 
//				{
//					if(j<3||j>4)
//						switch(j){
//						case 0: StdDrawPlus.picture(i+ .5, j+ .5, "img/pawn-fire.png", 1, 1);break;
//						case 1: StdDrawPlus.picture(i+ .5, j+ .5, "img/shield-fire.png", 1, 1);break;
//						case 2: StdDrawPlus.picture(i+ .5, j+ .5, "img/bomb-fire.png", 1, 1);break;
//						case 5: StdDrawPlus.picture(i+ .5, j+ .5, "img/bomb-water.png", 1, 1);break;
//						case 6: StdDrawPlus.picture(i+ .5, j+ .5, "img/shield-water.png", 1, 1);break;
//						case 7: StdDrawPlus.picture(i+ .5, j+ .5, "img/pawn-water.png", 1, 1); break;
//						}
//				}
				StdDrawPlus.setPenColor(StdDrawPlus.WHITE);                
			}
		}
		if (shouldBeEmpty==false)
			for (int k = 0; k < N; k++) {
				for (int l = 0; l < N; l++) {
					if(pieces[k][l]==true)
					{
						System.out.println(k+","+l);
						ps[k][l].print();
						String picturepath=getPicName((ps[k][l]));
						StdDrawPlus.picture(k+ .5, l+ .5, picturepath, 1, 1);
					}

				}
			}
	}
	private String getPicName(Piece p)//get the name of picture
	{
		p.print();
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
	private Piece pieceAt(int x,int y)
	{
		if(x<0||x>8||y<0||y>8||pieces[x][y]==false)
			return null;
		else
		{
			return ps[x][y];
		}
	}
	private void place(Piece p,int x,int y)
	{
		if(x<0||x>8||y<0||y>8)
			return;
		else
			if(pieces[x][y]==true)
				remove(x,y);
		p.move(x,y);
		pieces[x][y]=true;
	}
	private Piece remove(int x,int y)
	{
		if(x<0||x>8||y<0||y>8)
		{
			System.out.println(x+","+y +" is out of bounds.");
			return null;
		}
		else if(pieces[x][y]==false)
		{
			System.out.println(" No piece is at :"+x+","+y);
			return null;
		}
		else
		{
			//remove? 
			pieces[x][y]=false;
			return pieceAt(x,y);
		}
	}
	public static void main(String[] args) {


		StdDrawPlus.setXscale(0, 8);
		StdDrawPlus.setYscale(0, 8); 

		Board BL=new Board(false);
		InitializeBoard();
		/** Monitors for mouse presses. Wherever the mouse is pressed,
            a new piece appears. */

		while(true) {


			StdDrawPlus.show(100);
		}
	}
}
