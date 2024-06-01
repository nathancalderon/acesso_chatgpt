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

public class AppTraducao {
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties"));
        final String OPENAI_API_KEY = 
            properties.getProperty("OPENAI_API_KEY");
        // instanciar o ChatGPTTraducao
        var chatGPTTraducao = new ChatGPTTraducao();
        //Solicitar texto ao usuário
        String texto = JOptionPane.showInputDialog("Digite um texto a ser traduzido: ");
        //Chamar o método traduzir, obter o resultado
        String s = chatGPTTraducao.traduzir(
            OPENAI_API_KEY, 
            texto
        );
        //e exibir
        JPanel panel = new JPanel();
        panel.setBackground(new Color(153, 50, 204));
        panel.setSize(new Dimension(200, 64));
        panel.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        panel.setLayout(null);
        
        JLabel label = new JLabel(s);
        label.setForeground(Color.black);
        label.setBounds(0, 0, 550, 200);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        UIManager.put("OptionPane.minimumSize",new Dimension(600, 250));        
        JOptionPane.showMessageDialog(null, panel, "Tradução", JOptionPane.PLAIN_MESSAGE, null);
        // JOptionPane.showMessageDialog(null, s);
    }
}
