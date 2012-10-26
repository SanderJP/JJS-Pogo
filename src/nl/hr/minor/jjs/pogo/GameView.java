package nl.hr.minor.jjs.pogo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

public class GameView extends View {
	
	private int _fieldSize = 7; // = 8 tiles (0-7)
	private Map<Integer, Tile> _tiles = new Hashtable<Integer, Tile>();
	private Map<Integer, Player> _playerList = new Hashtable<Integer, Player>();

	public GameView(Context context) {
		super(context);
		
		// Build level map - rows are 10,20,30 etc
		for (int a = 0; a <= (_fieldSize*10); a+=10) {
			// columns are 1,2,3 etc
			for (int b = 0; b <= _fieldSize; b++) {
				// id is row(2) + column(4) = 24
				int id = a+b;
				_tiles.put(id, new Tile(id));
			}
		}
		
		// Build players
		
		// First player is controlled by the user
		_playerList.put(1, new Player(1, 1, _tiles));
		
		// Link the GameInput to the first player
        GameInput gi = new GameInput(_playerList.get(1));
		
		// Other 3 are computer controlled
        //_playerList.put(2, new AiPlayer(1, 1));
        //_playerList.put(3, new AiPlayer(1, 1));
        //_playerList.put(4, new AiPlayer(1, 1));
		
	}

	@Override
	protected void onDraw(Canvas canvas){
		// iterate through keys for drawing level map
		for (int id : _tiles.keySet()) {
	    	// draw Tile
			_tiles.get(id).draw(canvas);
		}
		
		
		// Iterate over players and draw them
		for (int id : _playerList.keySet()) {
	    	// draw player
			_playerList.get(id).draw(canvas);
		}
		
		// Invalidate the view (redraw)
		invalidate();
	}
}
