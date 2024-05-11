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
public abstract class abstractShape implements Shape, movable {

    private Point position;
    private Color color = Color.black;
    private Point DraggingPoint; 
    private Color fillcolor = Color.white; 
 private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
// public void setSelected(boolean selected) {
//        this.selected = selected;
//    }
    public abstractShape(Point position) {
        this.position = position;
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
    public void draw(Graphics canvas) { //w e kaman??/
    }

    @Override
    public void setDraggingPoint(Point p) {
        this.DraggingPoint = p;
    }

    @Override
    public Point getDraggingPoint() {
        return DraggingPoint;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  }
    
    

  
}
