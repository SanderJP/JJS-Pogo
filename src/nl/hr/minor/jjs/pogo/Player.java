package nl.hr.minor.jjs.pogo;

import java.util.Map;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class Player {

	public int _id;
	private int _teamId;
	private int _score;
	private int _name; // Optional (may be used later)
	private Map<Integer, Tile> _map;
	public int _colorFill = Color.GREEN;
	
	private int _size = 50;
	private int _margin = 5;
	
	private int _posX = _size/2;
	private int _posY = _size/2;
	private int _currentTile = 1;
	
	private int _color = Color.BLACK;
	private Paint _paint = new Paint();
	
	private String _powerupType = "";
	
	public Player(int id, int teamId, Map<Integer, Tile> map, Integer color){
		_id = id;
		_teamId = teamId;
		_map = map;
		_colorFill = color;
		_score = 0;
	}

	public void move(int direction){
		int _tmpOldTile = _currentTile;
		
		if(direction == 1){ // Left
			_currentTile--;
		}else if (direction == 2){ // Right
			_currentTile++;
        } else if (direction == 3){ // Up
        	_currentTile+=10;
        } else if (direction == 4){ // Down
        	_currentTile-=10;
        }
		
		// Check if this map tile exists
		if(_map.containsKey(_currentTile)){
    		_map.get(_currentTile).setColor(_colorFill);
    		
    		// Change player self
    		int tileX = _map.get(_currentTile).getX();
    		int tileY = _map.get(_currentTile).getY();
    		
    		// Calculate player position on current tile
    		_posX = (tileX*_size) + (_margin*tileX) + (_size/2);
    		_posY = (tileY*_size) + (_margin*tileY) + (_size/2);
    		
    		// Check if the current tile has a powerup
    		_powerupType = _map.get(_currentTile).getPowerupType();
    		
    		// Only calculate score and add points if this tile has a powerup
    		if(_powerupType != null && !_powerupType.equals("none")){
	    		
    			// Get number of points for this type of powerup
    			int pointsForPu = PowerupManager.getPointsForPowerupType(_powerupType, this, _map);
	    		
	    		// Add score for this player
	    		this.addScore(pointsForPu);
	    		
	    		// Remove this powerup from the field (change its powerupType and color back to default)
	    		_map.get(_currentTile).setPowerupType("none");
	    		_map.get(_currentTile).setColor(_map.get(_currentTile).getDefaultColor());
	    		
    		}
    		
    	} else {
    		// Player tries to go out of map bounds; set currenTile back to what it was
    		_currentTile = _tmpOldTile;
    	}
		
		// Todo: Optional collision detection between all players

		
	}
	
	public void draw(Canvas cv){
		
		int posX = (_posX > 0) ? (_posX*_size)+(_margin*_posX) : _posX;
		int posY = (_posY > 0) ? (_posY*_size)+(_margin*_posY) : _posY;
		// set the color
		_paint.setColor(_color);
		// draw it
		cv.drawCircle(_posX, _posY, _size/2, _paint);
		
	}
	
	public int getScore(){
		return _score;
	}
	
	public void addScore(int points){
		_score += points;
		//Log.w("Score", "Player " + _id + " score: " + _score);
	}
	
	private void setScore(int points){
		_score = points;
	}
	
	public int getDrawColor(){
		return _colorFill;
	}
	
}
