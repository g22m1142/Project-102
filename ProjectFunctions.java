package Swingg;

public class ProjectFunctions{
	
	 public static boolean pending = true;
     public static int btnum = 0;
     public static boolean player = true; // tells you who is playing
     public static int [][] StateGrid = new int [3][3]; // Records The State Of Each Object;
     public static int [][] holder =  new int [3][3]; // a temporary grid holder
     static int  popx = 0 ,popy = 0;
     
     public static Game_Grid x1 = new Game_Grid(); // creates grid objects
     public static Game_Grid x2 = new Game_Grid();
     public static	Game_Grid x3 = new Game_Grid();
	 public static Game_Grid x4 = new Game_Grid();
	 public static	Game_Grid x5 = new Game_Grid();
	 public static	Game_Grid x6 = new Game_Grid();
	 public static	Game_Grid x7 = new Game_Grid();
	 public static	Game_Grid x8 = new Game_Grid();
	 public static	Game_Grid x9 = new Game_Grid();
	 public static Game_Grid x [][] =  {{x1,x2,x3},
		                     {x4,x5,x6},
							 {x7,x8,x9}};
		
	public static void main (String [] args){
		 // creates 3x3 array of grid objects			

//        public static boolean pending = true;
//        public static int btnum = 0; // stores button number from 0 to 80 (inclusive)
//		boolean player = true; // tells you who is playing
 //       int [][] StateGrid = new int [3][3]; // Records The State Of Each Object;
//		int [][] holder =  new int [3][3]; // a temporary grid holder
//		int popx = 0 ,popy = 0;
			
		}
	public static void UpdateG() {
		// code for button number
		popx = popGrid(btnum)[0]; // checks which object you need to populate
		popy = popGrid(btnum)[1];
	    holder = (x[popx][popy]).getGrid(); // gets the grid of the object
		
		
		holder[popx][popy] = Set_Player(player);	 // updates holder 
		
		(x[popx][popy]).setGrid(holder); // sets the grid to be the same as the holder
		
		(x[popx][popy]).setState( Check_Holder(holder)); // sets the state of the current grid
		
		for (int i = 0 ; i < 3 ; i++){ // records the states of all the grids
			for(int j = 0 ; j < 3 ; j++){
				StateGrid[i][j] = (x[i][j]).getState(); 
			}
		}
		
		if (Check_Holder(StateGrid) == 0 ){
			pending = true;
		}else{
			pending = false;
		}
		
		// code for sending state grid to the game
		
		
	}	
//------------------------------------------------------------------------------------------------------------------------------------------------------
	public static int Set_Player(boolean cond){ // checks if X or O is playing
		if (cond == true){
			return 1;
		}
		return -1;
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------	
	public static int Check_Holder(int [][] h){ // Checks the state of the holder
	    if ( Check_Across(h).GET_State() ){
		    return 	Check_Across(h).GET_Symbol();
		}
		if (  Check_Diagonal(h).GET_State() ){
			return Check_Diagonal(h).GET_Symbol();
		}
		if ( Stale_Mate(h)){
			return 2;
		}
		return 0;
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static gridStates Check_Across(int [][]arr ){ // Checks horiztantally and vertically if anyone has won
	    int a = 0 , b = 0; // will let us know whether it is 1 or -1
		for (int i = 0 ; i < 3 ; i++){	
		int cnt = 0, cnt2 = 0;
		
			for (int j = 0 ; j < 3 ; j++ ){
				if ((arr[i][j] != 0 || arr[j][i] != 0) && (arr[i][j] != 2 || arr[j][i] != 2)){ // Not pending nor stalemate
					if(j < 2 && arr[i][j] == arr[i][j+1]){ // horizantal increment
						cnt =  cnt + 1;	
						a = arr[i][j];
					}
					if (j < 2 && arr[j][i] == arr[j+1][i]){ // vertical increment
						cnt2 = cnt2 + 1;
						b = arr[j][i];
					}
				}
				
			}
			if (cnt == 2){
				return new gridStates(true , a);
			}
			
			if (cnt2 == 2){
				return new gridStates(true , b);
			}
		}
		return new gridStates(false,0);
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------
	public static int [] popGrid (int btnum){ // States which grid you currently want to populate
		 int x = (btnum % 9) / 3;
		 int y = btnum / 27;
		 int arr [] = {x,y};
		 return arr;
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public static gridStates Check_Diagonal(int [][] arr){ //Checks diagonally from left to right
		int cnt = 0 , cnt_2 = 0 , j  = 2;
		int a  = 0, b = 0;
		for (int i = 0 ; i < 2 ; i++){
			if ((arr[i][i] != 0 || arr[j][i] != 0) && (arr[i][i] != 2 || arr[j][i] != 2)  )  
				if (arr[i][i] == arr[i+1][i+1]){
					cnt = cnt + 1;
					a = arr[i][i];
				}
				if (arr[j][i] == arr[j-1][i+1]){
					cnt_2 = cnt_2 + 1;
					b = arr[j][i];
				}
			j = j - 1;
		}
		if (cnt == 2 ){
			return new gridStates (true , a);
		}
		if (cnt_2 == 2 ){
			return new gridStates (true , b);
		}
		
		return new gridStates (false,0);
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean Stale_Mate(int [][] s){    
        for (int i = 0 ; i < 3 ; i++ ){
		    for (int j = 0 ; j < 3 ; j++ ){
				if (s[i][j] != 0){
					return true;
				}
			}
		}
        return false;			
	}

 }

