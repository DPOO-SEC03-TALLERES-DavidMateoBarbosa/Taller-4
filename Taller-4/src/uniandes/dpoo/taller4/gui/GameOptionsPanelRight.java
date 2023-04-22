package uniandes.dpoo.taller4.gui;

import javax.swing.*;
import java.awt.*;

public class GameOptionsPanelRight extends JPanel{
    private final JButton newGame;
    private final JButton restartGame;
    private final JButton top10;
    private final JButton changePlayer;
    public GameOptionsPanelRight(){
        newGame = new JButton("NEW GAME");
        newGame.setForeground(Color.WHITE);
        newGame.setBackground(new Color(0x479BDF));
        newGame.setAlignmentY(JButton.CENTER_ALIGNMENT);
        restartGame = new JButton("RESTART");
        restartGame.setForeground(Color.WHITE);
        restartGame.setBackground(new Color(0x479BDF));
        restartGame.setAlignmentY(JButton.CENTER_ALIGNMENT);
        top10 = new JButton("TOP-10");
        top10.setForeground(Color.WHITE);
        top10.setBackground(new Color(0x479BDF));
        top10.setAlignmentY(JButton.CENTER_ALIGNMENT);
        changePlayer = new JButton("CHANGE PLAYER");
        changePlayer.setForeground(Color.WHITE);
        changePlayer.setBackground(new Color(0x479BDF));
        changePlayer.setAlignmentY(JButton.CENTER_ALIGNMENT);
        setBackground(new Color(0xBEBEBE));

    }
    public void init(){
        setLayout(new GridLayout(8, 1,20,10));

        add(newGame);
        add(restartGame);
        add(top10);
        add(changePlayer);
    }

    public JButton getButton(String name){
        return switch (name){
            case "new" ->  newGame;
            case "restart" -> restartGame;
            case "top10" -> top10;
            case "change" -> changePlayer;
            default -> null;
        };
    }
}
