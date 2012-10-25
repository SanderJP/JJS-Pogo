package nl.hr.minor.jjs.pogo;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class GameInput implements SensorEventListener {

	private SensorManager sm;
	
	public GameInput() {
		
		// Get main context
		ContextHolder ch = ContextHolder.getInstance();
		Activity mainContext = ch.getContext();
		
		sm = (SensorManager)mainContext.getSystemService(Context.SENSOR_SERVICE);
		sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {
		
		float a = 0;
		float b = 0;
		float c = 0;
		
		if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			 a = sensorEvent.values[0];
			 b = sensorEvent.values[1];
			 c = sensorEvent.values[2];
		}
        
        int movementX = (int) a;
        int movementY = (int) b;
        
        // Change player direction (get user object from singleton or something...)
        Log.w("Movement", "X: " + movementX);
        Log.w("Movement", "Y: " + movementY);
		
	}
	
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

}
