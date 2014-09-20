package com.jgames.lightspeed.graphics.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jgames.lightspeed.graphics.MovingSprite;

public class Laser extends MovingSprite
{
	public Ship Parent;
	
	public Laser(MovingSprite sprite, Ship parent, Vector2 speed) 
	{
		super(sprite, speed);
		
		this.Parent = parent;
	}
	
	public boolean UpdateLaser()
	{
		this.update();
		
		Rectangle screenBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if(this.BoundingBox.x > screenBounds.getWidth() || this.BoundingBox.x < 0 || this.BoundingBox.y > screenBounds.getHeight() || this.BoundingBox.y < 0)
		{
			return false;
		}
		
		return true;
	}
}
