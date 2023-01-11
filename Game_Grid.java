package Swingg;


public class Game_Grid {
	int Grids [][] ;
	int x_y [];
	int state;
	
	
	public Game_Grid(){ // Constructor
		this.Grids = new int[3][3];
		this.x_y = new int[2];
		this.state = 0;
	}
//==================================--------------GETTERS--------------===================================================================	
	public int [][] getGrid(){
		return this.Grids;
	}
	
	public int [] getX_Y(){
		return this.x_y;
	}
	
	public int getState(){
		return this.state;
	}	
//==================================--------------SETTERS--------------===================================================================	
	public void setGrid (int [][] arr){
			int [][] x = this.Grids; // x alias == arr
			for (int i = 0 ; i < 3 ; i++){
				for (int j = 0 ; j < 3 ; j++ ){
					x[i][j] = arr[i][j];
				}
			}
	}
	
	public void setState(int x){  // -1 X ----------  1 O ------------- 2 Stale ----------- 0 Pending
		this.state = x;
	}
	
	
	
}