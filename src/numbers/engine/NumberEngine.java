package numbers.engine;

public class NumberEngine {
	private int randomNumber;
	private boolean checkWin = false;
	private String stringResult;
	
	public NumberEngine(){
	}
	
	public boolean getCheckWin(){
		return checkWin;
	}
	public void setRandomNumber(){
		randomNumber =(int)(Math.random()*100+1);
	}
	public int getRandomNumber(){
		return randomNumber;
	}
	public void setResult (String result){
		int intResult = Integer.parseInt(result);
		if(randomNumber == intResult){
			checkWin = true;//win
			stringResult = "Number is "+intResult;
		}else if(randomNumber < intResult){
			stringResult = "Numb. < "+intResult;//?<54
		}else if(randomNumber > intResult){
			stringResult = "Numb. > "+intResult;//?>54
		}
	}
	public String getResult(){
		return stringResult;
	}
	public void setResetCheckWin(){
		checkWin = false;
	}
}
