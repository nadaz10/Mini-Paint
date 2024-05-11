/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author ADMIN
 */
public class Triangle extends abstractShape {

    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point position, Point secondPoint, Point thirdPoint) {
        super(position);
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getFillColor());
        int xPoints[] = new int[]{getPosition().x, secondPoint.x, thirdPoint.x};
        int yPoints[] = new int[]{getPosition().y, secondPoint.y, thirdPoint.y};
        canvas.fillPolygon(xPoints, yPoints, 3);
        canvas.setColor(this.getColor());
        canvas.drawPolygon(xPoints, yPoints, 3);
        if (isSelected()) {
            canvas.setColor(Color.BLACK);
            canvas.fillRect((int) getPosition().getX() - 5, (int) getPosition().getY() - 5, 10, 10);
            canvas.fillRect(secondPoint.x - 5, secondPoint.y - 5, 10, 10);
            canvas.fillRect(thirdPoint.x - 5, thirdPoint.y - 5, 10, 10);
        }

    }

    public boolean containsFirstPoint(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean containsScondPoint(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(secondPoint.x - 5,
                secondPoint.y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean containsThirdPoint(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(thirdPoint.x - 5,
                thirdPoint.y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }
 @Override
    public void resize(Point p) {
        if (containsFirstPoint(getDraggingPoint())) {
            setPosition(p);
        } else if (containsScondPoint(getDraggingPoint())) {
            setSecondPoint(p);
        }else if (containsThirdPoint(getDraggingPoint())) {
            setThirdPoint(p);
        }
    }
    @Override
    public boolean contains(Point p) {
        int xPoints[] = new int[]{getPosition().x, secondPoint.x, thirdPoint.x};
        int yPoints[] = new int[]{getPosition().y, secondPoint.y, thirdPoint.y};

        Polygon poly = new Polygon(xPoints, yPoints, 3);

        return poly.contains(p);
    }

    @Override
    public void moveTo(Point p) {
        int xdiff = p.x - getDraggingPoint().x;
        int ydiff = p.y - getDraggingPoint().y;
        secondPoint = new Point(secondPoint.x + xdiff, secondPoint.y + ydiff);
        thirdPoint = new Point(thirdPoint.x + xdiff, thirdPoint.y + ydiff);
        setPosition(new Point(getPosition().x + xdiff, getPosition().y + ydiff));

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Point pos = new Point(getPosition().x, getPosition().y);
        Triangle t = new Triangle(pos, secondPoint, thirdPoint);
        t.setColor(getColor());
        t.setFillColor(getFillColor()); 
        return t;
    }
}
