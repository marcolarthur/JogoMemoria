/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogomemoria;




/**
 *
 * @author Arthur
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;

public class JogoMemoria {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Integer[] arr = new Integer[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        JTextField text = new JTextField("Text Field Vazio");
        JFrame frame = new JFrame("Jogo da Memória");
        frame.setLayout(new BorderLayout());      
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 5, 10, 5));
        for(int i=0; i<20; i++){
            String localDir = System.getProperty("user.dir");
            JLabel imgLabelvetor = new JLabel(new ImageIcon("imgs\\(20).jpg"));
            JLabel imgLabelvetor1 = new JLabel(new ImageIcon("imgs\\(20).jpg"));
            imgLabelvetor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            imgLabelvetor.setName(Integer.toString(arr[i]));
            imgLabelvetor.setPreferredSize(new Dimension(100,100));
            imgLabelvetor.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    Component label1 = e.getComponent();
                    if (label1 instanceof JLabel){
                        if(((JLabel) label1).getIcon().toString().equals(imgLabelvetor1.getIcon().toString())){     
                        if (label1 instanceof JLabel){
                            ((JLabel) label1).setIcon(new ImageIcon("imgs\\("+ e.getComponent().getName() +").jpg"));
                        }
                        SwingUtilities.updateComponentTreeUI(panel);
                        SwingUtilities.updateComponentTreeUI(frame);
                        }else{
                            if (label1 instanceof JLabel){
                                ((JLabel) label1).setIcon(new ImageIcon("imgs\\(20).jpg"));
                                SwingUtilities.updateComponentTreeUI(panel);
                                SwingUtilities.updateComponentTreeUI(frame);
                            }
                        }
                    }
                }
               });

            panel.add(imgLabelvetor);
        }
        frame.add(text, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);      
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(false);
        frame.pack();
        frame.setVisible(true);      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}



    

    


 