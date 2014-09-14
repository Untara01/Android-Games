package com.jae.spaceshooter.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class jJoystick 
{
	private jSprite centerKnob;
	private jSprite centerPoint;
	private Vector2 location;
	private boolean isActive;
	
	public jJoystick(Texture knobTex, Texture pointTex)
	{
		this.centerKnob = new jSprite(knobTex);
		this.centerPoint = new jSprite(pointTex);
		this.location = new Vector2(0, 0);
		this.isActive = false;
	}
	
	public void UpdateJoystick()
	{
		int touchInt = -1;
		
		for(int i = 0; i < 5; i++)
		{
			if(Gdx.input.isTouched(i) && Gdx.input.getX(i) < Gdx.graphics.getWidth() / 2)
			{
				touchInt = i;
			}
		}
		
		if(touchInt != -1)
		{
			if(!this.isActive && Gdx.input.isTouched(touchInt))
			{
				if(Gdx.input.getX(touchInt) < Gdx.graphics.getWidth() / 2)
				{
					this.isActive = true;
					this.location = new Vector2(Gdx.input.getX(touchInt), Gdx.graphics.getHeight() - Gdx.input.getY(touchInt));
					this.centerPoint.Position = new Vector2(this.location);
					this.centerKnob.Position = new Vector2(this.location);
				}
			}
			
			if(this.isActive)
			{
				this.centerKnob.Position.x = Gdx.input.getX(touchInt);
				if(this.centerKnob.Position.x - this.centerPoint.Position.x > 75)
				{
					this.centerKnob.Position.x = this.centerPoint.Position.x + 75;
				}
				else if(this.centerPoint.Position.x - this.centerKnob.Position.x > 75)
				{
					this.centerKnob.Position.x = this.centerPoint.Position.x - 75;
				}
				
				this.centerKnob.Position.y = Gdx.graphics.getHeight() - Gdx.input.getY(touchInt);
				if(this.centerKnob.Position.y - this.centerPoint.Position.y > 75)
				{
					this.centerKnob.Position.y = this.centerPoint.Position.y + 75;
				}
				else if(this.centerPoint.Position.y - this.centerKnob.Position.y > 75)
				{
					this.centerKnob.Position.y = this.centerPoint.Position.y - 75;
				}
			}
		}
		else
		{
			if(this.isActive)
			{
				this.isActive = false;
			}
		}
	}
	
	public void DrawJoystick(SpriteBatch batch)
	{
		if(this.isActive)
		{
			this.centerPoint.Draw(batch);
			this.centerKnob.Draw(batch);
		}
	}
	
	public Vector2 GetValues()
	{
		float x = this.centerKnob.Position.x - this.location.x;
		float y = this.centerKnob.Position.y - this.location.y;
		return this.isActive ? new Vector2(x, y) : null;
	}
}
