package com.jae.spaceshooter.core;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.jae.spaceshooter.SpaceShooter;

public class TouchHandler 
{
	public static ArrayList<TouchData> GetData()
	{
		ArrayList<TouchData> Data = new ArrayList<TouchData>();
		
		for(int i = 0; i < 5; i++)
		{
			TouchData data = new TouchData();
			data.x = (Gdx.input.getX(i) / Gdx.graphics.getWidth()) * SpaceShooter.width;
			data.y = (Gdx.input.getX(i) / Gdx.graphics.getWidth()) * SpaceShooter.width;
			data.isDown = Gdx.input.isTouched(i);
			
			Data.add(data);
		}
		
		return Data;
	}
}
