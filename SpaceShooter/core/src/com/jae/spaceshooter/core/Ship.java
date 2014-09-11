package com.jae.spaceshooter.core;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ship extends Sprite
{
	public Ship(Sprite sprite)
	{
		super(sprite);
	}
	
	@Override
	public void draw(Batch batch)
	{
		batch.draw(this.getTexture(), this.getX() - this.getOriginX(), this.getY() - this.getOriginY(), this.getWidth(), this.getHeight(), 0, 0, (int)this.getWidth(), (int)this.getHeight(), false, false);
	}
}
