package com.jgames.lightspeed.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.jgames.lightspeed.LightSpeed;

public class MovingSprite extends Sprite
{
	protected Vector2 Speed;

	public MovingSprite(Sprite Sprite) 
	{
		super(Sprite);
		
		this.Speed = new Vector2(0, 0);
	}
	
	public MovingSprite(Sprite Sprite, Vector2 Speed) 
	{
		super(Sprite);
		
		this.Speed = Speed;
	}
	
	public void move()
	{
		this.setPosition(this.getX() + this.Speed.x, this.getY() + this.Speed.y);
	}
	
	public void update()
	{
		this.move();
	}
	
	public Vector2 getSpeedFromRotation(float elapsedTime, float iSpeed)
	{
		double radian = Math.toRadians(this.getRotation());
		Vector2 speed = new Vector2((float)Math.cos(radian), (float)Math.sin(radian));
		speed.x *= elapsedTime * iSpeed;
		speed.y *= elapsedTime * iSpeed;
		
		return speed;
	}
	
	public boolean isOnScreen()
	{
		if(this.getX() > LightSpeed.screenWidth || this.getX() < 0 || this.getY() > LightSpeed.screenHeight || this.getY() < 0)
		{
			return false;
		}
		
		return true;
	}
}
