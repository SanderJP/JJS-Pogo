package nl.hr.minor.jjs.pogo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Countdown {

	private int _gameTime = 90000;
	private Paint _p;
	
	public Countdown() {
		
		_p = new Paint();
		_p.setColor(Color.WHITE);
		_p.setAlpha(200);
		_p.setTextSize(20);
		//p.setStyle(style);
		
		new CountDownTimer(_gameTime, 1000) {
	         public void onTick(long msUntilFinished){

	        	 _gameTime -= 1000;
	             
	         }
	         public void onFinish(){
	        	 // Do something when game is finished
	        	 // (Calculate score etc.)
	        	 
	         }
	      }.start();
	      
	}
	
	public void draw(Canvas c){
		c.drawText("Time left: " + (_gameTime/1000), 10, 25, _p);
	}

}
