package example;

public class KnightTour {
	static int count=0;
	private static boolean solved=false;
	public int spaces=0;
	public static int[][] board;
	public static void main(String[]args){
		KnightTour a= new KnightTour ();

		a.tour(8,8);
		System.out.println("Recursive function called "+ count+ " times");

	}

//	this is the print method
	
//		if the number<10{ printSpace(){ print # + space
	public void print(int[][] b){
	
		for (int x = 0; x < b.length; x ++){
			
			for (int y = 0; y < b[0].length; y ++){
//			format string	%d is a conversion for an integral value
				System.out.printf("%3d", b[x][y] );
			
				
			}
			
			 System.out.println();
		}
	}

	public int[][] tour(int l, int w){
	
		board = new int[l][w];
		for (int x = 0; x < l; x ++){
			
			for (int y = 0; y < w; y ++){
				Fill(board, x , y ,1);
				if (solved){
					print(board);
					
					return board;
					
				}
			}
		}
		System.out.println("No solution");

		print(board);
		return board;
	}
//	row is up and down
//	column is by sides
	public static void Fill(int[][] board,int row, int col,  int num){
		count++;//trace
		//if the  2 d array is 0 then it will equal to the move
		if(board[row][col] == 0){
			board[row][col] = num;
			if (num == board.length * board[0].length){
				solved = true;

			}
			num ++;
//			1
			if(!solved){
				if(row + 2 < board.length && col + 1 < board[0].length
						&& row + 2 >= 0 && col + 1 >= 0)
					Fill(board, row + 2, col + 1,num);
			}
//			2
			if(!solved){
				if(row + 1 < board.length && col + 2 < board[0].length
						&& row + 1 >= 0 && col + 2 >= 0)
					Fill(board, row + 1,  col+ 2,num);
			}
//			3
			if(!solved){
				if(row - 1 < board.length && col + 2 < board[0].length
						&& row - 1 >= 0 && col + 2 >= 0)
					Fill(board,  row - 1, col + 2,num);
			}
//			4
			if(!solved){
				if(row - 2 < board.length && col + 1 < board[0].length
						&& row - 2 >= 0 && col + 1 >= 0)
					Fill(board , row - 2, col + 1,num);
			}
//			5
			if(!solved){
				if(row -2  < board.length && col - 1 < board[0].length
						&& row - 2 >= 0 && col - 1 >= 0)
					Fill(board , row -2, col - 1,num);
			}
//			6
			if(!solved){
				if(row - 1 < board.length && col - 2 < board[0].length
						&& row - 1 >= 0 && col - 2 >= 0)
					Fill(board , row - 1, col - 2,num);
			}
//			7
			if(!solved){
				if(row + 1 < board.length && col - 2 < board[0].length
						&& row + 1 >= 0 && col - 2 >= 0)
					Fill(board , row + 1, col - 2,num);
			}
//			8
			if(!solved){
				if(row + 2 < board.length && col - 1 < board[0].length
						&& row + 2 >= 0 && col - 1 >= 0)
					Fill(board ,   row + 2, col - 1,num);
			}
			if(!solved){
				board[row][col] = 0;
				num --;
			}
		}
	}
}