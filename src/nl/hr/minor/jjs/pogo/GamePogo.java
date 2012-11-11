package nl.hr.minor.jjs.pogo;

import android.app.Activity;
import android.os.Bundle;

public class GamePogo extends Activity {

	private GameView _gv;
	private boolean _gamePaused = false;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Set the current context (this) in the 'singleton' contextHolder.
        ContextHolder ch = ContextHolder.getInstance();
        ch.setContext(this);
        
        _gv = new GameView(this);
        setContentView(_gv);
    }

	@Override
	protected void onDestroy() {
		
		super.onDestroy();
		this.finish(); // Stops activity
		
	}

	@Override
	protected void onPause() {		
		// Pause everything on the gameview
		_gv.pause();
		
		_gamePaused = true;
		
		super.onPause();
	}

	@Override
	protected void onResume() {
		
		super.onResume();
		
		// Only resume if game was paused
		if(_gamePaused){
			// Start everything up again on the gameview
			_gv.resume();
		}
		
	}
}
