package com.jae.spaceshooter.core;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.jae.spaceshooter.Settings;

public class TouchHandler 
{
	public static ArrayList<TouchData> Data = new ArrayList<TouchData>(); 
	
	public static ArrayList<TouchData> SetData()
	{
		Data = new ArrayList<TouchData>();
		
		for(int i = 0; i < 5; i++)
		{
			TouchData data = new TouchData();
			float newX = (float)Gdx.input.getX(i) * ((float)Settings.width / (float)Gdx.graphics.getWidth());
			data.x = (int)newX;
			float newY = ((float)Gdx.graphics.getHeight() - (float)Gdx.input.getY(i)) * ((float)Settings.height / (float)Gdx.graphics.getHeight());
			data.y = (int)newY;
			data.isDown = Gdx.input.isTouched(i);
			
			Data.add(data);
		}
		
		return Data;
	}
}
