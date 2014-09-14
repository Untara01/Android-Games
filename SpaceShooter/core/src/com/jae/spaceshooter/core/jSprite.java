package com.jae.spaceshooter.core;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class jSprite 
{
	public Vector2 Position;
    public float Rotation; //radians
    public Vector2 Speed;
    public float RotationalVelocity;
    
    public Texture Texture;
    public Color Tint;
    public Vector2 Scale;
    public Vector2 Origin;
    public Vector2 getSizeScaled()
    {
    	return new Vector2(this.Texture.getWidth() * this.Scale.x, this.Texture.getHeight() * this.Scale.y);
    }

    //Constructors

    public jSprite(jSprite sprite)
    {
    	this.Position = sprite.Position;
    	this.Rotation = sprite.Rotation;
    	this.Speed = sprite.Speed;
    	this.RotationalVelocity = sprite.RotationalVelocity;
    	
    	this.Texture = sprite.Texture;
    	this.Tint = sprite.Tint;
    	this.Scale = sprite.Scale;
    	this.Origin = sprite.Origin;
    }
    
    public jSprite(Texture texture)
    {
    	this.Position = new Vector2(0, 0);
    	this.Rotation = 0;
    	this.Speed = new Vector2(0, 0);
    	this.RotationalVelocity = 0;
    	
    	this.Texture = texture;
    	this.Tint = Color.WHITE;
    	this.Scale = new Vector2(1, 1);
    	this.Origin = new Vector2(this.Texture.getWidth() / 2, this.Texture.getHeight() / 2);
    }
    
    public jSprite(Vector2 Position, float Rotation, Vector2 Speed, Texture Texture)
    {
        this.Position = Position;
        this.Rotation = Rotation;
        this.Speed = Speed;
        this.Texture = Texture;

        this.Tint = Color.WHITE;
        this.Origin = new Vector2(this.Texture.getWidth() / 2, this.Texture.getHeight() / 2);
        this.Scale = new Vector2(1, 1);
    }

    public jSprite(Vector2 Position, float Rotation, Vector2 Speed, Texture Texture, Color Tint, Vector2 Scale)
    {
        this.Position = Position;
        this.Rotation = Rotation;
        this.Speed = Speed;
        this.Texture = Texture;
        this.Tint = Tint;
        this.Scale = Scale;

        this.Origin = new Vector2(this.Texture.getWidth() / 2, this.Texture.getHeight() / 2);
    }

    public jSprite(Vector2 Position, float Rotation, Vector2 Speed, float RotationalVelocity, Texture Texture, Color Tint, Vector2 Scale, Rectangle SourceRectangle, Vector2 Origin)
    {
        this.Position = Position;
        this.Rotation = Rotation;
        this.Speed = Speed;
        this.RotationalVelocity = RotationalVelocity;
        this.Texture = Texture;
        this.Tint = Tint;
        this.Scale = Scale;
        this.Origin = Origin;
    }

    //Public Functions

    public void Move(float x, float y)
    {
        this.Position.x += x;
        this.Position.y += y;
    }

    public void Draw(SpriteBatch batch)
    {
    	batch.draw(this.Texture, 
    			this.Position.x - this.Origin.x, this.Position.y - this.Origin.y, this.Origin.x, this.Origin.y, 
    			this.Texture.getWidth(), this.Texture.getHeight(), this.Scale.x, this.Scale.y, 
    			(float)Math.toDegrees(this.Rotation) - 90, 0, 0, 
    			this.Texture.getWidth(), this.Texture.getHeight(), false, false);
    }
    
    public void Update() 
    {
    	this.Move(this.Speed.x, this.Speed.y);
    }
    
    //Intersection algorithms

    public boolean DoesIntersect(Rectangle rectangle)
    {
        Rectangle thisBox = new Rectangle((int)this.Position.x, (int)this.Position.y, (int)this.getSizeScaled().x, (int)this.getSizeScaled().y);

        if (thisBox.overlaps(rectangle))
        {
            return true;
        }

        return false;
    }

    public boolean DoesIntersect(jSprite sprite)
    {
        Rectangle spriteBox = new Rectangle((int)sprite.Position.x, (int)sprite.Position.y, (int)sprite.getSizeScaled().x, (int)sprite.getSizeScaled().y);

        return this.DoesIntersect(spriteBox);
    }

    public boolean DoesIntersect(Vector2 vector)
    {
        Rectangle vectorBox = new Rectangle((int)vector.x, (int)vector.y, 1, 1);

        return this.DoesIntersect(vectorBox);
    }
	
	public Vector2 getSpeedFromRotation(float elapsedTime, float iSpeed)
	{
		Vector2 speed = new Vector2((float)Math.cos(this.Rotation), (float)Math.sin(this.Rotation));
		speed.x *= elapsedTime * iSpeed;
		speed.y *= elapsedTime * iSpeed;
		
		return speed;
	}
}
