
public class Maze {
	
	boolean solved = false;
	public Maze(String[][] mazeLayout) {
	}
		
	public int findStartPosition(String[][] mazeLayout, int rows, int columns) {
		int startcolumn = 0;
		//find the column position where our maze starts. Now we now for fact that  our row position is 0 but,
		//if we didn't know this, we could add an extra for loop to find the correct row
		for (int i = 0; i<columns; i++) {
			if (mazeLayout[0][i] == " ") {
				mazeLayout[0][i] = "S";
				startcolumn = i;
				}	
		}
		return startcolumn;
	}
	
	public boolean solve(String[][] mazeLayout, int rows, int columns) {	
	
		//check if we are at finish
		if(isValidPath(mazeLayout, rows, columns) && mazeLayout[rows][columns] == "F")
			solved = true;
		else if(isValidPath(mazeLayout, rows, columns )) {
			
			//mark our path as visited
			mazeLayout[rows][columns] = "V";
			
			//go left
			solved = solve(mazeLayout, rows, columns+1);
			if(!solved)
				//go right
				solved = solve(mazeLayout, rows, columns-1);
			if(!solved) 
				//go up
				solved = solve(mazeLayout, rows+1, columns);
			if(!solved) 
				//go down
				solved = solve(mazeLayout, rows-1, columns);
			
			//mark out path with O
			if(solved) 
				mazeLayout[rows][columns] = "O";	
		}
		return solved;
		}

	
	public boolean isValidPath(String[][] mazeLayout, int rows, int columns) {
		boolean check = false;
		//check if our chosen position is within bounds
		if(rows>= 0 && rows<mazeLayout.length && columns>= 0 && columns < mazeLayout[0].length) {
			//check whether our chosen location is either empty, marked as start or as finish
			if(mazeLayout[rows][columns] == " " || mazeLayout[rows][columns] == "S" || mazeLayout[rows][columns] =="F") {
				check = true;
			}}
		return check;
	}
		
}

