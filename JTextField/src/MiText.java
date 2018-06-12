import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

import com.mxrck.autocompleter.TextAutoCompleter;

public class MiText extends JTextField implements MouseListener{
	
private Color colorHover = new Color(255,255,204);//AmarilloReducido
private Color colorNormal = new Color(255,255,0);//Amarillo
private Color colorTextoHover = new Color(0,0,0);//Negro
private Color colorTextoNormal = new Color(153,153,153);//Gris
private Color colorPresionar = new Color(255,255,255);//Blanco

public MiText(){
	this.setOpaque(true);
	this.setBorder(BorderFactory.createLineBorder(Color.black));
	this.setBackground(new Color(255,255,0));//Amarillo
	this.setForeground(new Color (153,153,153));//GRis
	this.setHorizontalAlignment(JTextField.CENTER);
	this.setFont(new Font("Tahoma", Font.BOLD, 15));
	this.setCursor(new Cursor(12));
    this.setPreferredSize(new Dimension(200,30));
    this.setSize(200,30);
    addMouseListener(this);
 }


@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	this.setBackground(this.colorHover);//AmariiloReducido
	this.setForeground(this.colorTextoHover);//Negro
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	this.setBackground(this.colorNormal);//Amarillo
	this.setForeground(this.colorTextoNormal);//Gris
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	this.setBackground(this.colorPresionar);//Blanco
}

public Color getColorHover() {
	return colorHover;
}

public void setColorHover(Color colorHover) {
	this.colorHover = colorHover;
}

public Color getColorNormal() {
	return colorNormal;
}

public void setColorNormal(Color colorNormal) {
	this.colorNormal = colorNormal;
}

public Color getColorTextoHover() {
	return colorTextoHover;
}

public void setColorTextoHover(Color colorTextoHover) {
	this.colorTextoHover = colorTextoHover;
}

public Color getColorTextoNormal() {
	return colorTextoNormal;
}

public void setColorTextoNormal(Color colorTextoNormal) {
	this.colorTextoNormal = colorTextoNormal;
 }
}