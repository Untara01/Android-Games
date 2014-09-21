package com.jgames.lightspeed.input;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.data.Settings;
import com.jgames.lightspeed.graphics.Sprite;

public class Joystick
{
	private Sprite knob;
	private Vector2 location;
	private boolean isActive;
	private Vector2 values;
	
	public Joystick(Texture knobTexture)
	{
		this.knob = new Sprite(knobTexture);
		this.location = new Vector2(Settings.GetInstance().JOYSTICK_POSITION);
		this.knob.SetLocation(this.location.x, this.location.y);
		this.isActive = false;
	}
	
	public void Update()
	{
		int pointer = -1;
		
		for(int i = 0; i < TouchHandler.Data.size(); i++)
		{
			if(TouchHandler.Data.get(i).isDown && TouchHandler.Data.get(i).x < LightSpeed.screenWidth / 2)
			{
				pointer = i;
			}
		}
		
		if(!Settings.GetInstance().JOYSTICK_FIXED)
		{
			if(pointer == -1 && this.isActive)
			{
				this.isActive = false;
			}
			
			if(this.isActive)
			{
				this.knob.SetLocation(TouchHandler.Data.get(pointer).x, TouchHandler.Data.get(pointer).y);
			}
			else
			{
				if(pointer != -1)
				{
					this.isActive = true;
					this.location.x = TouchHandler.Data.get(pointer).x;
					this.location.y = TouchHandler.Data.get(pointer).y;
				}
			}
		}
		else
		{
			if(pointer != -1)
			{
				this.knob.SetLocation(TouchHandler.Data.get(pointer).x, TouchHandler.Data.get(pointer).y);
			}
			else
			{
				this.knob.SetLocation(this.location.x, this.location.y);
			}
		}
		
		this.values.x = this.knob.GetLocation().x - this.location.x;
		this.values.y = this.knob.GetLocation().y - this.location.y;
		
		this.values.x = this.knob.GetLocation().x - this.location.x;
		this.values.y = this.knob.GetLocation().y - this.location.y;
	}
	
	public Vector2 GetValues()
	{
		if(this.isActive || Settings.GetInstance().JOYSTICK_FIXED)
		{
			return this.values;
		}
		else
		{
			return Vector2.Zero;
		}
	}
}
