package nl.hr.minor.jjs.pogo;

import java.util.Hashtable;
import java.util.Map;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

public class GameView extends View {
	
	private int _fieldSize = 7; // = 8 tiles (0-7)
	private Map<Integer, Tile> _tiles = new Hashtable<Integer, Tile>();

	public GameView(Context context) {
		super(context);
		
		// rows are 10,20,30 etc
		for (int a = 0; a <= (_fieldSize*10); a+=10) {
			// columns are 1,2,3 etc
			for (int b = 0; b <= _fieldSize; b++) {
				// id is row(2) + column(4) = 24
				int id = a+b;
				_tiles.put(id, new Tile(id));
			}
		}
	}

	@Override
	protected void onDraw(Canvas canvas){
		// iterate through keys
		for (int id : _tiles.keySet()) {
	    	// draw Tile
			_tiles.get(id).draw(canvas);
		}
		invalidate();
	}
}
