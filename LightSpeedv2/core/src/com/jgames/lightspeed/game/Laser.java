package com.jgames.lightspeed.game;

import com.badlogic.gdx.math.Vector2;

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
