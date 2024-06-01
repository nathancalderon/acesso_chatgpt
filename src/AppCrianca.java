import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AppCrianca {
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties"));
        final String OPENAI_API_KEY = 
            properties.getProperty("OPENAI_API_KEY");
        // instanciar o ChatGPTCrianca
        var chatGPTCrianca = new ChatGPTCrianca();
        //Solicitar uma pergunta ao usuário
        String pergunta = JOptionPane.showInputDialog("Faça uma pergunta: ");
        //Chamar o método gerarExplicacao, obter o resultado
        String s = chatGPTCrianca.gerarExplicacao(
            OPENAI_API_KEY,
            pergunta
        );
        //e exibir
        JPanel panel = new JPanel();
        panel.setBackground(new Color(216, 191, 216));
        panel.setSize(new Dimension(200, 64));
        panel.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        panel.setLayout(null);
        
        JLabel label = new JLabel(s);
        label.setForeground(Color.black);
        label.setBounds(0, 0, 800, 150);
        label.setFont(new Font("text-davinci-003", Font.BOLD, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        UIManager.put("OptionPane.minimumSize",new Dimension(800, 150));        
        JOptionPane.showMessageDialog(null, panel, "Resposta", JOptionPane.PLAIN_MESSAGE, null);
        // JOptionPane.showMessageDialog(null, s);
    }
}
