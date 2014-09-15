package com.jae.spaceshooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jae.spaceshooter.screens.MainMenuScreen;

public class SpaceShooter extends Game 
{
	public SpriteBatch batch;
	public BitmapFont font;
	
	@Override
	public void create () 
	{
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () 
	{
		super.render();
	}
	
	@Override
	public void dispose () 
	{
		this.batch.dispose();
		this.font.dispose();
	}
}
