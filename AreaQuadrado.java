
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaQuadrado extends JFrame {

    private JTextField campoLado;
    private JLabel resultado;
    private JButton calcularBtn;

    public AreaQuadrado() {
        setTitle("Area do quadrad");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //cor
        getContentPane().setBackground(new Color(255, 255, 255));

        //Titulo
        JLabel titulo = new JLabel("Area do Quadrado");
        titulo.setFont(new Font("Poppins", Font.BOLD, 20));
        titulo.setBounds(100, 20, 200, 25);
        add(titulo);

        //Text --> lado + campo de texto
        JLabel lado = new JLabel("Lado:");
        lado.setFont(new Font("Poppins", Font.BOLD, 25));
        lado.setBounds(40, 100, 80, 25);
        add(lado);

        campoLado = new JTextField();
        campoLado.setFont(new Font("Poppins", Font.BOLD, 20));
        campoLado.setBounds(120, 100, 150, 25);
        add(campoLado);

        //botao para calcular 
        calcularBtn = new JButton("Calcular");
        calcularBtn.setFont(new Font("Poppins", Font.BOLD, 20));
        calcularBtn.setBounds(120, 180, 150, 35);
        add(calcularBtn);

        //resulado
        resultado = new JLabel("Area: ");
        resultado.setFont(new Font("Poppins", Font.BOLD, 20));
        resultado.setBounds(15, 232, 200, 40);
        add(resultado);

        //area para fazer o calculo
        calcularBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (campoLado.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Ops! O campo está vazio",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    double lado = Double.parseDouble(campoLado.getText());
                    double area = Math.pow(lado, 2);
                    resultado.setText("Area: " + area);

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
        new AreaQuadrado();
    }
}
