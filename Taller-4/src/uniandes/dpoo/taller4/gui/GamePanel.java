package uniandes.dpoo.taller4.gui;


import uniandes.dpoo.taller4.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel{
    private Tablero board;
    private Graphics2D drawer;
    private int ratio;

    public GamePanel(){
        setLayout(new GridLayout());
        setBackground(Color.BLACK);
        board = new Tablero(5);
        board.desordenar(5);
    }
    public void paint(Graphics graphics){
        super.paint(graphics);
        drawer = (Graphics2D) graphics;
        ratio = 0;
        drawGameBoard();

    }
    public void init(){
    }
    public void drawGameBoard(){
        if (board.darTablero().length == 5) ratio = 84;
        else if (board.darTablero().length == 6) ratio = 70;
        else if (board.darTablero().length == 7) ratio = 60;
        for (int i = 0; i < board.darTablero().length; i ++){
            for (int j = 0; j < board.darTablero().length; j ++){
                Rectangle2D rectangle2D = new Rectangle2D.Double(ratio*i, ratio*j, ratio + ratio*i, ratio + ratio*j);
                drawer.setColor((board.darTablero()[i][j])? new Color(0x383838) : new Color(0xfffc00));
                drawer.fill(rectangle2D);
                drawer.draw(rectangle2D);
                drawer.setColor(new Color(0xBDBDBD));
                drawer.drawRect(ratio*i, ratio*j, ratio + ratio*i, ratio + ratio*j);
            }
        }
    }
    public void play(int x, int y){
        board.jugar(x, y);
        repaint();
    }
    public void restart(){
        board.reiniciar();
        repaint();
    }
    public void newGame(int size, int difficult){
        board = new Tablero(size);
        board.desordenar(difficult);
        repaint();
    }

    public boolean won(){
        for (boolean[] row : board.darTablero()){
            for (boolean cell: row){
                if (!cell)return false;
            }
        }
        return true;
    }

    public int getPlays(){
        return board.darJugadas();
    }
    public Tablero getBoard(){
        return board;
    }
    public int getRatio(){
        return ratio;
    }
}
