package com.jgames.lightspeed.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.data.Settings;
import com.jgames.lightspeed.ui.Label;
import com.jgames.lightspeed.ui.Textbox;

public class OptionsScreen implements Screen
{
	private LightSpeed game;
	
	public OrthographicCamera camera;
	public StretchViewport viewport;
	
	private Texture labelTexture = new Texture(Gdx.files.internal("UI/Blank.png"));
	
	private Label nameLabel;
	private Textbox nameBox = new Textbox();
	
	public OptionsScreen(LightSpeed game)
	{
		this.game = game;
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, LightSpeed.screenWidth, LightSpeed.screenHeight);
		this.viewport = new StretchViewport(LightSpeed.screenWidth, LightSpeed.screenHeight, this.camera);
		
		this.nameLabel = new Label(new Vector2(100, 380), 0f, this.labelTexture, "Player Name", this.game.headingTwoFont);
	}
	
	@Override
	public void render(float delta) 
	{
		this.draw();
		this.update();
	}
	
	public void update()
	{
		if(this.nameLabel.LabelUpdate())
		{
			Gdx.input.getTextInput(this.nameBox, "Player Name", "New Player");
			Settings.GetInstance().SetPlayerName(this.nameBox.textValue);
		}
	}
	
	public void draw()
	{
		this.camera.update();
		this.game.batch.setProjectionMatrix(this.camera.combined);
		
		this.game.batch.begin();
		this.game.normalFont.draw(this.game.batch, Settings.GetInstance().PLAYER_NAME, 50, 50);
		this.nameLabel.Draw(this.game.batch);
		this.game.batch.end();
	}

	@Override
	public void resize(int width, int height) 
	{
		
	}

	@Override
	public void show() 
	{
		
	}

	@Override
	public void hide() 
	{
		
	}

	@Override
	public void pause() 
	{
		
	}

	@Override
	public void resume() 
	{
		
	}

	@Override
	public void dispose() 
	{
		
	}
}
