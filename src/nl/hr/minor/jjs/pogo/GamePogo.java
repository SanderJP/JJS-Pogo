package nl.hr.minor.jjs.pogo;

import android.app.Activity;
import android.os.Bundle;

public class GamePogo extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(new GameView(this));
        
    }

}
