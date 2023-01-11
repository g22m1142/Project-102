package Swingg;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ultimate implements ActionListener{
	
	private static final String Borderlayout = null;
	JFrame frameObj = new JFrame();
	JPanel title = new JPanel();
	JPanel button = new JPanel();
	JLabel txt = new JLabel();
	JButton[] btn = new JButton[81];
	boolean Playerturn = true;
	
	
	Ultimate() {
		frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameObj.setSize(800, 800);
		frameObj.getContentPane().setBackground(Color.black);
		frameObj.setLayout(new BorderLayout());
		frameObj.setVisible(true);
		txt.setBackground(Color.BLACK);
		txt.setForeground(Color.gray);
		txt.setFont(new Font("Ink Free",Font.BOLD,45));
		txt.setHorizontalAlignment(JLabel.CENTER);
		txt.setText("Blackfyre Rebelion");
		txt.setOpaque(true);
		title.setLayout(new BorderLayout());
		title.setBounds(0, 0, 800, 100);
		
		button.setLayout(new GridLayout(9,9));
		button.setBackground(Color.gray);
		
		for(int i = 0;i<81;i++ ) {
			btn[i] = new JButton();
			button.add(btn[i]);
			btn[i].setFont(new Font("MV Boli",Font.BOLD,70));
			btn[i].setFocusable(false);
			btn[i].addActionListener(this);
		}
		
		title.add(txt);
		frameObj.add(title,BorderLayout.NORTH);
		frameObj.add(button);
		
//		firstplay();
	}
	public  void ActionListener(ActionEvent e) {
		
	}
//	public void firstplay() {
//		if (cnt == 1) {
//			Playerturn = true;
//			txt.setText("X Turn");
//		}
//		else {
//			Playerturn = false;
//			txt.setText("O Turn");
//		}
//	}
	public void check() {
		
	}
	public void Xwin(int a, int b, int c) {
		
	}
	public void Owin(int a, int b, int c) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Integer> NorthWest = new ArrayList<>();
		NorthWest.add(0);NorthWest.add(3);NorthWest.add(6);NorthWest.add(27);NorthWest.add(30);NorthWest.add(33);NorthWest.add(54);NorthWest.add(57);NorthWest.add(60);
		
		ArrayList<Integer> North = new ArrayList<>();
		North.add(1);North.add(4);North.add(7);North.add(28);North.add(31);North.add(34);North.add(55);North.add(58);North.add(61);
		
		ArrayList<Integer> NorthEast = new ArrayList<>();
		NorthEast.add(2);NorthEast.add(5);NorthEast.add(8);NorthEast.add(29);NorthEast.add(32);NorthEast.add(35);NorthEast.add(56);NorthEast.add(59);NorthEast.add(62);
		
		ArrayList<Integer> West = new ArrayList<>();
		West.add(9);West.add(12);West.add(15);West.add(36);West.add(39);West.add(42);West.add(63);West.add(66);West.add(69);
		
		ArrayList<Integer> Middle = new ArrayList<>();
		Middle.add(10);Middle.add(13);Middle.add(16);Middle.add(37);Middle.add(40);Middle.add(43);Middle.add(64);Middle.add(67);Middle.add(70);
		
		ArrayList<Integer> East = new ArrayList<>();
		East.add(11);East.add(14);East.add(17);East.add(38);East.add(41);East.add(44);East.add(65);East.add(68);East.add(71);
		
		ArrayList<Integer> SouthWest = new ArrayList<>();
		SouthWest.add(18);SouthWest.add(21);SouthWest.add(24);SouthWest.add(45);SouthWest.add(48);SouthWest.add(51);SouthWest.add(72);SouthWest.add(75);SouthWest.add(78);
		
		ArrayList<Integer> South = new ArrayList<>();
		South.add(19);South.add(22);South.add(25);South.add(46);South.add(49);South.add(52);South.add(73);South.add(76);South.add(79);
		
		ArrayList<Integer> SouthEast = new ArrayList<>();
		SouthEast.add(20);SouthEast.add(23);SouthEast.add(26);SouthEast.add(47);SouthEast.add(50);SouthEast.add(53);SouthEast.add(74);SouthEast.add(77);SouthEast.add(80);
		
		
		
		
		txt.setText("X Turn");
		for(int i = 0; i < 81; i++) {
			if(e.getSource() == btn[i]) {
				if (Playerturn) {
					if(btn[i].getText()== "") {		//check if a button has a text on it
						btn[i].setForeground(new Color(255, 0, 0));
						btn[i].setText("X");
						Playerturn = false;
						txt.setText("O Turn");
						check(); 
						
						for(int j = 0; j < 81; j++) {
							btn[j].setEnabled(false);
						}
						
						//hard coded
							if (NorthWest.contains(i)) {
								btn[0].setEnabled(true);btn[1].setEnabled(true);btn[2].setEnabled(true);btn[9].setEnabled(true);btn[10].setEnabled(true);btn[11].setEnabled(true);btn[18].setEnabled(true);btn[19].setEnabled(true);btn[20].setEnabled(true);								
								
							}
							else if (North.contains(i)) {
								btn[3].setEnabled(true);btn[4].setEnabled(true);btn[5].setEnabled(true);btn[12].setEnabled(true);btn[13].setEnabled(true);btn[14].setEnabled(true);btn[21].setEnabled(true);btn[22].setEnabled(true);btn[23].setEnabled(true);
								
							}
							else if (NorthEast.contains(i)) {
								btn[6].setEnabled(true);btn[7].setEnabled(true);btn[8].setEnabled(true);btn[15].setEnabled(true);btn[16].setEnabled(true);btn[17].setEnabled(true);btn[24].setEnabled(true);btn[25].setEnabled(true);btn[26].setEnabled(true);
							}
							else if (West.contains(i)) {
								btn[27].setEnabled(true);btn[28].setEnabled(true);btn[29].setEnabled(true);btn[36].setEnabled(true);btn[37].setEnabled(true);btn[38].setEnabled(true);btn[45].setEnabled(true);btn[46].setEnabled(true);btn[47].setEnabled(true);
							}
							else if (Middle.contains(i)) {
								btn[30].setEnabled(true);btn[31].setEnabled(true);btn[32].setEnabled(true);btn[39].setEnabled(true);btn[40].setEnabled(true);btn[41].setEnabled(true);btn[48].setEnabled(true);btn[49].setEnabled(true);btn[50].setEnabled(true);
							}
							else if (East.contains(i)) {
								btn[33].setEnabled(true);btn[34].setEnabled(true);btn[35].setEnabled(true);btn[42].setEnabled(true);btn[43].setEnabled(true);btn[44].setEnabled(true);btn[51].setEnabled(true);btn[52].setEnabled(true);btn[53].setEnabled(true);
							}
							else if (SouthWest.contains(i)) {
								btn[54].setEnabled(true);btn[55].setEnabled(true);btn[56].setEnabled(true);btn[63].setEnabled(true);btn[64].setEnabled(true);btn[65].setEnabled(true);btn[72].setEnabled(true);btn[73].setEnabled(true);btn[74].setEnabled(true);
							}
							else if (South.contains(i)) {
								btn[57].setEnabled(true);btn[58].setEnabled(true);btn[59].setEnabled(true);btn[66].setEnabled(true);btn[67].setEnabled(true);btn[68].setEnabled(true);btn[75].setEnabled(true);btn[76].setEnabled(true);btn[77].setEnabled(true);
							}
							else if (SouthEast.contains(i)) {
								btn[60].setEnabled(true);btn[61].setEnabled(true);btn[62].setEnabled(true);btn[69].setEnabled(true);btn[70].setEnabled(true);btn[71].setEnabled(true);btn[78].setEnabled(true);btn[79].setEnabled(true);btn[80].setEnabled(true);
							}
						
					}			
				}
				else {
					if(btn[i].getText()== "") {		//check if a button has a text on it
						btn[i].setForeground(new Color(0, 0, 255));
						btn[i].setText("O");
						Playerturn = true;
						txt.setText("X Turn");
						for(int j = 0; j < 81; j++) {
							btn[j].setEnabled(false);
						}
						
						//hard coded
							if (NorthWest.contains(i)) {
								btn[0].setEnabled(true);btn[1].setEnabled(true);btn[2].setEnabled(true);btn[9].setEnabled(true);btn[10].setEnabled(true);btn[11].setEnabled(true);btn[18].setEnabled(true);btn[19].setEnabled(true);btn[20].setEnabled(true);								
								
							}
							else if (North.contains(i)) {
								btn[3].setEnabled(true);btn[4].setEnabled(true);btn[5].setEnabled(true);btn[12].setEnabled(true);btn[13].setEnabled(true);btn[14].setEnabled(true);btn[21].setEnabled(true);btn[22].setEnabled(true);btn[23].setEnabled(true);
								
							}
							else if (NorthEast.contains(i)) {
								btn[6].setEnabled(true);btn[7].setEnabled(true);btn[8].setEnabled(true);btn[15].setEnabled(true);btn[16].setEnabled(true);btn[17].setEnabled(true);btn[24].setEnabled(true);btn[25].setEnabled(true);btn[26].setEnabled(true);
							}
							else if (West.contains(i)) {
								btn[27].setEnabled(true);btn[28].setEnabled(true);btn[29].setEnabled(true);btn[36].setEnabled(true);btn[37].setEnabled(true);btn[38].setEnabled(true);btn[45].setEnabled(true);btn[46].setEnabled(true);btn[47].setEnabled(true);
							}
							else if (Middle.contains(i)) {
								btn[30].setEnabled(true);btn[31].setEnabled(true);btn[32].setEnabled(true);btn[39].setEnabled(true);btn[40].setEnabled(true);btn[41].setEnabled(true);btn[48].setEnabled(true);btn[49].setEnabled(true);btn[50].setEnabled(true);
							}
							else if (East.contains(i)) {
								btn[33].setEnabled(true);btn[34].setEnabled(true);btn[35].setEnabled(true);btn[42].setEnabled(true);btn[43].setEnabled(true);btn[44].setEnabled(true);btn[51].setEnabled(true);btn[52].setEnabled(true);btn[53].setEnabled(true);
							}
							else if (SouthWest.contains(i)) {
								btn[54].setEnabled(true);btn[55].setEnabled(true);btn[56].setEnabled(true);btn[63].setEnabled(true);btn[64].setEnabled(true);btn[65].setEnabled(true);btn[72].setEnabled(true);btn[73].setEnabled(true);btn[74].setEnabled(true);
							}
							else if (South.contains(i)) {
								btn[57].setEnabled(true);btn[58].setEnabled(true);btn[59].setEnabled(true);btn[66].setEnabled(true);btn[67].setEnabled(true);btn[68].setEnabled(true);btn[75].setEnabled(true);btn[76].setEnabled(true);btn[77].setEnabled(true);
							}
							else if (SouthEast.contains(i)) {
								btn[60].setEnabled(true);btn[61].setEnabled(true);btn[62].setEnabled(true);btn[69].setEnabled(true);btn[70].setEnabled(true);btn[71].setEnabled(true);btn[78].setEnabled(true);btn[79].setEnabled(true);btn[80].setEnabled(true);
							}
					}		
				}
			}
			
		}
	}
}

