package com.jgames.lightspeed.graphics.ui;

import com.jgames.lightspeed.graphics.Sprite;
import com.jgames.lightspeed.input.TouchHandler;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Label extends Sprite
{
	public String text;
	public BitmapFont font;
	
	public Label(Vector2 Position, float Rotation, Texture Texture,
			String Text, BitmapFont Font) 
	{
		super(Position, Rotation, Texture);
		this.BoundingBox.setWidth(Font.getBounds(Text).width);
		this.BoundingBox.setHeight(Font.getLineHeight());
		this.text = Text;
		this.font = Font;
	}
	
	public void Draw(SpriteBatch batch)
	{
		this.font.draw(batch, text, this.BoundingBox.x, this.BoundingBox.y);
	}
	
	public boolean LabelUpdate()
	{
		for(int i = 0; i < TouchHandler.Data.size(); i++)
		{
			if(TouchHandler.Data.get(i).isDown && this.DoesIntersect(new Vector2(TouchHandler.Data.get(i).location())))
			{
				System.out.println("Test One");
				return true;
			}
		}
		
		return false;
	}
}
