package com.jgames.lightspeed.input;

import com.badlogic.gdx.math.Vector2;

public class TouchData 
{
	public float x;
	public float y;
	public boolean isDown;
	public boolean isDownBefore;
	public Vector2 location()
	{
		return new Vector2(x, y);
	}
}
