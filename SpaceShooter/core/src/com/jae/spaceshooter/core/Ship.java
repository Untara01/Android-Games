package com.jae.spaceshooter.core;

import com.badlogic.gdx.math.Vector2;

public class Ship extends jSprite
{
	public float Speed;
	
	public Ship(jSprite sprite)
	{
		super(sprite);
	}
	
	public Vector2 getSpeedFromRotation(float elapsedTime)
	{
		Vector2 speed = new Vector2((float)Math.cos(this.Rotation), (float)Math.sin(this.Rotation));
		speed.x *= this.Speed * elapsedTime;
		speed.y *= this.Speed * elapsedTime;
		
		return speed;
	}
	
	public void move(float x, float y)
	{
		this.Position = new Vector2(this.Position.x + x, this.Position.y + y);
	}
}
