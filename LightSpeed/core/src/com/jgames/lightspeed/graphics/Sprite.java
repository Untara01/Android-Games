package com.jgames.lightspeed.graphics;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite 
{
	//radians
    public float Rotation;
    public float RotationalVelocity;
    private Rectangle BoundingBox;
    
    public Texture Texture;
    public Color Tint;
    public Vector2 Scale;
    public Vector2 Origin;
    
    public Vector2 GetScaledOrigin()
    {
    	return new Vector2(this.Origin.x * this.Scale.x, this.Origin.y * this.Scale.y);
    }
    
    public Vector2 GetLocation()
    {
    	return new Vector2(this.BoundingBox.x + this.GetScaledOrigin().x, this.BoundingBox.y + this.GetScaledOrigin().y);
    }
    
    public void SetLocation(float x, float y)
    {
    	this.BoundingBox.x = x - this.GetScaledOrigin().x;
    	this.BoundingBox.y = y - this.GetScaledOrigin().y;
    }
    
    public Vector2 GetDimensions()
    {
    	return new Vector2(this.BoundingBox.width, this.BoundingBox.height);
    }
    
    public void SetDimensions(float x, float y)
    {
    	this.BoundingBox.width = x;
    	this.BoundingBox.height = y;
    }

    //Constructors

    public Sprite(Sprite Sprite)
    {
    	this.Rotation = Sprite.Rotation;
    	this.RotationalVelocity = Sprite.RotationalVelocity;
    	this.BoundingBox = Sprite.BoundingBox;
    	
    	this.Texture = Sprite.Texture;
    	this.Tint = Sprite.Tint;
    	this.Scale = Sprite.Scale;
    	this.Origin = Sprite.Origin;
    }
    
    public Sprite(Texture Texture)
    {
    	this.Rotation = 0;
    	this.RotationalVelocity = 0;
    	
    	this.Texture = Texture;
    	this.Tint = Color.WHITE;
    	this.Scale = new Vector2(1, 1);
    	this.Origin = new Vector2(this.Texture.getWidth() / 2, this.Texture.getHeight() / 2);
    	this.BoundingBox = new Rectangle(-this.Origin.x, -this.Origin.y, Texture.getWidth() - this.Origin.x, Texture.getHeight() - this.Origin.y);
    }
    
    public Sprite(Vector2 Position, float Rotation, Texture Texture)
    {
        this.Rotation = Rotation;
        this.Texture = Texture;

        this.Tint = Color.WHITE;
        this.Origin = new Vector2(this.Texture.getWidth() / 2, this.Texture.getHeight() / 2);
        this.Scale = new Vector2(1, 1);
    	this.BoundingBox = new Rectangle(Position.x - this.Origin.x, Position.y - this.Origin.x, Texture.getWidth(), Texture.getHeight());
    }

    public Sprite(Vector2 Position, float Rotation, Texture Texture, Color Tint, Vector2 Scale)
    {
        this.Rotation = Rotation;
        this.Texture = Texture;
        this.Tint = Tint;
        this.Scale = Scale;
        
        this.Origin = new Vector2(this.Texture.getWidth() / 2, this.Texture.getHeight() / 2);
        this.BoundingBox = new Rectangle(Position.x - this.GetScaledOrigin().x, Position.y - this.GetScaledOrigin().x, Texture.getWidth() * Scale.x, Texture.getHeight() * Scale.y);
    }

    public Sprite(Vector2 Position, float Rotation, float RotationalVelocity, Texture Texture, Color Tint, Vector2 Scale, Rectangle SourceRectangle, Vector2 Origin)
    {
        this.Rotation = Rotation;
        this.RotationalVelocity = RotationalVelocity;
        this.Texture = Texture;
        this.Tint = Tint;
        this.Scale = Scale;
        this.Origin = Origin;
        this.BoundingBox = new Rectangle(Position.x - this.GetScaledOrigin().x, Position.y - this.GetScaledOrigin().x, Texture.getWidth() * Scale.x, Texture.getHeight() * Scale.y);
    }

    public void Draw(SpriteBatch batch)
    {
    	batch.draw(this.Texture, 
    			this.BoundingBox.x, this.BoundingBox.y, this.Origin.x, this.Origin.y, 
    			this.BoundingBox.width, this.BoundingBox.height, this.Scale.x, this.Scale.y, 
    			(float)Math.toDegrees(this.Rotation) - 90, 0, 0, 
    			this.Texture.getWidth(), this.Texture.getHeight(), false, false);
    }
    
    public void Update() 
    {
    	
    }
    
    //Intersection algorithms

    public boolean DoesIntersect(Rectangle rectangle)
    {
        if (this.BoundingBox.overlaps(rectangle))
        {
            return true;
        }

        return false;
    }

    public boolean DoesIntersect(Sprite sprite)
    {
        return this.DoesIntersect(sprite.BoundingBox);
    }

    public boolean DoesIntersect(Vector2 vector)
    {
        Rectangle vectorBox = new Rectangle((int)vector.x, (int)vector.y, 1, 1);
        System.out.println(vector.x);
        System.out.println(vector.y);
        System.out.println(this.BoundingBox.x);
        System.out.println(this.BoundingBox.y);
        System.out.println(this.BoundingBox.x + this.BoundingBox.width);
        System.out.println(this.BoundingBox.y + this.BoundingBox.height);
		System.out.println("Test Two");

        return this.DoesIntersect(vectorBox);
    }
}
