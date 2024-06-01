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

public class AppEmoji {
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties"));
        final String OPENAI_API_KEY = 
            properties.getProperty("OPENAI_API_KEY");
        // instanciar o ChatGPTEmoji
        var chatGPTEmoji = new ChatGPTEmoji();
        //Solicitar um nome de filme ao usuário
       
        String nomeDoFilme = JOptionPane.showInputDialog("Digite um filme para a geração de 3 emojis: ");
        //Chamar o método gerarEmoji, obter o resultado
        String s = chatGPTEmoji.gerarEmoji(
            OPENAI_API_KEY, 
            nomeDoFilme
        );
        //e exibir
        // ImageIcon icon = new ImageIcon("src/downloads/stitch.png");
        JPanel panel = new JPanel();
        panel.setBackground(new Color(153, 51, 153));
        panel.setSize(new Dimension(200, 64));
        panel.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        panel.setLayout(null);
        
        JLabel label = new JLabel(s);
        label.setForeground(Color.pink);
        label.setBounds(0, 0, 200, 64);
        label.setFont(new Font("text-davinci-003", Font.BOLD, 48));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        UIManager.put("OptionPane.minimumSize",new Dimension(300, 120));        
        JOptionPane.showMessageDialog(null, panel, "Emojis", JOptionPane.PLAIN_MESSAGE, null);
        // JOptionPane.showMessageDialog(null, s);
    }
}
