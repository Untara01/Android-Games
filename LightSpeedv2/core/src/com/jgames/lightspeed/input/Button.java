package com.jgames.lightspeed.input;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Button extends Sprite
{
	public String text = null;
	private BitmapFont font = null;
	Vector2 textDimensions = new Vector2(0, 0);
	Vector2 textPosition = new Vector2(0, 0);
	
	private Vector2 setTextPosition()
	{
		Vector2 textPos = new Vector2();
		
		textPos.x = this.getX() + (this.getOriginX() * this.getScaleX());
		textPos.y = this.getY() + (this.getOriginY() * this.getScaleY());
		
		textPos.x -= this.textDimensions.x / 2;
		textPos.y += this.textDimensions.y / 2;
		
		this.textPosition = textPos;
		return textPos;
	}
	
	public Button(TextureRegion Texture, Vector2 Location) 
	{
		super(Texture);
		this.setBounds(Location.x, Location.y, Texture.getRegionWidth(), Texture.getRegionHeight());
		this.text = null;
		this.font = null;
	}
	
	public Button(TextureRegion Texture, Vector2 Location, String text, BitmapFont font) 
	{
		super(Texture);
		
		this.text = text;
		this.font = font;
		this.setBounds(Location.x, Location.y, Texture.getRegionWidth(), Texture.getRegionHeight());
		
		this.textDimensions = new Vector2(this.font.getBounds(this.text).width, this.font.getBounds(this.text).height);
		this.setTextPosition();
	}
	
	public Button(Vector2 Location, float Rotation, TextureRegion Texture, Color Tint, float ScaleX, float ScaleY,
			String text, BitmapFont font)
	{
		super(Texture);
		
		this.text = text;
		this.font = font;
		this.setBounds(Location.x, Location.y, Texture.getRegionWidth() * ScaleX, Texture.getRegionHeight() * ScaleY);
		this.setRotation(Rotation);
		this.setColor(Tint);
		this.setScale(ScaleX, ScaleY);
		
		this.textDimensions = new Vector2(this.font.getBounds(this.text).width, this.font.getBounds(this.text).height);
		this.setTextPosition();
	}
	
	public void draw(SpriteBatch batch)
	{
		super.draw(batch);
		
		if(this.text != null && this.font != null)
		{
			this.font.draw(batch, this.text, this.textPosition.x, this.textPosition.y);
		}
	}
	
	public boolean update()
	{
		for(int i = 0; i < TouchHandler.Data.size(); i++)
		{
			if(TouchHandler.Data.get(i).isDownBefore)
			{
				
				if(this.getBoundingRectangle().contains(TouchHandler.Data.get(i).x, TouchHandler.Data.get(i).y))
				{
					return true;
				}
			}
		}
		
		return false;
	}
}
