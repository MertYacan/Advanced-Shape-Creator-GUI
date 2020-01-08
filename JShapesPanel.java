/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mert;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Mert Yacan
 */
public class JShapesPanel extends JPanel {

    int height = 500;
    int width = 500;
    ArrayList<Shape> sekillerr;

    JShapesPanel() {
        super();
        setBackground(Color.white);
    }

    public void addCrazyShapesInsýde(ArrayList<Shape> aaa) {
        this.sekillerr = aaa;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Shape> sekillerr = new ArrayList<Shape>();
        Colors.addColor("Blue");
        Colors.addColor("Red");
        Colors.addColor("Green");
        Colors.addColor("Pink");
        Colors.addColor("Black");
        int circle = 0;
        int rectangle = 0;
        int triangle = 0;
        Graphics2D ga = (Graphics2D) g;
        for (int i = 0; i < 10; i++) {
            double randomizer = Math.random();
            try {
                if (randomizer < 0.33) {
                    rectangle++;
                    String nameNumber = String.format("%03d", rectangle);
                    //Rectangle- + XXX format
                    String name = "Rectangle-" + nameNumber;
                    sekillerr.add(new Rectangle((int) (Math.random() * 200), (int) (Math.random() * 200), Colors.getRandomColor(), name));
                } else if (randomizer < 0.66) {
                    circle++;
                    String nameNumber = String.format("%03d", circle);
                    //Circle- + XXX format
                    String name = "Circle-" + nameNumber;
                    sekillerr.add(new Circle((int) (Math.random() * 200), Colors.getRandomColor(), name));
                } else {
                    triangle++;
                    String nameNumber = String.format("%03d", triangle);
                    //Triangle- + XXX format
                    String name = "Triangle-" + nameNumber;
                    sekillerr.add(new Triangle((int) (Math.random() * 100), (int) (Math.random() * 100), Colors.getRandomColor(), name));
                }
                sekillerr.get(i).info();
            } catch (UnknownColorException | WrongNameException A) {
                System.out.println(A.getMessage());
                i--;
            }
        }
         for(int i = 0; i<10 ; i++){
                if(sekillerr.get(i).getClass().equals(Circle.class)){
                        switch(sekillerr.get(i).colorNum){
                            case 1: ga.setPaint(Color.blue);
                                    break;
                            case 2: ga.setPaint(Color.red);
                                    break;
                            case 3: ga.setPaint(Color.green);
                                    break;
                            case 4: ga.setPaint(Color.pink);
                                    break;
                            case 5: ga.setPaint(Color.black);
                                    break;
                        }
                    int cir = (int) (sekillerr.get(i).circumference()/(Math.PI*2));
                    int x = (int) (cir + (width-cir)*(Math.random()));
                    int y = (int) (cir + (height-cir)*(Math.random()));
                    ga.fillOval(x,y,cir , cir);
                }
                if(sekillerr.get(i).getClass().equals(Rectangle.class)){
                        switch(sekillerr.get(i).colorNum){
                            case 1: ga.setPaint(Color.blue);
                                    break;
                            case 2: ga.setPaint(Color.red);
                                    break;
                            case 3: ga.setPaint(Color.green);
                                    break;
                            case 4: ga.setPaint(Color.pink);
                                    break;
                            case 5: ga.setPaint(Color.black);
                                    break;
                        }
                    int recWidth = sekillerr.get(i).getX();
                    int recHeight = sekillerr.get(i).getY();
                    int x = (int) (recWidth + (width-recWidth)*(Math.random()));
                    int y = (int) (recHeight + (height-recHeight)*(Math.random()));
                    ga.fillRect(x,y,recWidth , recHeight);
                }
                if(sekillerr.get(i).getClass().equals(Triangle.class)){
                        switch(sekillerr.get(i).colorNum){
                            case 1: ga.setPaint(Color.blue);
                                    break;
                            case 2: ga.setPaint(Color.red);
                                    break;
                            case 3: ga.setPaint(Color.green);
                                    break;
                            case 4: ga.setPaint(Color.pink);
                                    break;
                            case 5: ga.setPaint(Color.black);
                                    break;
                        }
                    int recWidth = sekillerr.get(i).getX();
                    int recHeight = sekillerr.get(i).getY();
                    int x = (int) (recWidth + (width-recWidth*2)*(Math.random()));
                    int y = (int) (recHeight + (height-recHeight)*(Math.random()));
                    int[] xs = {x, x+recWidth, x+recWidth*2};
                    int[] ys = {y, y-recHeight, y};
                    ga.fillPolygon(xs, ys, 3);
                }
            }
        }

    }
