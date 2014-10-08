package com.jgames.lightspeed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jgames.lightspeed.data.Assets;
import com.jgames.lightspeed.data.Settings;
import com.jgames.lightspeed.input.TouchHandler;
import com.jgames.lightspeed.screens.MainMenuScreen;

public class LightSpeed extends Game 
{
	public SpriteBatch batch;
	public final static int screenWidth = 800;
	public final static int screenHeight = 480;
	
	@Override
	public void create () 
	{
		this.batch = new SpriteBatch();
		Settings.GetInstance();
		Assets.load();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () 
	{
		TouchHandler.SetData();
		
		super.render();
	}
	
	public static void drawSprite(Sprite sprite, SpriteBatch batch)
	{
		batch.draw(sprite, 
				sprite.getX(), sprite.getY(),
				sprite.getOriginX(), sprite.getOriginY(), 
				sprite.getRegionWidth(), sprite.getRegionHeight(),
				sprite.getScaleX(), sprite.getScaleY(), 
				sprite.getRotation());
	}
}