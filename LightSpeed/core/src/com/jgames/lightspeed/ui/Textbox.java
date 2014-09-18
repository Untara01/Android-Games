package com.jgames.lightspeed.ui;

import com.badlogic.gdx.Input.TextInputListener;

public class Textbox implements TextInputListener
{
	public String textValue;
	
	@Override
	public void input(String text) 
	{
		this.textValue = text;
	}

	@Override
	public void canceled() 
	{
		this.textValue = null;
	}
}
