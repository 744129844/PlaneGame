package com.ren.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.ren.util.Constant;

public class Bullet extends GameObject {
	
	double degree;
	
	public Rectangle getRect() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, (int)width, (int)height);
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if (y<0||y>Constant.GAME_HEIGHT-height) {
			degree = -degree;
		}
		
		if (x<width||x>Constant.GAME_WIDTH-width) {
			degree = Math.PI-degree;
		}
		
		g.setColor(c);
	}
	
	public Bullet(){
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
		this.width = 10;
		this.height = 10;
		this.speed = 3;
	}

}
