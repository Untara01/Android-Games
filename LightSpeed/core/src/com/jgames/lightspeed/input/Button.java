package com.jgames.lightspeed.input;

import com.jgames.lightspeed.graphics.Sprite;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Button extends Sprite
{
	private String text = null;
	private BitmapFont font = null;
	
	public Button(Texture Texture, Vector2 Location) 
	{
		super(Texture);
		
		this.SetLocation(Location.x, Location.y);
	}
	
	public Button(Texture Texture, Vector2 Location, String text, BitmapFont font) 
	{
		super(Location, 0, Texture);
		
		this.text = text;
		this.font = font;
	}
	
	public Button(Vector2 Position, float Rotation, Texture Texture, Color Tint, Vector2 Scale,
			String text, BitmapFont font)
	{
		super(Position, Rotation + (float)Math.PI / 2, 0, Texture, Tint, Scale, new Vector2(Texture.getWidth() / 2, Texture.getHeight() / 2));
		
		this.text = text;
		this.font = font;
	}
	
	@Override
	public void Draw(SpriteBatch batch)
	{
		super.Draw(batch);
		
		if(this.text != null)
		{
			this.font.drawWrapped(batch, this.text, this.GetLocation().x - this.Origin.x, this.GetLocation().y - this.Origin.y, this.GetDimensions().x, HAlignment.CENTER);
		}
	}
	
	public boolean update()
	{
		for(int i = 0; i < TouchHandler.Data.size(); i++)
		{
			if(TouchHandler.Data.get(i).isDownBefore)
			{
				if(this.DoesIntersect(TouchHandler.Data.get(i).x, TouchHandler.Data.get(i).y))
				{
					return true;
				}
			}
		}
		
		return false;
	}
}
