package simplenotepad;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SimpleNotepad
{
    public static void main(String[] args)
    {
         JFrame frame = new JFrame("");
         JMenuBar menuBar = new JMenuBar();
         JMenu menu = new JMenu("File");

         JMenuItem menuItem1 = new JMenuItem("Open");
         JMenuItem menuItem2 = new JMenuItem("Save");

         JTextArea textArea = new JTextArea();
         frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
         
         JLabel label = new JLabel("zhuzhenhao's notepad");
         label.setFont(new Font("宋体", Font.PLAIN, 20)); 
         label.setHorizontalAlignment(JLabel.RIGHT);
         frame.add(label, BorderLayout.SOUTH);

        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        textArea.read(new FileReader(selectedFile.getAbsolutePath()), null);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        
       menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter(fileToSave));
                        out.write(textArea.getText());
                        out.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
 
         menu.add(menuItem1);
         menu.add(menuItem2);
         menuBar.add(menu);
         frame.setJMenuBar(menuBar);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(800, 600);
         frame.setLocationRelativeTo(null);  
         frame.setVisible(true);
    }
}