package com.jgames.lightspeed.input;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.jgames.lightspeed.LightSpeed;

public class TouchHandler 
{
	public static ArrayList<TouchData> Data = new ArrayList<TouchData>(); 
	
	public ArrayList<TouchData> SetData()
	{
		Data = new ArrayList<TouchData>();
		
		for(int i = 0; i < 5; i++)
		{
			TouchData data = new TouchData();
			float newX = (float)Gdx.input.getX(i) * ((float)LightSpeed.screenWidth / (float)Gdx.graphics.getWidth());
			data.x = (int)newX;
			float newY = ((float)Gdx.graphics.getHeight() - (float)Gdx.input.getY(i)) * ((float)LightSpeed.screenHeight / (float)Gdx.graphics.getHeight());
			data.y = (int)newY;
			data.isDown = Gdx.input.isTouched(i);
			
			Data.add(data);
		}
		
		return Data;
	}
}
