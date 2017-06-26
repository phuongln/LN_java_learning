package LNPaint;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// some colors
	private final int BLACK = 0, RED = 1, GREEN = 2, BLUE = 3, CYAN = 4, MAGENTA = 5, YELLOW = 6;
	private int currentColor = BLACK;
	// location of mouse
	private int preX, preY;
	// set it true when user dragging
	private boolean dragging;
	
	// draw user's curves
	private Graphics grapphicsfordrawing;

	// constructor to set background and listen to mouse events for itself
	PaintPanel() {
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int colorSpacing = (height - 86) / 7;

		// draw 3 pixels border
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, width - 1, height - 1);
		g.drawRect(1, 1, width - 3, height - 3);
		g.drawRect(2, 2, width - 5, height - 5);

		// fill for color palette and clear part
		g.fillRect(0, 0, 106, height);

		// draw CLEAR button

		g.setColor(Color.WHITE);
		g.fillRect(3, height - 83, 100, 80);
		g.setColor(Color.BLACK);
		g.drawRect(3, height - 83, 99, 79);
		g.drawString("CLEAR", 30, height - 40);

		// draw seven color rectangles
		g.setColor(Color.BLACK);
		g.fillRect(3, 3 + 0 * colorSpacing, 100, colorSpacing - 3);
		g.setColor(Color.RED);
		g.fillRect(3, 3 + 1 * colorSpacing, 100, colorSpacing - 3);
		g.setColor(Color.GREEN);
		g.fillRect(3, 3 + 2 * colorSpacing, 100, colorSpacing - 3);
		g.setColor(Color.BLUE);
		g.fillRect(3, 3 + 3 * colorSpacing, 100, colorSpacing - 3);
		g.setColor(Color.CYAN);
		g.fillRect(3, 3 + 4 * colorSpacing, 100, colorSpacing - 3);
		g.setColor(Color.MAGENTA);
		g.fillRect(3, 3 + 5 * colorSpacing, 100, colorSpacing - 3);
		g.setColor(Color.YELLOW);
		g.fillRect(3, 3 + 6 * colorSpacing, 100, colorSpacing - 3);

		// draw border of current color
		g.setColor(Color.WHITE);
		g.drawRect(1, 1 + currentColor * colorSpacing, 103, colorSpacing);
		g.drawRect(2, 2 + currentColor * colorSpacing, 101, colorSpacing - 2);
	}// done palette

	// change color method
	private void changeColor(int y) {
		int height = getHeight();
		int colorSpacing = (height - 86) / 7;

		int newColor = y / colorSpacing;

		if ((newColor < 0) || (newColor > 6)) {
			return;
		}

		Graphics g = getGraphics();
		g.setColor(Color.GRAY);
		g.drawRect(1, 1 + currentColor * colorSpacing, 103, colorSpacing);
		g.drawRect(2, 2 + currentColor * colorSpacing, 101, colorSpacing - 2);
		currentColor = newColor;
		g.setColor(Color.WHITE);
		g.drawRect(1, 1 + currentColor * colorSpacing, 103, colorSpacing);
		g.drawRect(2, 2 + currentColor * colorSpacing, 101, colorSpacing - 2);
		g.dispose();
	} // done change color

	
	// setup color for drawing
	private void setUpDrawingGraphics() {
		grapphicsfordrawing = getGraphics();
		switch (currentColor) {
		case BLACK:
			grapphicsfordrawing.setColor(Color.BLACK);
			break;
		case RED:
			grapphicsfordrawing.setColor(Color.RED);
			break;
		case GREEN:
			grapphicsfordrawing.setColor(Color.GREEN);
			break;
		case BLUE:
			grapphicsfordrawing.setColor(Color.BLUE);
			break;
		case CYAN:
			grapphicsfordrawing.setColor(Color.CYAN);
			break;
		case MAGENTA:
			grapphicsfordrawing.setColor(Color.MAGENTA);
			break;
		case YELLOW:
			grapphicsfordrawing.setColor(Color.YELLOW);
			break;
		}
	}// done setUpDrawing

	@Override
	public void mouseDragged(MouseEvent e) {
		if (dragging == false){    // when user do not press mouse, do nothing
			return;
		}
		int x = e.getX();   
        int y = e.getY();   
        
        if (x < 106)                          //if mouse go outside drawing area, go align with border
           x = 106;                           
        if (x > getWidth() - 4)       
           x = getWidth() - 4;
        
        if (y < 3)                          
           y = 3;                           
        if (y > getHeight() - 4)       
           y = getHeight() - 4;
        
        grapphicsfordrawing.drawLine(preX, preY, x, y);  //draw a line 
        
        preX = x;  //change mouse position to make user's curve consecutive
        preY = y;
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// if press mouse on special area leads to another action
		int x = e.getX();
		int y = e.getY();
		
		int height = getHeight();
		int width = getWidth();
	
		if (dragging == true){
			return;
		}
		if ( x < 106 ){
			if (y < height - 86){
				changeColor(y);
		} else {
			repaint();
		}
		} else if (x < width - 4 && y > 3 && y < height - 4){
			preX = x;   //set the very first position for drawing
			preY = y;
			dragging = true; // set condition to mouseDragging's action
			setUpDrawingGraphics(); //set current color
			
		}
		}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		if (dragging == false){    //if user's do not press the mouse, do nothing
			return;
		}
		dragging = false;  //after pressed at drawing area, dragging be true, but then 
		                    //set it false to end drawing when release mouse
		grapphicsfordrawing.dispose(); //release graphics unused
		grapphicsfordrawing = null; 
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
