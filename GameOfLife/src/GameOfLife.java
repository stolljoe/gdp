/**
 * 
 */

/**
 * @author stolljoe
 *
 */
public class GameOfLife {

	/**
	 * @param args
	 */
	public static boolean[][] updategrid(boolean[][] grid)
	{
		boolean[][] gridcache = grid;
		
		return grid;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row;
		int col;
		int[] coordinatesa;
		int[] coordinatesb;
		int livingcells;	

		row=StdIn.readInt();
		col=StdIn.readInt();
		livingcells= StdIn.readInt();
		coordinatesa = new int[livingcells];
		coordinatesb = new int[livingcells];
		int h=0;
		while(!StdIn.isEmpty())
		{
				coordinatesa[h] = StdIn.readInt(); // read each coordinate x
				coordinatesb[h] = StdIn.readInt(); // read coord y
				System.out.println("a= "+ coordinatesa[h] +" b= "+  coordinatesb[h]);
				h++;
	
		}
		System.out.println("livincells= "+livingcells);
		System.out.println("gridsize= "+row+ " "+col);

		/*for(int l=0;l<livingcells;l++)
		{
			System.out.println("a= "+ coordinatesa[l] +" b= "+  coordinatesb[l]);
		}*/
		boolean[][] grid = new boolean[row][col];
		for(int x=1;x<row-1;x++) {
			for(int y=1;y<col-1;y++) {	//cols first then rows!
				for(int z=0;z<coordinatesa.length;z++) {
					if(x==coordinatesa[z] && y == coordinatesb[z]) {
						grid[x][y]=true;
					}
				}
			}
		}
		grid = updategrid(grid); // Put into for loop later
		for(int y=1;y<col-1;y++) { //OUTPUT
			for(int x=1;x<row-1;x++) { // THis time rows first then cols
				if(grid[x][y]==true) System.out.print(" "+1+" ");
				else if(grid[x][y]==false) System.out.print(" "+0+" ");
			}
			System.out.print("\n");
		}
	}
}
