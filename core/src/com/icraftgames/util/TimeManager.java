package com.icraftgames.util;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class TimeManager {
	
	private boolean isTimerRunning;
	public Timer timer;
	public int[] time;
	public int index;
	public boolean gameOver = false;
	public boolean isGameOver = false;
	private BitmapFont font;
	private SpriteBatch sb;
	
	public void init(LevelManager levelManager) {
		index = 0;
		timer = new Timer();
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
		sb = new SpriteBatch();
		time = new int[11];
		isTimerRunning = true;
		for(int x = 0; x < time.length; x++) {
			
			time[x] = 20 - x * 2;
		}
		
		startTimer();
		
		
	}
	
	public void startTimer() {
		
		timer.scheduleTask(new Task() {
			@Override
			public void run() {
				isTimerRunning  = true;
				time[index]--;
				
				
				Gdx.app.log("TimeManager", time[index] + " seconds remaining.");
				if(time[index] <= 1) {
					
					timer.stop();
					isTimerRunning = false;
					isGameOver = true;
					//gameOver = true;
				}
			}
		}, 0, 1);
	}
	
	
	public void render() {
		if(isTimerRunning == false) {
			isGameOver = true;
		}
		
		
		sb.begin();
		font.draw(sb, "Time Left: " + time[index] , Gdx.graphics.getWidth() / 2 - 95, Gdx.graphics.getHeight() / 2 + 200);
		sb.end();
	}
	

}
