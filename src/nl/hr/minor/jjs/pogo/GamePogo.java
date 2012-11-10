package nl.hr.minor.jjs.pogo;

import android.app.Activity;
import android.os.Bundle;

public class GamePogo extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Set the current context (this) in the 'singleton' contextHolder.
        ContextHolder ch = ContextHolder.getInstance();
        ch.setContext(this);
        
        setContentView(new GameView(this));
    }
}
