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
        
        Intent i = new Intent(this, GamePogo.class);
        startActivity(i);
    }
}