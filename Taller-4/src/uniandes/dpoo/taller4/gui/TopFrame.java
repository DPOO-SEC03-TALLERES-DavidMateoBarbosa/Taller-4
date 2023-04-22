package uniandes.dpoo.taller4.gui;

import uniandes.dpoo.taller4.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class TopFrame extends JFrame {
    private final Top10 top10;
    private JList<String> top;
    private final JPanel center;
    public TopFrame(Top10 top10){
        setLayout(new BorderLayout());
        setResizable(false);
        this.top10 = top10;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        top10.cargarRecords(new File("./data/top10.csv"));
        updateTop();
        setSize(100, 270);
        center = new JPanel();
        JPanel toptop = new JPanel();
        toptop.setBackground(new Color(0x469ADE));
        toptop.add(new JLabel("Player - Points"));
        center.add(top);
        add(center, BorderLayout.CENTER);
        add(toptop, BorderLayout.NORTH);
    }

    public void updateTop() {
        ArrayList<RegistroTop10> registers =  new ArrayList<>(top10.darRegistros());
        String[] infos = new String[10];
        for (int index = 0; index < infos.length; index ++){
            if (index > registers.size())
                infos[index] = index + 1 + " N?A.....0";
            else
                infos[index] = index + 1 + ". " + registers.get(index).darNombre() + "....." + registers.get(index).darPuntos();
        }
        top = new JList<>(infos);
        top.setBackground(new Color(0xECECED));
        top.setSize(100, 270);
        top.setSelectionBackground(Color.BLACK);
        top.setSelectionForeground(Color.RED);
    }
}
