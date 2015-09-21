package com.icraftgames;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.icraftgames.screens.GameOverScreen;
import com.icraftgames.screens.GameScreen;
import com.icraftgames.screens.MainMenuScreen;


	
	
import com.icraftgames.screens.GameScreen;

public class CoinCollector extends Game {
	
	private MainMenuScreen mainMenu;
	private GameScreen gameScreen;
	private GameOverScreen gameOverScreen;

	@Override
	public void create() {
		mainMenu = new MainMenuScreen();
		gameScreen = new GameScreen();
		gameOverScreen = new GameOverScreen();
		
		setScreen(mainMenu);
	}
	
	@Override
	public void dispose() {
		super.dispose();	
	}
	
	@Override
	public void render() {
		super.render();
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			if(getScreen() == mainMenu) {
				
				setScreen(gameScreen);
				
				
			}
		}
		
		if(gameScreen.timeManager != null) {
			
	 		if(gameScreen.timeManager.isGameOver == true) {
				setScreen(gameOverScreen);
			} else {
				return;
			}
		}
		
		
		

	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
	
	@Override
	public void pause() {
		super.pause();
	}
	
	@Override
	public void resume() {
		super.resume();
	}
	
}
