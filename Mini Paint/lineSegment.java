/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;

/**
 *
 * @author ADMIN
 */
public class lineSegment extends abstractShape {

    private Point endpt;

    public lineSegment(Point position, Point endpt) {
        super(position);
        this.endpt = endpt;
    }

    public void setEndpt(Point endpt) {
        this.endpt = endpt;
    }

    /**
     *
     * @return
     */
    public Point getEndpt() {
        return endpt;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getColor());
        canvas.drawLine((int) getPosition().getX(), (int) getPosition().getY(), (int) endpt.getX(), (int) endpt.getY());
        if (isSelected()) {
            canvas.setColor(Color.BLACK);
            canvas.fillRect((int) getPosition().getX() - 5, (int) getPosition().getY() - 5, 10, 10);
            canvas.fillRect(endpt.x - 5, endpt.y - 5, 10, 10);
        }
    }

    @Override
    public void moveTo(Point p) {
        int xdiff = p.x - getPosition().x;
        int ydiff = p.y - getPosition().y;
        endpt = new Point(endpt.x + xdiff, endpt.y + ydiff);
        setPosition(new Point(getPosition().x + xdiff, getPosition().y + ydiff)); //??
    }

    @Override
    public boolean contains(Point p) {
        int x1, y1, x2, y2;
        x1 = getPosition().x;
        y1 = getPosition().y;
        x2 = endpt.x;
        y2 = endpt.y;
        Line2D.Float L = new Line2D.Float(x1, y1, x2, y2);
        double distance = L.ptSegDist(p); //dist bet line and pt
        if (distance < 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void resize(Point p) {
        if (containsFirstPoint(getDraggingPoint())) {
            setPosition(p);
        } else if (containsScondPoint(getDraggingPoint())) {
            setEndpt(p);
        }
    }

    public boolean containsFirstPoint(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean containsScondPoint(Point p) {    //msh endpt.x sa7?
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(endpt.x - 5,
                endpt.y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Point pos = new Point(getPosition().x, getPosition().y);
        lineSegment l = new lineSegment(pos, endpt);
        l.setColor(getColor());
        l.setFillColor(getFillColor());
        return l;
    }
}
