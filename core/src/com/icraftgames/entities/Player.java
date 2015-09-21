package com.icraftgames.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class Player {
	 Texture pTexture;
	 Sprite pSprite;
	 SpriteBatch spriteBatch;
	 int pX;
	 int pY;
	 float moveSpeed;
	 public Circle bounds;
	 
	public void init() {
		
		pTexture = new Texture("Player.png");
		pSprite = new Sprite(pTexture);
		pSprite.setPosition(50, 50);
		pSprite.setSize(32 * 3, 32 * 3);
		spriteBatch = new SpriteBatch();
		moveSpeed = 320f;
		bounds = new Circle(pSprite.getX(), pSprite.getY(), 5f);
		bounds.x = pSprite.getX();
		bounds.y = pSprite.getY();
		
		
		
	}
	
	public void render(float deltaTime) {
		
		

		spriteBatch.begin();
		spriteBatch.draw(pSprite, pSprite.getX(), pSprite.getY());
		spriteBatch.end();
		
		
	
		
		
		
		
		if(Gdx.input.isKeyPressed(Keys.A)) {
			pSprite.translate(-moveSpeed * deltaTime, 0);
		} 
		if (Gdx.input.isKeyPressed(Keys.D)) {
			
			pSprite.translate(moveSpeed * deltaTime, 0);
		} 
		if (Gdx.input.isKeyPressed(Keys.S)) {
			pSprite.translate(0, -moveSpeed * deltaTime);
		} 
		if (Gdx.input.isKeyPressed(Keys.W)) {
			pSprite.translate(0, moveSpeed * deltaTime);
		}
		
		bounds.x = pSprite.getX();
		bounds.y = pSprite.getY();
		
	}

}
