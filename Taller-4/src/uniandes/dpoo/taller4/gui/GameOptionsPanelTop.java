package uniandes.dpoo.taller4.gui;

import javax.swing.*;
import java.awt.*;

public class GameOptionsPanelTop extends JPanel {
    private final JLabel sizeLabel;
    private final JComboBox<String> sizeOptions;
    private final JLabel difficultLabel;
    private final JRadioButton[] difficultButtons;
    private final ButtonGroup difficultButtonGroup;

    public GameOptionsPanelTop(){
        sizeLabel = new JLabel("Table size: ");
        sizeLabel.setForeground(Color.WHITE);
        sizeOptions = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"});
        difficultLabel = new JLabel("Difficult: ");
        difficultLabel.setForeground(Color.WHITE);
        difficultButtons = new JRadioButton[]{new JRadioButton("Easy"), new JRadioButton("Medium"), new JRadioButton("Hard")};
        difficultButtons[0].setSelected(true);
        difficultButtonGroup = new ButtonGroup();
        setForeground(Color.WHITE);
        setBackground(new Color(0x2A88DE));
        setAlignmentX(0.5f);
    }
    public void init(){
        add(sizeLabel);
        add(sizeOptions);
        add(difficultLabel);
        for (JRadioButton button: difficultButtons){
            button.setBackground(new Color(0x2A88DE));
            button.setForeground(Color.WHITE);
            difficultButtonGroup.add(button);
            add(button);
        }
    }
    public int getSizeOption(){
        return sizeOptions.getSelectedIndex() + 5;
    }


    public int getDifficultOption() {
        if (difficultButtons[0].isSelected()){
            return 5;
        } else if (difficultButtons[1].isSelected()) {
            return 10;
        } else if (difficultButtons[2].isSelected()) {
            return 15;
        }
        return 0;
    }
}
