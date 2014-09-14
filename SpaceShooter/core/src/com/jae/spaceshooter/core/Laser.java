package com.jae.spaceshooter.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Laser extends jSprite
{
	public float CurrentSpeed;
	public Ship Parent;
	
	public Laser(jSprite sprite, Ship parent) 
	{
		super(sprite);
		
		this.Parent = parent;
	}
	
	public boolean UpdateLaser()
	{
		this.Move(this.Speed.x, this.Speed.y);
		Rectangle screenBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if(this.Position.x > screenBounds.getWidth() || this.Position.x < 0 || this.Position.y > screenBounds.getHeight() || this.Position.y < 0)
		{
			return false;
		}
		
		return true;
	}
}
