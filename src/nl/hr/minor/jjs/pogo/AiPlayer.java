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
	
	private int _minLimit = 1;
	private int _maxLimit = 4;
	
	private int _moveInternal = 300; // Movement delay in ms
	private int _delayBeforeFirstMove = 1500; // in ms
	
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
						int goTo = _minLimit + (int) (Math.random() * ((_maxLimit - _minLimit) + 1));
						self.move(goTo);
						//Log.w("AiPlayer", "AiP " + self._id + " moved to: " + goTo);
					}
				});
	        }
	    };
	        
		t.scheduleAtFixedRate(moveTask, _delayBeforeFirstMove, _moveInternal);
		
	}

}
