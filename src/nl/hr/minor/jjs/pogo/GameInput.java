package nl.hr.minor.jjs.pogo;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.MovementMethod;
import android.util.Log;

public class GameInput implements SensorEventListener {

	private Player _player;
	private SensorManager sm;
	private long lastMoveTime = System.currentTimeMillis();
	private long freeToMoveTime;
	
	public GameInput(Player playerToControll) {
		
		// Set player to controll
		_player = playerToControll;
		
		// Get main context
		ContextHolder ch = ContextHolder.getInstance();
		Activity mainContext = ch.getContext();
		
		sm = (SensorManager)mainContext.getSystemService(Context.SENSOR_SERVICE);
		sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {
		
		// Prevent this event from running any further if the last move was within 500ms
		freeToMoveTime = lastMoveTime + 500;
		if(System.currentTimeMillis() < freeToMoveTime){
			return;
		}
		
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
        
        // Determine direction
        int direction;
        if(movementX > 1){
        	direction = 1; // Left
        } else if (movementX < -1){
        	direction = 2; // Right 
        } else if (movementY > 1){
        	direction = 3; // Up
        } else if (movementY < -1){
        	direction = 4; // Down
        } else {
        	direction = -1; // None
        }
        
        // Change player direction (get user object from singleton or something...)
        //Log.w("Movement", "X: " + movementX);
        //Log.w("Movement", "Y: " + movementY);
        //Log.w("Movement", "Direction: " + direction);
        
        _player.move(direction);
        lastMoveTime = System.currentTimeMillis();
        
	}
	
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

}
