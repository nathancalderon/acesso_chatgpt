import javax.swing.JOptionPane;

public class Indice {
   public static void main(String[]args) throws Exception{
        
        int opcoes = 1;
        
        while(opcoes != 0){

            opcoes = Integer.parseInt(JOptionPane.showInputDialog(
                "Digite a opção desejada:\n1-Traduzir texto para português\n2-Gerar emojis relacionado a um filme\n3-Fazer uma explicação que uma criança entenda\n0-Sair"));

            switch(opcoes){
                case 1:
                    AppTraducao.main(args);
                break;
                case 2:
                    AppEmoji.main(args);
                break;
                case 3:
                    AppCrianca.main(args);
                break;
                default:
                    System.out.println("Opção Inexistente");
                break;
            }
        } 
    }
}
