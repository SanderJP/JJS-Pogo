package nl.hr.minor.jjs.pogo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

public class GamePogo extends Activity {

	private GameView _gv;
	private boolean _gamePaused = false;
	private String _activityOrientation = "landscape";
	
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
	
	private void flipOrientation(){
		if(_activityOrientation == "portrait"){
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			_activityOrientation = "landscape";
		} else {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			_activityOrientation = "portrait";
		}
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.gameoptions, menu);
    	return true;
    } 

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
		    case R.id.flipOrientation:
		    	this.flipOrientation();
		    return true;
	    }
	    return false;
    }
	
	
}
