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
public class Square extends abstractShape {

    private Point position;
    private int side;
    private Color color;
    private Color fillcolor;

    public Square(Point position, int side) {
        super(position);
        this.side = side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillcolor = color;
    }

    @Override
    public Color getFillColor() {
        return fillcolor;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.fillcolor);
        canvas.fillRect((int) position.getX(), (int) position.getY(), side, side);
        canvas.setColor(this.color);
        canvas.drawRect((int) position.getX(), (int) position.getY(), side, side);

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
    public boolean contains(Point p) {
        Point pt = getPosition();
        java.awt.Rectangle s = new java.awt.Rectangle();
        s.setLocation(pt);
        s.setSize(side, side);
        return s.contains(p);
    }

    @Override
    public void resize(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
