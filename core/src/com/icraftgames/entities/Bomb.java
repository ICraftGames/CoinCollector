package com.icraftgames.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Bomb extends Entity {
	
	public Bomb(Vector2 Position) {
		this.position = Position;
		init();
	}
	
	
	@Override
	public void init() {
		texture = new Texture("Bomb.png");
		sprite = new Sprite(texture);
		super.init();
	}
	
	@Override
	public void render(SpriteBatch sb) {
		super.render(sb);
	}
	
	
	@Override
	public Circle getBounds() {
		return super.getBounds();
	}

	@Override
	public void setBounds(Circle bounds) {
		super.setBounds(bounds);
	}
	 
}
