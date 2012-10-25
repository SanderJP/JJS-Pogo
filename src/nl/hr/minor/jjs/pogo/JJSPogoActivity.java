package nl.hr.minor.jjs.pogo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class JJSPogoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Set the current context (this) in the 'singleton' contextHolder.
        ContextHolder ch = ContextHolder.getInstance();
        ch.setContext(this);
        
        Intent i = new Intent(this, GamePogo.class);
        startActivity(i);
    }
}