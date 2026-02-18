import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CronometroGUI extends JFrame {

    private int horas = 0;
    private int minutos = 0;
    private int segundos = 0;

    private JLabel labelTempo;
    private Timer timer;

    public CronometroGUI() {

        setTitle("Cronômetro");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Label
        labelTempo = new JLabel("00:00:00", SwingConstants.CENTER);
        labelTempo.setFont(new Font("Arial", Font.BOLD, 30));

        // Botões
        JButton btnIniciar = new JButton("Iniciar");
        JButton btnPausar = new JButton("Pausar");
        JButton btnResetar = new JButton("Resetar");

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnIniciar);
        painelBotoes.add(btnPausar);
        painelBotoes.add(btnResetar);

        setLayout(new BorderLayout());
        add(labelTempo, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Timer (1 segundo)
        timer = new Timer(1000, (ActionEvent e) -> {
            incrementarTempo();
            atualizarLabel();
        });

        // Eventos
        btnIniciar.addActionListener(e -> timer.start());
        btnPausar.addActionListener(e -> timer.stop());
        btnResetar.addActionListener(e -> {
            timer.stop();
            horas = 0;
            minutos = 0;
            segundos = 0;
            atualizarLabel();
        });
    }

    private void incrementarTempo() {
        segundos++;

        if (segundos == 60) {
            segundos = 0;
            minutos++;
        }

        if (minutos == 60) {
            minutos = 0;
            horas++;
        }
    }

    private void atualizarLabel() {
        labelTempo.setText(String.format("%02d:%02d:%02d", horas, minutos, segundos));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CronometroGUI().setVisible(true);
        });
    }
}
