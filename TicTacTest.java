
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacTest implements ActionListener{
	private static final String Borderlayout = null;
	ProjectFunctions pfunc= new ProjectFunctions();
	JFrame frameObj = new JFrame();
	JPanel title = new JPanel();
	JPanel button = new JPanel();
	JPanel Button = new JPanel();
	JLabel txt = new JLabel();
	JButton[] btn = new JButton[81];
	JButton[] Btn = new JButton[9];
	public static boolean Playerturn = true;
	public static int buttonnum=0;
	int [][] StateGrid = ProjectFunctions.StateGrid;
	Game_Grid [][] gridx = ProjectFunctions.x;
	
	
	
	TicTacTest() {
		frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameObj.setSize(800, 700);
		frameObj.getContentPane().setBackground(Color.cyan);
		frameObj.setLayout(new BorderLayout());
		frameObj.setVisible(true);
		txt.setBackground(Color.BLACK);
		txt.setForeground(Color.white);
		txt.setFont(new Font("Ink Free",Font.BOLD,45));
		txt.setHorizontalAlignment(JLabel.CENTER);
		txt.setText("Blackfyre Rebellion");
		txt.setOpaque(true);
		title.setLayout(new BorderLayout());
		title.setBounds(0, 0, 800, 100);
		
		button.setLayout(new GridLayout(9,9));
//		Button0.setLayout(new GridLayout(3,3));
		button.setBackground(Color.BLACK);
		
		for(int i = 0;i<81;i++ ) {
			btn[i] = new JButton();
			button.add(btn[i]);
			btn[i].setFont(new Font("MV Boli",Font.BOLD,70));
			btn[i].setFocusable(false);
			btn[i].addActionListener(this);
			btn[i].setBackground(Color.DARK_GRAY);
		}
			title.add(txt);
			frameObj.add(title,BorderLayout.NORTH);
			frameObj.add(button);
			Button.setVisible(false);
			//frameObj.add(Button);
		}
		
//}

	public static String  positionGrid (int i) {
		int x = i % 3;
		int y = (i / 9)%3;
		int [] arr = {x,y};
		return Arrays.toString(arr);
	}
	
	public static String CheckGrid(int i ) {
		int x = (i %9 )/3;
		int y = i /27;
		int arr [] = {x,y};
		return Arrays.toString(arr);
	}
	@Override
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		txt.setText("X Turn");
		int x , y;
		for(int i = 0; i < 81; i++) {
			if(e.getSource() == btn[i]) {
				if (Playerturn) {
					if(btn[i].getText()== "") {		//check if a button has a text on it
						btn[i].setForeground(new Color(255, 0, 0));
						ProjectFunctions.btnum=i;
						btn[i].setText("X");
						Playerturn = false; // To set player two's turn
						ProjectFunctions.player=Playerturn;
						txt.setText("O Turn");
						
						
						ProjectFunctions.UpdateG();
						for(int j = 0; j < 81; j++) {
							btn[j].setEnabled(false); //Disables buttons in other Grid
							x = (j % 9)/3;
							y = j /27 ;
							if((x%2) == (y%2)) {
								btn[j].setBackground(Color.red);
							}else {
								btn[j].setBackground(Color.DARK_GRAY);
							}
							
						}
						
						for (int z = 0; z < 81 ; z++ ){
							x = (z%9)/3;
							y = z/27;
							if (StateGrid[y][x] == 1){
								btn[z].setText("O");
							}
							if (StateGrid[y][x] == -1){
								btn[z].setText("X");
							
							}
							if (StateGrid[y][x] == 2){
								btn[z].setEnabled(false);
							}
//							
							
						}
						System.out.println("State Grid : "+Arrays.deepToString(StateGrid));		
						System.out.println((i/9)%3+ " "+i%3);
						System.out.println(i);
						
						for (int k = 0 ; k < 81 ; k++) {
							if( (positionGrid(i).equals(CheckGrid(k))) && (StateGrid[k/27][(k%9)/3]==0) ){
								btn[k].setEnabled(true); //Enables buttons in the playable grid
								btn[k].setBackground(Color.white);
							}
						}
						int a = 0 , b = 0;
						a = i%3;
						b = (i / 9)%3;
						if (StateGrid[b][a] != 0) {
							for (int c = 0 ; c < 81 ; c++) {
								if (StateGrid[c/27][(c%9)/3]==0) {
									btn[c].setEnabled(true);
									btn[c].setBackground(Color.white);
								}else {
									btn[c].setEnabled(false);
								}
							}
						}
						
						if (ProjectFunctions.Check_Holder(StateGrid) == -1){
							txt.setText("X won");
							for(int k = 0 ; k < 81 ; k++){
								btn[k].setEnabled(false);
							}
							for(int j = 0; j < 81; j++) {
								btn[j].setEnabled(false);
								x = (j % 9)/3;
								y = j /27 ;
								if((x%2) == (y%2)) {
									btn[j].setBackground(Color.red);
								}else {
								btn[j].setBackground(Color.DARK_GRAY);
								}
								
							}
						}
						if (ProjectFunctions.Check_Holder(StateGrid) == 1){
							txt.setText("O won");
							for(int k = 0 ; k < 81 ; k++){
								btn[k].setEnabled(false);
							}
							for(int j = 0; j < 81; j++) {
								btn[j].setEnabled(false);
								x = (j % 9)/3;
								y = j /27 ;
								if((x%2) == (y%2)) {
									btn[j].setBackground(Color.red);
								}else {
								btn[j].setBackground(Color.DARK_GRAY);
								}
								
							}
						}
						if (ProjectFunctions.Check_Holder(StateGrid) == 2){
							txt.setText("Stale Mate");
							for(int k = 0 ; k < 81 ; k++){
								btn[k].setEnabled(false);
							}
							for(int j = 0; j < 81; j++) {
								btn[j].setEnabled(false);
								x = (j % 9)/3;
								y = j /27 ;
								if((x%2) == (y%2)) {
									btn[j].setBackground(Color.red);
								}else {
								btn[j].setBackground(Color.DARK_GRAY);
								}
								
							}
						}
						
					}			
				}
				else {
					if(btn[i].getText()== "") {		//check if a button has a text on it
						btn[i].setForeground(new Color(0, 0, 255));
						ProjectFunctions.btnum=i;
						btn[i].setText("O");
						Playerturn = true;
						ProjectFunctions.player = Playerturn;
						txt.setText("X Turn");
						
						ProjectFunctions.UpdateG();
						for(int j = 0; j < 81; j++) {
							btn[j].setEnabled(false);
							x = (j % 9)/3;
							y = j /27 ;
							if((x%2) == (y%2)) {
								btn[j].setBackground(Color.red);
							}else {
							btn[j].setBackground(Color.DARK_GRAY);
							}
							
						}
						
						for (int z = 0; z < 81 ; z++ ){
							x = (z%9)/3;
							y = z/27;
							if (StateGrid[y][x] == 1){
								btn[z].setText("O");
								
							}
							if (StateGrid[y][x] == -1){
								btn[z].setText("X");
								
							}
							if (StateGrid[y][x] == 2){
								btn[z].setEnabled(false);
							}
							
							
						}
						System.out.println("State Grid : "+Arrays.deepToString(StateGrid));
						System.out.println((i/9)%3+ " "+i%3);
						System.out.println(i);
						for (int k = 0 ; k < 81 ; k++) {
							if( (positionGrid(i).equals(CheckGrid(k))) && (StateGrid[k/27][(k%9)/3]==0) ){
								btn[k].setEnabled(true);
								btn[k].setBackground(Color.white);
							}
						}
						int a = 0 , b = 0;
						a = i%3;
						b = (i / 9)%3;
						if (StateGrid[b][a] != 0) {
							for (int c = 0 ; c < 81 ; c++) {
								if (StateGrid[c/27][(c%9)/3]==0) {
									btn[c].setEnabled(true);
									btn[c].setBackground(Color.white);
								}else {
									btn[c].setEnabled(false);
								}
							}
						}
						
						if (ProjectFunctions.Check_Holder(StateGrid) == -1){
							txt.setText("X won");
							for(int k = 0 ; k < 81 ; k++){
								btn[k].setEnabled(false);
							}
							for(int j = 0; j < 81; j++) {
								btn[j].setEnabled(false);
								x = (j % 9)/3;
								y = j /27 ;
								if((x%2) == (y%2)) {
									btn[j].setBackground(Color.red);
								}else {
								btn[j].setBackground(Color.DARK_GRAY);
								}
								
							}
							
						}
						if (ProjectFunctions.Check_Holder(StateGrid) == 1){
							txt.setText("O won");
							for(int k = 0 ; k < 81 ; k++){
								btn[k].setEnabled(false);
							}
							for(int j = 0; j < 81; j++) {
								btn[j].setEnabled(false);
								x = (j % 9)/3;
								y = j /27 ;
								if((x%2) == (y%2)) {
									btn[j].setBackground(Color.red);
								}else {
								btn[j].setBackground(Color.DARK_GRAY);
								}
								
							}
						}
						if (ProjectFunctions.Check_Holder(StateGrid) == 2){
							txt.setText("Stale Mate");
							for(int k = 0 ; k < 81 ; k++){
								btn[k].setEnabled(false);
							}
							for(int j = 0; j < 81; j++) {
								btn[j].setEnabled(false);
								x = (j % 9)/3;
								y = j /27 ;
								if((x%2) == (y%2)) {
									btn[j].setBackground(Color.red);
								}else {
								btn[j].setBackground(Color.DARK_GRAY);
								}
								
							}
						}
					}		
				}
			}
		}
	}
}

