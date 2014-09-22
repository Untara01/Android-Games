package com.jgames.lightspeed.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.jgames.lightspeed.LightSpeed;

public class SplashScreen implements Screen
{
	private LightSpeed game;
	
	public OrthographicCamera camera;
	public StretchViewport viewport;
	public float timer;
	public float timeHolder;
	
	@Override
	public void render(float delta) 
	{
		this.Draw();
		this.Update();
	}
	
	public void Update()
	{
		
	}
	
	public void Draw()
	{
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
