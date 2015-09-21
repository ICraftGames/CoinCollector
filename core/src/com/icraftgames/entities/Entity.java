package com.icraftgames.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
	
	
		
	
	
	Vector2 position;
	Texture texture;
	Sprite sprite;
	private Circle bounds;
	
	
	
	public void init() {
		sprite.setPosition(position.x, position.y);
		
	}
	
	
	public void render(SpriteBatch sb) {
		getBounds().x = sprite.getX();
		getBounds().y = sprite.getY();
		sprite.setPosition(position.x, position.y);

		sprite.draw(sb);
		
		
	}


	

	public Circle getBounds() {
		return bounds;
	}


	public void setBounds(Circle bounds) {
		this.bounds = bounds;
	}
	 
	

}
