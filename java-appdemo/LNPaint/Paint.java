package LNPaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paint extends JFrame {
	public static void main(String[] args) {
		JFrame window = new JFrame("Paint");
		PaintPanel content = new PaintPanel();
		window.setContentPane(content);
		window.setBounds(0, 0, 600, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setVisible(true);
	}
}

