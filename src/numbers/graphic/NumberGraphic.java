package numbers.graphic;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import resource.ResourceLoader;
import numbers.engine.NumberEngine;

/**
 * @author   Dmitriy Zheliabin <d.u.zheliabin@gmail.com>
 * @version  1.0
 * @since 	 23.05.2015
 */
public class NumberGraphic extends View {
	private static final long serialVersionUID = 1988;
	private int checkButton_Number = 0;
	private int id = 0;
	private String text = "The number is already generated.";
	private NumberEngine numbEng;
	public NumberGraphic(){
		super();
		setTitle("Numbers");
		setIconImage(ResourceLoader.loadImage("Numbers-icon.png"));
		numbEng = new NumberEngine();
		numbEng.setRandomNumber();
//		text = "" + numbEng.getRandomNumber();//перевірка, Видалити
		textLabel.setText(text);
	}
	@Override
	protected void useButton_Number(String nameButton, JButton button){
		if(text.equals(textLabel.getText())){
			textLabel.setText("");
		}
		textLabel.setText(textLabel.getText() + nameButton);
		setEnabledButton_OK_clean(true);
		checkButton_Number++;
		if(checkButton_Number>=2){
			setButtonEnable(false);
		}
		if(textLabel.getText().equals("10")){
			buttons[0].setEnabled(true);
			buttons[0].setFocusable(true);
		}
	}
	@Override
	protected void useButton_clean(){
		setEnabledButton_OK_clean(false);
		textLabel.setText("");
		setButtonEnable(true);
		checkButton_Number = 0;
	}
	@Override
	protected void useButton_OK(){
		numbEng.setResult(textLabel.getText());
		String numbID = (++id)<10 ? "   "+id : " "+id;
		textArea.setText(textArea.getText()+numbID+"  -  "+numbEng.getResult()+"\n");
		textLabel.setText("");
		checkButton_Number = 0;
		if(numbEng.getCheckWin()){
			setButtonEnable(false);
			JOptionPane.showMessageDialog(rootPane,"You Win!\n"+numbEng.getResult(),
					"Result",JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(ResourceLoader.loadImage("win.png")));
			textLabel.setText("You Win!!!");
		}else{
			setButtonEnable(true);
			text = "Try to guess!";
			textLabel.setText(text);
		}
		setEnabledButton_OK_clean(false);
	}
	@Override
	protected void setNewGame(){
		numbEng.setResetCheckWin();
		numbEng.setRandomNumber();
//		text = "" + numbEng.getRandomNumber();//перевірка, Видалити
		textLabel.setText(text);
		textArea.setText("");
		setButtonEnable(true);
	}
	private void setButtonEnable(boolean check){
		for(int i=0; i<buttons.length-2;i++){
			buttons[i].setEnabled(check);
			buttons[i].setFocusable(check);
		}
	}
	private void setEnabledButton_OK_clean(boolean check){
		buttons[10].setEnabled(check);
		buttons[10].setFocusable(check);
		buttons[11].setEnabled(check);
		buttons[11].setFocusable(check);
	}
}
