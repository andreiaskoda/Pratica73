
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.ExecCmd;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica93 {
    public static void main(String[] args) {
        String comando = null;
        String a = null;
        boolean fim = true;
        List<ExecCmd> threads = new ArrayList<>();
        
        while(fim) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("comando> ");
            
            if(scanner.hasNext())
                comando = scanner.next();

            if(comando == "fim") {
                System.out.println("Há " + java.lang.Thread.activeCount() + 
                        " processos em execução. Deseja terminá-los? (s/n) ");

                a = scanner.next();

                if(a == "s") {
                    fim = false;
                    for(ExecCmd tr: threads){
                            tr.cancela();
                        }
                }
            }
            else {
                ExecCmd ex = new ExecCmd(comando);
                threads.add(ex);
            }
        }    
    }
}
