package folhadepagamento;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author murilo
 */
public class FolhaDePagamento {
    public static ArrayList<FuncionarioConcursado> funcionarioConcursado = new ArrayList();
    public static ArrayList<FuncionarioTemporario> funcionarioTemporario = new ArrayList();
    ArrayList<Dependente> dependentes = new ArrayList();

    public static void main(String[] args) {                
        Scanner teclado = new Scanner(System.in);
        funcionarioConcursado = new ArrayList<>();
        funcionarioTemporario = new ArrayList<>();
        
        System.out.print("Digite o numero de funcionários você deseja cadastrar: ");
        int numFuncionarios = teclado.nextInt();
        
        for (int i = 0; i < numFuncionarios; i++) {
            System.out.println("Funcionários");
            System.out.println("=============");
            System.out.print("Digite o código:");
            int codigo = teclado.nextInt();
            System.out.print("Digite seu salário base: ");
            double salarioBase = teclado.nextDouble();
            System.out.println("Informe o tipo de Funcionário:");
            System.out.println("1 - Concursado");
            System.out.println("2 - Temporário");
            int tipo = teclado.nextInt();
            
            ArrayList<Dependente> dependentes = new ArrayList();
            
            System.out.print("Digite o numero de dependentes associados a esse funcionário:");
            int n = teclado.nextInt();
            
            for (int j = 0; j < n; j++) {
                System.out.print("Informe a idade do dependente: ");
                int idade = teclado.nextInt();
                
                Dependente dep = new Dependente(idade);
                
                dependentes.add(dep);
                
            }
            
            if(tipo == 1){
                System.out.print("Digite o tempo de exercicio desse funcionario(em anos):");
                int tempo = teclado.nextInt();
                
                FuncionarioConcursado concursado = new FuncionarioConcursado(codigo, salarioBase, tempo);
                
                for(Dependente dep : dependentes){
                    concursado.adicionarDependente(dep);
                }
                
                funcionarioConcursado.add(concursado);
                
                
            } else {
                System.out.print("Digite o tempo de exercicio desse funcionario(em meses):");
                int tempo = teclado.nextInt();
                
                FuncionarioTemporario temporario = new FuncionarioTemporario(codigo, salarioBase, tempo);
                
                for(Dependente dep : dependentes){
                    temporario.adicionarDependente(dep);
                }
                
                funcionarioTemporario.add(temporario);
            }
        }
        
        System.out.println("======================================================");
        
        funcionarioConcursado.forEach((funcionario) -> {
            funcionario.exibirConcursado();
        });
        
        System.out.println("=====================================================");
        
        funcionarioTemporario.forEach((funcionario) -> {
            funcionario.exibirTemporario();
        });
    }
    
}
