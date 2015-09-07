import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Applet implements ActionListener{	
	private static final long serialVersionUID = 1L;
	Button Check, Novice, Journeyman, Expert;
	TextField inputHoles, inputPenguins, inputPolarbears, CheckTF;
	int randomDice, aantalStenen, totalHole, totalPenguin, totalPolarbear, Wrong, Correct, tries;
	
	public void init(){
		setSize(980, 250);
		setLayout(null); 
		
		Check = new Button("Check");
		Check.setBounds(10, 90, 90, 20);
		Check.addActionListener(this);	
		CheckTF = new TextField(5);
		CheckTF.setBounds(110, 91, 90, 20);	
		
		Novice = new Button("Novice");
		Novice.setBounds(10, 140, 90, 20);
		Novice.addActionListener(this);				
		Journeyman = new Button("Journeyman");
		Journeyman.setBounds(10, 162, 90, 20);
		Journeyman.addActionListener(this);			
		Expert = new Button("Expert");
		Expert.setBounds(10, 184, 90, 20);
		Expert.addActionListener(this);		
		
		inputHoles = new TextField(5);
		inputHoles.setBounds(200, 140, 20, 20);		
		inputPenguins = new TextField(5);
		inputPenguins.setBounds(200, 162, 20, 20);		
		inputPolarbears = new TextField(5);
		inputPolarbears.setBounds(200, 184, 20, 20);	
		
		add(Check);
		add(Novice);
		add(Journeyman);
		add(Expert);      
		add(inputHoles);
		add(inputPenguins);
		add(inputPolarbears);
		add(CheckTF);
		
		Check.setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == Check){	
			checkAnswer();
		}
		else if(e.getSource() == Novice){
			Check.setEnabled(true);
			aantalStenen = 3;
			disableDifficultyButtons();
			clearTotal();
			repaint();
		}
		else if(e.getSource() == Journeyman){
			Check.setEnabled(true);
			aantalStenen = 6;
			disableDifficultyButtons();
			clearTotal();
			repaint();
		}
		else if(e.getSource() == Expert){
			Check.setEnabled(true);
			aantalStenen = 12;
			disableDifficultyButtons();
			clearTotal();
			repaint();
		}
		else{
			clearTotal();
		}
	}

	public void paint(Graphics g){
		g.drawString("Hole(s) to fish in." , 225, 160);
		g.drawString("Penguin(s) on the other side." , 225, 180);
		g.drawString("Polar Bear(s) fishing." , 225, 200);
		g.drawString("Correct: " +Correct, 500, 160);
		g.drawString("Wrong: " +Wrong, 500, 175);
		g.drawString("Choose your difficulty:", 10, 135);
		g.drawString("Fill in your answer:", 200, 135);
		loopDice(g);
	}	

	public void loopDice(Graphics g){
		CheckTF.setBackground(Color.WHITE);
		CheckTF.setText("");
		resettextFields();
		int x = 0;		
		for(int i = 0; i < aantalStenen; i++){
			randomDice = (int)(Math.random()*(6) + 1);
			drawDice(g, x);
			g.drawRoundRect(10+x, 10, 70, 70, 12, 12);
			x += 80;
			calculateAnswer Answer = new calculateAnswer(randomDice);
			totalHole += Answer.getAmountHoles();
			totalPenguin += Answer.getAmountPinguins();
			totalPolarbear += Answer.getAmountPolarBears();
		}
	}
	
	public void drawDice(Graphics g, int x){
		switch(randomDice){
		case 1:	//Dice 1:	
			g.fillOval(40+x, 40, 12, 12);
			break;
		case 2:	//Dice 2:
			g.fillOval(20+x, 20, 12, 12);
			g.fillOval(60+x, 60, 12, 12);	
			break;
		case 3:	//Dice 3:
			g.fillOval(20+x, 20, 12, 12);
			g.fillOval(40+x, 40, 12, 12);
			g.fillOval(60+x, 60, 12, 12);	
			break;
		case 4:	//Dice 4:
			g.fillOval(20+x, 20, 12, 12);
			g.fillOval(20+x, 60, 12, 12);	
			g.fillOval(60+x, 20, 12, 12);
			g.fillOval(60+x, 60, 12, 12);
			break;
		case 5:	//Dice 5:
			g.fillOval(20+x, 20, 12, 12);
			g.fillOval(20+x, 60, 12, 12);	
			g.fillOval(40+x, 40, 12, 12);
			g.fillOval(60+x, 20, 12, 12);
			g.fillOval(60+x, 60, 12, 12);
			break;
		case 6:	//Dice 6:
			g.fillOval(20+x, 20, 12, 12);
			g.fillOval(20+x, 40, 12, 12);
			g.fillOval(20+x, 60, 12, 12);		
			g.fillOval(60+x, 20, 12, 12);
			g.fillOval(60+x, 40, 12, 12);
			g.fillOval(60+x, 60, 12, 12);	
			break;	
		}
	}

	public void clearTotal(){
		tries = 0;
		totalHole = 0;
		totalPenguin = 0;
		totalPolarbear = 0;
	}
	
	public void disableDifficultyButtons(){
		Novice.setEnabled(false);
		Journeyman.setEnabled(false);
		Expert.setEnabled(false);
	}
	
	public void enableDifficultyButtons(){
		Novice.setEnabled(true);
		Journeyman.setEnabled(true);
		Expert.setEnabled(true);	
	}
	
	public void resettextFields(){
		inputHoles.setText("0");
		inputPenguins.setText("0");
		inputPolarbears.setText("0");
	}
	
	public void checkAnswer(){
		int h = Integer.parseInt(inputHoles.getText());		
		int p = Integer.parseInt(inputPenguins.getText());
		int b = Integer.parseInt(inputPolarbears.getText());	
		if(totalHole == h && totalPenguin == p && totalPolarbear == b){		
			Correct ++;
			CheckTF.setBackground(Color.GREEN);
			CheckTF.setText("Correct!");
			Check.setEnabled(false);
			enableDifficultyButtons();			
			resettextFields();			
			clearTotal();
		}
		else{
			CheckTF.setBackground(Color.RED); 
			CheckTF.setText("Wrong!");
			tries ++; 
			if(tries == 3){
				Wrong ++;
				CheckTF.setText("No more tries!");
				Check.setEnabled(false);
				enableDifficultyButtons();
				resettextFields();			
				clearTotal();
			}
		}
	}	
}