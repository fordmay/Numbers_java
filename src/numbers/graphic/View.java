package numbers.graphic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import resource.ResourceLoader;

/**
 * @author   Dmitriy Zheliabin <d.u.zheliabin@gmail.com>
 * @version  1.0
 * @since 	 11.05.2015
 */
public class View extends JFrame{
	private static final long serialVersionUID = 1988;
	protected JPanel panel_1;
	protected JPanel panel_2;
	protected JPanel panel_3;
	protected JTextArea textArea;
	protected JLabel textLabel;
	protected JButton[] buttons;

	View(){		
		setSize(382,382);
		setLocationRelativeTo(null);
		setResizable(false);
		
		getMenu();
		getTextLabel();
		getTextPanel();
		setButton();
	}
	private void getMenu(){
		//создаем меню
		JMenuBar menuBar = new JMenuBar();
		//создаем кнопку "File"
		JMenu fileMenu = new JMenu(" File ");
		//клавиша быстрого доступа
		fileMenu.setMnemonic('F');
		menuBar.add(fileMenu);
		//создаем подменю
		JMenuItem newGame = new JMenuItem("New Game", 'N');
		JMenuItem selectColor = new JMenuItem("Selector color", 'S');
		JMenuItem exitProg = new JMenuItem("Exit", 'E');
		//создаем хот-кей
		newGame.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		exitProg.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
		fileMenu.add(newGame);
		fileMenu.add(selectColor);
		fileMenu.addSeparator();//разделительная линия
		fileMenu.add(exitProg);
		//действия кнопок при нажатии
		newGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				setNewGame();
			}
		});
		selectColor.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				Color defaultColor = panel_1.getBackground();
				Color selected = JColorChooser.showDialog(rootPane, "Background Color", defaultColor);
				if(selected!=null){
					panel_1.setBackground(selected);
					panel_2.setBackground(selected);
					panel_3.setBackground(selected);
				}
			}
		});		
		exitProg.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});

		//создаем кнопку меню "Help"
		JMenu helpMenu = new JMenu(" Help ");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
		JMenuItem aboutItem = new JMenuItem("About", 'A');
		//создаем пиктограмку
		aboutItem.setIcon(new ImageIcon(ResourceLoader.loadImage("Very-Basic-About-icon.png")));
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				JOptionPane.showMessageDialog(rootPane,
						"Created by D.U.Zheliabin"+"\nd.u.zheliabin@gmail.com",
						"About program",JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(ResourceLoader.loadImage("working_en.gif")));
			}
		});
		setJMenuBar(menuBar);
	}
	private void getTextLabel(){
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(109,207,246));
		panel_1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK), "Screen"));
		panel_1.setPreferredSize(new Dimension(NORMAL, 70));
		panel_1.setLayout(new GridLayout(1,1));
		textLabel = new JLabel("",SwingConstants.CENTER);
		textLabel.setFont(new Font(null, Font.BOLD, 18));
		panel_1.add(textLabel);
		add(panel_1, BorderLayout.NORTH);
	}
	private void getTextPanel(){
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(109,207,246));
		textArea = new JTextArea(13,12);
		textArea.setFont(new Font(null, Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setFocusable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		panel_2.add(scroll);
		add(panel_2, BorderLayout.WEST);
	}
	private void setButton(){
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(109,207,246));
		//бесцветная рамка для создания растояния по краям
		panel_3.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 5));
		panel_3.setLayout(new GridLayout( 4, 3, 3, 3));
		buttons = new JButton[12];
		for(int i=0; i<buttons.length; i++){
			if(i==10){
				buttons[i] = new JButton("Clean");
				buttons[i].setEnabled(false);
				buttons[i].setFocusable(false);
				buttons[i].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent aEvent){
						useButton_clean();
					}
				});
			}else if(i==11){
				buttons[i] = new JButton("OK");
				buttons[i].setEnabled(false);
				buttons[i].setFocusable(false);
				buttons[i].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent aEvent){
						useButton_OK();
					}
				});
			}else{
				buttons[i] = new JButton(""+i);
				buttons[i].addActionListener(new ActionListener(){			
					@Override
					public void actionPerformed(ActionEvent aEvent){
						String input = aEvent.getActionCommand();
						int number = Integer.parseInt(input);
						useButton_Number(input, buttons[number]);
					}
				});
			}
		}
		panel_3.add(buttons[7]);
		panel_3.add(buttons[8]);
		panel_3.add(buttons[9]);
		
		panel_3.add(buttons[4]);
		panel_3.add(buttons[5]);
		panel_3.add(buttons[6]);
		
		panel_3.add(buttons[1]);
		panel_3.add(buttons[2]);
		panel_3.add(buttons[3]);
		
		panel_3.add(buttons[10]);
		panel_3.add(buttons[0]);
		panel_3.add(buttons[11]);
	
		add(panel_3);
	}
	protected void useButton_Number(String nameButton, JButton button){}
	protected void useButton_clean(){}
	protected void useButton_OK(){}
	protected void setNewGame(){}
	
}
