package nl.hr.minor.jjs.pogo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class Tile {
	
	private int _posX;
	private int _posY;
	private int _size = 50;
	private int _margin = 5;
	
	private int _color = Color.RED;
	private Paint _paint = new Paint();
	
	public Tile(int id) {
		// get row position first
		_posY = (int)Math.floor(id/10);
		// remove row number to get column number
		_posX = id-(_posY*10);
	}
	
	public void draw(Canvas canvas) {
		// if pos is first x or y, don't use margin
		// otherwise add margin times the row/column number to add margins
		int posX = (_posX > 0) ? (_posX*_size)+(_margin*_posX) : _posX;
		int posY = (_posY > 0) ? (_posY*_size)+(_margin*_posY) : _posY;
		// make rectangle
		Rect r = new Rect(posX, posY, posX+_size, posY+_size);
		// set the color
		_paint.setColor(_color);
		// draw it
		canvas.drawRect(r, _paint);
	}
	
	public void setColor(int c) {
		// change color
		_color = c;
	}
	
	public int getX(){
		return _posX;
	}
	
	public int getY(){
		return _posY;
	}
}
