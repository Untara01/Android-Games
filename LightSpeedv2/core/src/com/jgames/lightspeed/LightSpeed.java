package com.jgames.lightspeed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jgames.lightspeed.data.Assets;
import com.jgames.lightspeed.data.Settings;

public class LightSpeed extends Game 
{
	SpriteBatch batch;
	
	@Override
	public void create () 
	{
		this.batch = new SpriteBatch();
		Settings.GetInstance();
		Assets.load();
		//this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () 
	{
		super.render();
	}
}
