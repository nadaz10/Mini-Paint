/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author ADMIN
 */
public class Rectangle extends abstractShape {

    private int height, width;

    public Rectangle(Point position, int height, int width) {
        super(position);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean URCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x + width - 5, y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean LRCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x + width - 5, y + height - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean LLCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y + height - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean ULCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getFillColor());
        canvas.fillRect((int) getPosition().getX(), (int) getPosition().getY(), width, height);
        canvas.setColor(this.getColor());
        canvas.drawRect((int) getPosition().getX(), (int) getPosition().getY(), width, height); //no change sa7?
        if (isSelected()) {
            canvas.setColor(Color.BLACK);
            canvas.fillRect((int) getPosition().getX() - 5, (int) getPosition().getY() - 5, 10, 10);
            canvas.fillRect((int) getPosition().getX() + width - 5, (int) getPosition().getY() - 5, 10, 10);
            canvas.fillRect((int) getPosition().getX() - 5, (int) getPosition().getY() + height - 5, 10, 10);
            canvas.fillRect((int) getPosition().getX() + width - 5, (int) getPosition().getY() + height - 5, 10, 10);   //????
        }
    }

    @Override
    public boolean contains(Point p) {
        Point pt = getPosition();
        java.awt.Rectangle r = new java.awt.Rectangle();
        r.setLocation(pt);
        r.setSize(width, height);
        return r.contains(p);
    }

    @Override
    public void moveTo(Point p) {
        int x = getDraggingPoint().x;
        int y = getDraggingPoint().y;
        int xdiff = p.x - x;
        int ydiff = p.y - y;
        setPosition(new Point(getPosition().x + xdiff, getPosition().y + ydiff));
    }

    @Override
    public void resize(Point p) {
        int x1 = getDraggingPoint().x; //de old ama 2 de ba3d ma we moved
        int y1 = getDraggingPoint().y;
        int x2 = p.x;
        int y2 = p.y;
        if (ULCorners(getDraggingPoint())) { //mafesh el conditions de??
            width = width + x1 - x2;
            height = height + y1 - y2;
            getPosition().x = getPosition().x + x2 - x1;
            getPosition().y = getPosition().y + y2 - y1;
        } else if (URCorners(getDraggingPoint())) {
            width = width + x2 - x1;
            height = height + y1 - y2;
            getPosition().y = getPosition().y + y2 - y1;
        } else if (LLCorners(getDraggingPoint())) {
            width = width + x1 - x2;
            height = height + y2 - y1;
            getPosition().x = x2;
        } else if (LRCorners(getDraggingPoint())) {
            width = width - x1 + x2;
            height = height + y2 - y1;
        }
        if (width < 0) {
            width = -1 * width;
            getPosition().x -= width;
        }
        if (height < 0) {
            height = -1 * height;
            getPosition().y -= height;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Point pos = new Point(getPosition().x, getPosition().y);
        Rectangle r = new Rectangle(pos, height, width);
        r.setColor(getColor());
        r.setFillColor(getFillColor());
        return r;
    }
}
