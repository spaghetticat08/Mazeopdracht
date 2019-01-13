
public class Main {

	public static void main(String[] args) {
		String[][] mazeLayout = new String[][] {
			{"*"," ","*","*","*","*","*","*","*"},
			{"*"," "," "," "," "," ","*"," ","*"},
			{"*"," ","*","*","*","*","*"," ","*"},
			{"*"," ","*"," ","*"," "," "," ","*"},
			{"*"," ","*"," ","*","*","*"," ","*"},
			{"*"," "," "," ","*"," "," "," ","*"},
			{"*","*","*"," ","*"," ","*"," ","*"},
			{"*"," "," "," "," "," ","*"," ","*"},
			{"*","*","*","*","*","*","*","F","*"}
			};
			
			int rows = mazeLayout.length;
			int columns = mazeLayout[0].length;
			int startrow = 0; 
			int startcolumn;
		
			Maze newMaze = new Maze(mazeLayout);
			
			//find the startcolumn
			startcolumn = newMaze.findStartPosition(mazeLayout, rows, columns);
			boolean mazeSolved= false;
			//start to solve the maze
			mazeSolved = newMaze.solve(mazeLayout, startrow, startcolumn);
			if (mazeSolved == true) {
				System.out.println("Succes");
				for (int i=0; i< rows; i++) {
					for (int j=0; j< columns; j++) {
						System.out.print(mazeLayout[i][j]);
					}
					System.out.println();
				}
			}
			else {
				System.out.println("Failed");
				
				for (int i=0; i< rows; i++) {
					for(int j=0; j<columns; j++) {
						System.out.print(mazeLayout[i][j]);
					}
						System.out.println();
				}
			
			}
			
}
}
