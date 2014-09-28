package com.jgames.lightspeed.input;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.data.Settings;

public class Joystick
{
	private Sprite knob;
	private TextureRegion pointTexture;
	private Vector2 location;
	private boolean isActive;
	private Vector2 values;
	
	public Joystick(TextureRegion knobTexture, TextureRegion pointTexture)
	{
		this.knob = new Sprite(knobTexture);
		this.knob.setScale(1.5f);
		this.pointTexture = pointTexture;
		this.location = new Vector2(Settings.GetInstance().JOYSTICK_POSITION);
		this.knob.setPosition(this.location.x - this.knob.getOriginX(), this.location.y - this.knob.getOriginY());
		this.isActive = false;
		this.values = new Vector2(0, 0);
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
				this.knob.setPosition(TouchHandler.Data.get(pointer).x - this.knob.getOriginX(), TouchHandler.Data.get(pointer).y - this.knob.getOriginY());
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
				this.knob.setPosition(TouchHandler.Data.get(pointer).x - this.knob.getOriginX(), TouchHandler.Data.get(pointer).y - this.knob.getOriginY());
			}
			else
			{
				this.knob.setPosition(this.location.x - this.knob.getOriginX(), this.location.y - this.knob.getOriginY());
			}
		}
		
		this.values.x = this.knob.getX() + this.knob.getOriginX() - this.location.x;
		this.values.y = this.knob.getY() + this.knob.getOriginY() - this.location.y;
		
		if(this.values.x > Settings.GetInstance().JOYSTICK_RADIUS)
		{
			this.knob.setX(this.location.x + Settings.GetInstance().JOYSTICK_RADIUS - this.knob.getOriginX());
			this.values.x = this.knob.getX() - this.location.x;
		}
		else if(this.values.x < -Settings.GetInstance().JOYSTICK_RADIUS)
		{
			this.knob.setX(this.location.x - Settings.GetInstance().JOYSTICK_RADIUS - this.knob.getOriginX());
			this.values.x = this.knob.getX() - this.location.x;
		}
		if(this.values.y > Settings.GetInstance().JOYSTICK_RADIUS)
		{
			this.knob.setY(this.location.y + Settings.GetInstance().JOYSTICK_RADIUS - this.knob.getOriginY());
			this.values.y = this.knob.getY() - this.location.y;
		}
		else if(this.values.y < -Settings.GetInstance().JOYSTICK_RADIUS)
		{
			this.knob.setY(this.location.y - Settings.GetInstance().JOYSTICK_RADIUS - this.knob.getOriginY());
			this.values.y = this.knob.getY() - this.location.y;
		}
	}
	
	public void Draw(SpriteBatch batch)
	{
		if(this.isActive || Settings.GetInstance().JOYSTICK_FIXED)
		{
			batch.draw(this.pointTexture, this.location.x - this.pointTexture.getRegionWidth() / 2, this.location.y - this.pointTexture.getRegionHeight() / 2);	
			this.knob.draw(batch);
		}
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
