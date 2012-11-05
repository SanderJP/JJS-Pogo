package nl.hr.minor.jjs.pogo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class ScoreDisplay {

	private Paint _p;
	private Map<Integer, Player> _playerlist;
	private String _scoreText;
	private Player _player;
	
	public ScoreDisplay(Map<Integer, Player> playerlist) {
		
		_playerlist = playerlist;
		
		_p = new Paint();
		_p.setColor(Color.WHITE);
		_p.setAlpha(200);
		_p.setTextSize(18);
		
	}
	
	public void draw(Canvas c){
		
		_scoreText = "";
		
		// Display scores
		// Todo: Change sorting order. For some reason they don't order correctly (4-1-2-3 instead of 1-2-3-4)
		for(Integer playerIndex : _playerlist.keySet()){
			
			_player = _playerlist.get(playerIndex);
			_scoreText += "Player " + _player._id + ": " + _player.getScore() + " - ";
		}
		
		c.drawText(_scoreText, 10, 460, _p);
	}

}
