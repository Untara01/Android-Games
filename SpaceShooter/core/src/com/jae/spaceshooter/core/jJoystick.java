package com.jae.spaceshooter.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.jae.spaceshooter.Settings;

public class jJoystick 
{
	private jSprite centerKnob;
	private jSprite centerPoint;
	private Vector2 location;
	private boolean isActive;
	public boolean isFixed;
	
	public jJoystick(Texture knobTex, Texture pointTex, boolean fixed, Vector2 location)
	{
		this.centerKnob = new jSprite(knobTex);
		this.centerPoint = new jSprite(pointTex);
		this.location = location;
		this.isActive = false;
		this.isFixed = fixed;
		
		if(fixed)
		{
			this.centerKnob.Position = new Vector2(location.x, location.y);
			this.centerPoint.Position = new Vector2(location.x, location.y);
		}
	}
	
	public void UpdateJoystick()
	{
		int touchInt = -1;
		
		for(int i = 0; i < 5; i++)
		{
			if(TouchHandler.Data.get(i).isDown && TouchHandler.Data.get(i).x < Settings.width / 2)
			{
				touchInt = i;
			}
		}
		
		if(touchInt != -1)
		{
			if(!this.isActive && !this.isFixed)
			{
				this.isActive = true;
				this.location = new Vector2(TouchHandler.Data.get(touchInt).x, TouchHandler.Data.get(touchInt).y);
				this.centerPoint.Position = new Vector2(this.location);
				this.centerKnob.Position = new Vector2(this.location);
			}
			
			if(this.isActive || this.isFixed)
			{
				this.centerKnob.Position.x = TouchHandler.Data.get(touchInt).x;
				if(this.centerKnob.Position.x - this.centerPoint.Position.x > Settings.joystickRadius)
				{
					this.centerKnob.Position.x = this.centerPoint.Position.x + Settings.joystickRadius;
				}
				else if(this.centerPoint.Position.x - this.centerKnob.Position.x > Settings.joystickRadius)
				{
					this.centerKnob.Position.x = this.centerPoint.Position.x - Settings.joystickRadius;
				}
				
				this.centerKnob.Position.y = TouchHandler.Data.get(touchInt).y;
				if(this.centerKnob.Position.y - this.centerPoint.Position.y > Settings.joystickRadius)
				{
					this.centerKnob.Position.y = this.centerPoint.Position.y + Settings.joystickRadius;
				}
				else if(this.centerPoint.Position.y - this.centerKnob.Position.y > Settings.joystickRadius)
				{
					this.centerKnob.Position.y = this.centerPoint.Position.y - Settings.joystickRadius;
				}
			}
		}
		else
		{
			if(this.isFixed)
			{
				this.centerKnob.Position = this.location;
			}
			else
			{
				if(this.isActive)
				{
					this.isActive = false;
				}
			}
		}
	}
	
	public void DrawJoystick(SpriteBatch batch)
	{
		if(this.isActive || this.isFixed)
		{
			this.centerPoint.Draw(batch);
			this.centerKnob.Draw(batch);
			
			System.out.println(this.centerPoint.Position.x);
		}
	}
	
	public Vector2 GetValues()
	{
		float x = this.centerKnob.Position.x - this.location.x;
		float y = this.centerKnob.Position.y - this.location.y;
		return (this.isActive || this.isFixed) ? new Vector2(x, y) : null;
	}
}
