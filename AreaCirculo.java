
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaCirculo extends JFrame {

    private JTextField campoRaio;
    private JButton calcularBtn;
    private JLabel titulo;
    private JLabel raio;
    private JLabel resultado;

    public AreaCirculo() {
        setTitle("Area do Circulo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //cor do background
        getContentPane().setBackground(new Color(255, 255, 255));

        //titulo
        titulo = new JLabel("Area do Circulo");
        titulo.setFont(new Font("Poppins", Font.BOLD, 25));
        titulo.setBounds(100, 20, 200, 25);
        add(titulo);

        // label --> raio + campo de texto
        raio = new JLabel("Raio: ");
        raio.setFont(new Font("Poppins", Font.BOLD, 20));
        raio.setBounds(40, 100, 80, 25);
        add(raio);

        campoRaio = new JTextField();
        campoRaio.setFont(new Font("Poppins", Font.BOLD, 20));
        campoRaio.setBounds(120, 100, 150, 25);
        add(campoRaio);

        //resultado 
        resultado = new JLabel("Area: ");
        resultado.setFont(new Font("Poppins", Font.BOLD, 20));
        resultado.setBounds(15, 232, 200, 40);
        add(resultado);

        //botao 
        calcularBtn = new JButton("Cacular");
        calcularBtn.setFont(new Font("Poppins", Font.BOLD, 20));
        calcularBtn.setBounds(120, 180, 150, 35);
        add(calcularBtn);

        //eventos dos botoes --> calculo 
        calcularBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoRaio.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ops! o campo esta vazio", "ERRO", JOptionPane.ERROR_MESSAGE);
                } else {

                    double Raio = Double.parseDouble(campoRaio.getText());
                    double calculo = Math.PI * Math.pow(Raio, 2);
                    resultado.setText("Area: " + calculo);
                }

            }
        });

        ImageIcon icone = new ImageIcon(getClass().getResource("/Icon_Back.png"));

        //criar o botao com a imagem
        JButton botaoImg = new JButton(icone);
        botaoImg.setBounds(20, 20, 30, 20);
        botaoImg.setBorderPainted(false);  // Remove borda
        botaoImg.setContentAreaFilled(false);  // Remove fundo
        botaoImg.setFocusPainted(false);  // Remove borda de foco ao clicar
        botaoImg.setOpaque(false);  // Garante que o fundo não seja desenhado
        add(botaoImg);

        //quando clicar no botao de voltar, volta para a tela de inicio 
        botaoImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botaoImg) {
                    new Lista_();
                    dispose();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AreaCirculo();
    }
}
