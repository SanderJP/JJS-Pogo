package nl.hr.minor.jjs.pogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Color;
import android.os.Handler;
import android.util.Log;

public class PowerupManager {

	
	private Map<Integer, Tile> _tiles;
	
	// Timer related variables
	TimerTask puTask;
	final Handler handler = new Handler();
	Timer t = new Timer();
	
	// Define interval for different powerups/boxes
	private int intervalCheckBox = 6000; // Every 8 seconds -> 15 each game (90 seconds)
	
	public PowerupManager(Map<Integer, Tile> map) {
		
		_tiles = map;
		
	}
	
	public void start(){
		
		final PowerupManager self = this;
		
		puTask = new TimerTask() {
	        public void run() {
			handler.post(new Runnable() {
					public void run() {

						// Find a random tile to set a powerup
						Random random = new Random();
						ArrayList<Integer> keys = new ArrayList<Integer>(_tiles.keySet());
						Integer randomKey = keys.get( random.nextInt(_tiles.size()) );
						Tile puTile = _tiles.get(randomKey);

						
						// Set powerup type and color of this tile
						puTile.setPowerupType("checkin");
						puTile.setColor(Color.WHITE);
						
						// Currently only supports poweruptype 'checkin'.
						// A switch/ifelse should be placed here for other types of powerups
						// You may want to user different time intervals too

						
						//Log.w("PU TILE", "At tile: " + createPuAtTile);
						
					}
				});
	        }
	    };
	        
		t.scheduleAtFixedRate(puTask, intervalCheckBox/2, intervalCheckBox);
	}
	
	public static int getPointsForPowerupType(String powerupType, Player p, Map<Integer, Tile> map){
		
		// Determine powerup type
		if(powerupType.equals("checkin")){
			
			Tile tile;
			int tileColor;
			int playerColor;
			int matchingTiles = 0;
			
			// Calculate score based on tiles in the color of this player
			for(Integer tileKey : map.keySet()){
				
				tile = map.get(tileKey);
				
				tileColor = tile.getColor();
				playerColor = p.getDrawColor();
				
				// Compare tilecolor and the color of the player
				if(tileColor == playerColor){
					// If colors match; add a point
					matchingTiles++;
					
					// Set back the default color for this tile
					tile.setColor(tile.getDefaultColor()); 
				}
				
			}			
			
			return matchingTiles; // Static for testing now
			
		}else if(powerupType.equals("someotherpowerup")){
			
		}
		
		// Remove the powerup from the tiles
		
		
		// In any other case... still give 1 point.
		return 1;
	}

}
