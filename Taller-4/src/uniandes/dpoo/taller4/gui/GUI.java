package uniandes.dpoo.taller4.gui;

import uniandes.dpoo.taller4.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUI extends JFrame implements ActionListener, MouseListener  {
    private final GameOptionsPanelTop gameOptionsPanelTop;
    private final GamePanel gamePanel;
    private final GameOptionsPanelRight gameOptionsPanelRight;
    private final GameInfoPanel gameInfoPanel;
    private final Top10 top10;
    private final TopFrame top10Frame;
    public GUI()  {
        top10 = new Top10();

        top10.cargarRecords(new File("./data/top10.csv"));
        top10Frame = new TopFrame(top10);
        setTitle("Lights Out");
        setIconImage(new ImageIcon("./data/luz.png").getImage());
        setSize(145 + 420 , 104 + 420);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.LIGHT_GRAY);
        gameOptionsPanelTop = new GameOptionsPanelTop();
        gameOptionsPanelTop.init();
        add(gameOptionsPanelTop, BorderLayout.NORTH);
        gamePanel = new GamePanel();
        gamePanel.init();
        add(gamePanel, BorderLayout.CENTER);
        gameOptionsPanelRight = new GameOptionsPanelRight();
        gameOptionsPanelRight.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        gameOptionsPanelRight.init();
        add(gameOptionsPanelRight, BorderLayout.EAST);
        gameInfoPanel = new GameInfoPanel();
        gameInfoPanel.init();
        add(gameInfoPanel, BorderLayout.SOUTH);
        gameInfoPanel.setPlays(gamePanel.getPlays());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                try {
                    top10.salvarRecords(new File("./data/top10.csv"));
                } catch (FileNotFoundException | UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        setVisible(true);
        //GAME OPTIONS INITS
        gameOptionsPanelRight.getButton("new").addActionListener(this);
        gameOptionsPanelRight.getButton("restart").addActionListener(this);
        gameOptionsPanelRight.getButton("top10").addActionListener(this);
        gameOptionsPanelRight.getButton("change").addActionListener(this);
        gameInfoPanel.setPlays(gamePanel.getPlays());
        gamePanel.addMouseListener(this);

    }
    public static void main(String[] args){
        new GUI();

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == gameOptionsPanelRight.getButton("new")){
            if (gameInfoPanel.getBoxInfo().equals(""))
                JOptionPane.showMessageDialog(this, "No player name provided", "WARNING", JOptionPane.WARNING_MESSAGE);
            else {
                if (gameInfoPanel.getBoxInfo().length() != 3){
                    JOptionPane.showMessageDialog(this, "player name length only can be a 3 length", "WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (gamePanel.won()) {
                    top10.agregarRegistro(gameInfoPanel.getBoxInfo(), gamePanel.getBoard().calcularPuntaje());
                    top10Frame.updateTop();
                }
                gamePanel.newGame(gameOptionsPanelTop.getSizeOption(), gameOptionsPanelTop.getDifficultOption());
                gameInfoPanel.setPlays(gamePanel.getPlays());
            }
        }
        else if (event.getSource() == gameOptionsPanelRight.getButton("change")){
            gameInfoPanel.setAvailable(true);
        }
        else if (event.getSource() == gameOptionsPanelRight.getButton("restart")) {
            gamePanel.restart();
            gameInfoPanel.setPlays(gamePanel.getPlays());
        } else if (event.getSource() == gameOptionsPanelRight.getButton("top10")) {
            top10Frame.setLocationRelativeTo(this);
            top10Frame.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        return;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        int x = event.getX() / gamePanel.getRatio();
        int y = event.getY() / gamePanel.getRatio();
        gamePanel.play(x, y);
        gameInfoPanel.setPlays(gamePanel.getPlays());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }
}
