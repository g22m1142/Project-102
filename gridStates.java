package Swingg;

public class gridStates{
    boolean state;
	int symb ;
	
	public gridStates(){
		state = false;
		symb = 0;
	}
	
	public gridStates(boolean st , int sm){
		state = st;
		symb = sm;
	}
	
	public boolean GET_State(){
		return this.state;
	}
	
	public int GET_Symbol(){
		return this.symb;
	}

}