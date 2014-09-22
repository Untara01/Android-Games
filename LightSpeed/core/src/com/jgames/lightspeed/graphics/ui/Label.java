package com.jgames.lightspeed.graphics.ui;

import com.jgames.lightspeed.input.TouchData;
import com.jgames.lightspeed.input.TouchHandler;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Label
{
	public String text;
	public Vector2 location;
	public BitmapFont font;
	public Rectangle bounds;
	
	public Rectangle GetBounds()
	{
		return this.bounds; 
	}
	
	public Label(Vector2 Position, String Text, BitmapFont Font) 
	{
		this.location = Position;
		this.text = Text;
		this.font = Font;
		this.bounds = new Rectangle(this.location.x, this.location.y, this.font.getBounds(this.text).width, this.font.getBounds(this.text).height);
	}
	
	public void Draw(SpriteBatch batch)
	{
		this.font.draw(batch, this.text, this.location.x, this.location.y);
	}
	
	public boolean LabelUpdate()
	{
		for(int i = 0; i < TouchHandler.Data.size(); i++)
		{
			if(TouchHandler.Data.get(i).isDownBefore)
			{
				TouchData data = TouchHandler.Data.get(i);
				
				if(data.x > this.location.x && data.x < this.location.x + this.bounds.width &&
						data.y < this.location.y && data.y > this.location.y - this.bounds.height)
				{
					return true;
				}
			}
		}
		
		return false;
	}
}
