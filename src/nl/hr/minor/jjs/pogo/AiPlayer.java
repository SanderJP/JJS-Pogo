package nl.hr.minor.jjs.pogo;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.util.Log;

public class AiPlayer extends Player {

	TimerTask moveTask;
	final Handler handler = new Handler();
	Timer t = new Timer();
	
	int minLimit = 1;
	int maxLimit = 4;
	
	public AiPlayer(int id, int teamId, Map<Integer, Tile> map, Integer color) {
		super(id, teamId, map, color);
	}
	
	public void startAi(){
		// Start players auto intelligence
		
		final AiPlayer self = this;
		
		moveTask = new TimerTask() {
	        public void run() {
			handler.post(new Runnable() {
					public void run() {
						int goTo = minLimit + (int) (Math.random() * ((maxLimit - minLimit) + 1));
						self.move(goTo);
						Log.w("AiPlayer", "AiP " + self._id + " moved to: " + goTo);
					}
				});
	        }
	    };
	        
		t.scheduleAtFixedRate(moveTask, 2000, 500);
		
	}

}
