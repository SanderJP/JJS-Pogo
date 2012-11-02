package nl.hr.minor.jjs.pogo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Countdown {

	private int gameTime = 90000;
	private Paint p;
	
	public Countdown() {
		
		p = new Paint();
		p.setColor(Color.WHITE);
		p.setAlpha(200);
		p.setTextSize(20);
		//p.setStyle(style);
		
		new CountDownTimer(gameTime, 1000) {
	         public void onTick(long msUntilFinished){

	        	 gameTime -= 1000;
	             
	         }
	         public void onFinish(){
	        	 // Do something when game is finished
	        	 // (Calculate score etc.)
	        	 
	         }
	      }.start();
	      
	}
	
	public void draw(Canvas c){
		c.drawText("Time left: " + (gameTime/1000), 15, 15, p);
	}

}
