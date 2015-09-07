import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class EersteApplet extends Applet {
	public void paint( Graphics g ){
		int[] xBoppe = {140,200,100};
		int[] yBoppe = {0,60,60};
		
		int[] xRechtsOnder = {200,250,150};
		int[] yRechtsOnder = {60,120,120};
		
		int[] xLinksOnder = {100,150,50};
		int[] yLinksOnder = {60,120,120};
		
		g.setColor(Color.yellow);
		
		g.fillPolygon(xBoppe, yBoppe, 3);
		g.fillPolygon(xRechtsOnder, yRechtsOnder, 3);
		g.fillPolygon(xLinksOnder, yLinksOnder, 3);
	}
}