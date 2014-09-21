package com.jgames.lightspeed.graphics;

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
		this.SetLocation(this.GetLocation().x + this.Speed.x, this.GetLocation().y + this.Speed.y);
	}
	
	public void update()
	{
		this.move();
	}
	
	public Vector2 getSpeedFromRotation(float elapsedTime, float iSpeed)
	{
		Vector2 speed = new Vector2((float)Math.cos(this.Rotation), (float)Math.sin(this.Rotation));
		speed.x *= elapsedTime * iSpeed;
		speed.y *= elapsedTime * iSpeed;
		
		return speed;
	}
	
	public boolean isOnScreen()
	{
		if(this.GetLocation().x > LightSpeed.screenWidth || this.GetLocation().x < 0 || this.GetLocation().y > LightSpeed.screenHeight || this.GetLocation().y < 0)
		{
			return false;
		}
		
		return true;
	}
}
