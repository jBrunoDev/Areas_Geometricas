import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lista_ extends JFrame implements ActionListener {
    private JButton btnTriangulo, btnQuadrado, btnCirculo;

    public Lista_() {
        setTitle("Áreas Geométricas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal com fundo arredondado
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };
        panel.setLayout(new GridBagLayout()); // Define layout para centralizar os componentes
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titulo = new JLabel("Áreas Geométricas");
        titulo.setFont(new Font("Poppins", Font.BOLD, 20));
        titulo.setHorizontalAlignment(JLabel.CENTER); // Centraliza o título

        // Painel separado para alinhar os botões verticalmente
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new GridLayout(3, 1, 10, 10)); // Layout com 3 linhas, 1 coluna
        botoesPanel.setOpaque(false); // Deixa o painel transparente para combinar com o fundo

        // Criando os botões
        btnTriangulo = criarBotao("Área Triângulo");
        btnQuadrado = criarBotao("Área Quadrado");
        btnCirculo = criarBotao("Área Círculo");

        // Adicionando botões ao painel
        botoesPanel.add(btnTriangulo);
        botoesPanel.add(btnQuadrado);
        botoesPanel.add(btnCirculo);

        // Configuração do layout do painel principal
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Define a posição no layout
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0); // Espaçamento entre o título e os botões
        panel.add(titulo, gbc); // Adiciona o título ao painel

        gbc.gridy = 1; // Move para a próxima linha
        panel.add(botoesPanel, gbc); // Adiciona o painel de botões

        add(panel, BorderLayout.CENTER); // Adiciona o painel ao frame principal

        setVisible(true); // Torna a janela visível
    }

    // Método auxiliar para criar botões com estilo personalizado
    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.PLAIN, 14)); // Define a fonte e tamanho do texto do botão
        botao.setBackground(new Color(44, 62, 80)); // Define a cor do fundo do botão (azul escuro)
        botao.setForeground(Color.WHITE); // Define a cor do texto do botão (branco)
        botao.setFocusPainted(false); // Remove a borda de foco ao clicar
        botao.addActionListener(this); // Adiciona um evento de clique ao botão
        return botao; // Retorna o botão já configurado
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Verifica qual botão foi pressionado e exibe uma mensagem correspondente
        if (e.getSource() == btnTriangulo) {
           new AreaTriangulo();
           dispose();
        } else if (e.getSource() == btnQuadrado) {
            new AreaQuadrado();
            dispose();
        } else if (e.getSource() == btnCirculo) {
            new AreaCirculo();
            dispose();
        }
    }

    public static void main(String[] args) {
        new Lista_(); // Cria a interface ao iniciar o programa
    }
}
