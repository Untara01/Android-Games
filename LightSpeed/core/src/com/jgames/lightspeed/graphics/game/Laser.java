package com.jgames.lightspeed.graphics.game;

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
		
		return this.isOnScreen();
	}
}
