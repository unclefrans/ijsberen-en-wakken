import java.applet.Applet;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonEins extends Applet implements ActionListener {	
	Button Button1, Button2, ResetButton;
	TextField Naam, Leeftijd, Plaats;
	
	public void init(){
		setLayout(null);
		Button1 = new Button("Button1");
		Button1.setBounds(10,10,90,20);
		Button1.addActionListener(this);
		
		Button2 = new Button("Button2");
		Button2.setBounds(10,32,90,20);
		Button2.addActionListener(this);
		
		ResetButton = new Button("Reset");
		ResetButton.setBounds(10,54,90,20);
		ResetButton.addActionListener(this);

		Naam = new TextField();
		Naam.setBounds(104,10,90,20);	
		Leeftijd = new TextField(5);
		Leeftijd.setBounds(196,10,90,20);
		Plaats = new TextField(5);
		Plaats.setBounds(288,10,90,20);
	
		add(Button1);
		add(Button2);
		add(ResetButton);
		
		add(Naam);
		add(Leeftijd);
		add(Plaats);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == Button1){
			Naam.setText("Naam1");
			Leeftijd.setText("Leeftijd1");
			Plaats.setText("Plaats1");
		}
		if(e.getSource() == Button2){
			Naam.setText("Naam2");
			Leeftijd.setText("Leeftijd2");
			Plaats.setText("Plaats2");
		}
		if(e.getSource() == ResetButton){
			Naam.setText("");
			Leeftijd.setText("");
			Plaats.setText("");
		}
	}
}

