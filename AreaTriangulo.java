
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaTriangulo extends JFrame {

    private JTextField campoBase, campoAltura;
    private JLabel resultado;
    private JButton calcularBtn;

    // Método construtor (estilização)
    public AreaTriangulo() {
        setTitle("Área do Triângulo");
        setSize(400, 300); // Tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        setLocationRelativeTo(null); // Centraliza a janela
        setLayout(null);

        getContentPane().setBackground(new Color(255, 255, 255));

        //titulo
        JLabel titulo = new JLabel("Area do Tiangulo");
        titulo.setFont(new Font("Poppins", Font.BOLD, 20));
        titulo.setBounds(100, 20, 200, 25);
        add(titulo);

        // Adiciona os componentes
        JLabel labelB = new JLabel("Base: ");
        labelB.setFont(new Font("Poppins", Font.BOLD, 20));
        labelB.setBounds(40, 60, 80, 25); // x, y, largura, altura
        add(labelB);

        campoBase = new JTextField();
        campoBase.setFont(new Font("Poppins", Font.BOLD, 18));
        campoBase.setBounds(120, 60, 150, 25);
        add(campoBase);

        JLabel labelA = new JLabel("Altura: ");
        labelA.setFont(new Font("Poppins", Font.BOLD, 20));
        labelA.setBounds(40, 120, 80, 25);
        add(labelA);

        campoAltura = new JTextField();
        campoAltura.setFont(new Font("Poppins", Font.BOLD, 18));
        campoAltura.setBounds(120, 120, 150, 25);
        add(campoAltura);

        calcularBtn = new JButton("Calcular");
        calcularBtn.setFont(new Font("Poppins", Font.BOLD, 15));
        calcularBtn.setBounds(120, 180, 150, 35);
        add(calcularBtn);

        resultado = new JLabel("Area: ");
        resultado.setFont(new Font("Poppins", Font.BOLD, 15));
        resultado.setBounds(15, 232, 80, 40);
        add(resultado);

        //calculo
        calcularBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (campoBase.getText().trim().isEmpty() || campoAltura.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ops! Um dos campos está vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    double base = Double.parseDouble(campoBase.getText());
                    double altura = Double.parseDouble(campoAltura.getText());
                    double area = (base * altura) / 2;
                    resultado.setText("Area: " + area);

                }
            }

        });

        //botao para voltar --> imagem 
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

        setVisible(true); // Torna a janela visível
    }

    // Método principal
    public static void main(String[] args) {
        new AreaTriangulo(); // Cria uma instância da janela
    }
}
