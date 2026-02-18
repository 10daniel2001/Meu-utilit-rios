/*Esse programa e apenas para eu lancar na minha tela e ficar visivel */


import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RelogioGUI extends JFrame{

    private JLabel label;


            public RelogioGUI(){
                label = new JLabel();
                label.setFont(new Font("Arial", Font.BOLD, 50));
                label.setHorizontalAlignment(SwingConstants.CENTER);


                add(label);
              
                setTitle("Relógio");
                setSize(400, 200);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
 
                 atualizarRelogio();
               
            }


    private void atualizarRelogio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        new Timer(1000, e -> {
            LocalTime agora = LocalTime.now();
            label.setText(agora.format(formatter));
        }).start();
    }


  public static void main(String[] args) {
        new RelogioGUI();
    }


}
