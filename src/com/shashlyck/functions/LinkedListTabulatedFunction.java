package com.shashlyck.functions;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {

    @Override
    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            private Node node = head;

            public boolean hasNext() {
                return node != null;
            }

            public Point next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Point point = new Point(node.x, node.y);
                if (node != head.prev) {
                    node = node.next;
                } else {
                    node = null;
                }
                return point;
            }
        };
    }

    public static class Node implements Serializable {

        Node next;
        Node prev;
        double x;
        double y;
    }

    private Node head;

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length < 2) {
            throw new IllegalArgumentException("the number of points is less than two");
        }
        for (int i = 0; i < xValues.length; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count){
        if (count < 2) {
            throw new IllegalArgumentException("the number of points is less than two");
        }
        if (xFrom > xTo) {
            double xOdds;
            xOdds = xFrom - xTo;
            xTo = xTo + xOdds;
            xFrom = xFrom - xOdds;
        }

        double step = (xTo - xFrom) / (count - 1);
        double x = xFrom;
        if (xFrom != xTo) {
            for (int i = 0; i < count; i++) {
                this.addNode(x, source.apply(x));
                x = x + step;
            }
        } else {
            for (int i = 0; i < count; i++) {
                this.addNode(xFrom, source.apply(xFrom));
            }
        }
    }

    protected void addNode(double x, double y) {
        Node node = new Node();
        node.x = x;
        node.y = y;
        if (head == null) {
            head = node;
            node.next = node;
            node.prev = node;
        } else {
            node.prev = head.prev;
            node.next = head;
            head.prev.next = node;
        }
        head.prev = node;
        count++;
    }

    protected Node getNode(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        Node node;
        if (index > (count / 2)) {
            node = head.prev;
            for (int i = count - 1; i > 0; i--) {
                if (i == index) return node;
                else node = node.prev;
            }
        } else {
            node = head;
            for (int i = 0; i < count; i++) {
                if (index == i) {
                    return node;
                } else {
                    node = node.next;
                }
            }
        }
        return node;
    }

    private Node nodeOfX(double x) {
        Node node = head;

        for (int i = 0; i < count; i++)
            if (node.x == x) return node;
            else node = node.next;

        throw new UnsupportedOperationException();
    }

    private Node floorNodeOfX(double x){
        if (x < head.x) {
            throw new IllegalArgumentException("the argument x is less than the minimum x in the function");
        }
        Node node = head;
        for (int i = 0; i < count; i++)
            if (node.x < x) node = node.next;
            else return node.prev;
        return head.prev;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double leftBound() {
        return head.x;
    }

    @Override
    public double rightBound() {
        return head.prev.x;
    }

    @Override
    public double getX(int index)  {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        return getNode(index).x;
    }

    @Override
    public double getY(int index){
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("index y out of bounds");
        }
        return getNode(index).y;
    }

    @Override
    public void setY(int index, double value) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        getNode(index).y = value;
    }

    @Override
    public int indexOfX(double x) {
        Node node;
        node = head;
        for (int i = 0; i < count; i++) {
            if (node.x == x) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        Node node;
        node = head;
        for (int i = 0; i < count; i++) {
            if (node.y == y) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int floorIndexOfX(double x){
        if (x < head.x) {
            throw new IllegalArgumentException("the argument x is less than the minimum x in the function");
        }
        Node node;
        node = head;
        for (int i = 0; i < count; i++) {
            if (node.x < x) {
                node = node.next;
            } else {
                return i - 1;
            }
        }
        return getCount();
    }

    @Override
    public double extrapolateLeft(double x) {
        return interpolate(x, head.x, head.next.x, head.y, head.next.y);
    }

    @Override
    public double extrapolateRight(double x) {
        return interpolate(x, head.prev.prev.x, head.prev.x, head.prev.prev.y, head.prev.y);
    }

    @Override
    public double interpolate(double x, int floorIndex) {
        Node left = getNode(floorIndex);
        Node right = left.next;
        return interpolate(x, left.x, right.x, left.y, right.y);
    }

    @Override
    public double apply(double x) {
        if (x < leftBound()) {
            return extrapolateLeft(x);
        } else if (x > rightBound()) {
            return extrapolateRight(x);
        } else try {
            return nodeOfX(x).y;
        } catch (UnsupportedOperationException e) {
            Node left = floorNodeOfX(x);
            Node right = left.next;
            return super.interpolate(x, left.x, right.x, left.y, right.y);
        }
    }
}
