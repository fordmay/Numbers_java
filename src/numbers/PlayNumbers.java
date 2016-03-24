package numbers;

import java.awt.EventQueue;

import javax.swing.JFrame;

import numbers.graphic.NumberGraphic;

public class PlayNumbers {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				NumberGraphic NGrap = new NumberGraphic();
				NGrap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				NGrap.setVisible(true);
			}
		});
	}
}
