package uniandes.dpoo.taller4.gui;

import javax.swing.*;
import java.awt.*;

public class GameInfoPanel extends JPanel {
    private final JLabel playsLabel;
    private final JTextField plays;
    private final JLabel playerLabel;
    private final JTextField player;
    public GameInfoPanel(){
        setBackground(Color.LIGHT_GRAY);
        playsLabel = new JLabel("Plays: ");
        plays = new JTextField("0",10);
        plays.setEditable(false);
        playerLabel = new JLabel("Player: ");
        player = new JTextField("",10);
        player.setEditable(false);
    }

    public void init(){
        add(playsLabel);
        add(plays);
        add(playerLabel);
        add(player);
    }
    public void setPlays(int plays){
        this.plays.setText(String.valueOf(plays));
    }
    public void setAvailable(boolean status){
        player.setEditable(status);
    }
    public String getBoxInfo(){
        return player.getText();
    }
}
