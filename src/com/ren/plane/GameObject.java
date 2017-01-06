package com.ren.plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	
	Image img;
	double x,y,width,height;
	int speed = 10;
	
	public Rectangle getRect() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}

	public GameObject(Image img, double x, double y, double width, double height, int speed) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	public GameObject() {
		
	}

}
