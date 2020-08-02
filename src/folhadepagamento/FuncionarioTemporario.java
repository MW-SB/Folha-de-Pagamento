package folhadepagamento;
/**
 *
 * @author murilo
 */
public class FuncionarioTemporario extends Funcionario{
    private double valorMensal;

    public FuncionarioTemporario(int codigo, double salario, int tempo) {
        super(codigo, salario, tempo);
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }
    
    public double calcular_salario(){
        int adicionar = 0;
        for (Dependente dep : this.dependentes) {
            if(dep.idade < 18){
                adicionar += 1;
            }
        }
        valorMensal = (getTempo() * 15 + getSalario()) + (adicionar*100);
        return valorMensal;
    }
    
    public void exibirTemporario() {
        System.out.println("Informações do funcionário Concursado: ");
        System.out.println("Código: " + getCodigo());
        System.out.println("Salário base: " + getSalario());
        System.out.println("Tempo: " + getTempo());
        int adicionar = 0;
        int contagem = 0;
        for (Dependente dep : this.dependentes) {
            contagem += 1;
            if(dep.idade < 18){
                adicionar += 1;
            }
        }
        System.out.println("Numero de dependentes: " + contagem);
        if(adicionar == 0){
            System.out.println("Você não terá nenhum acrescimo sobre os dependentes.");
        } else {
            System.out.println("Numero de dependentes que recebem o beneficio: " + adicionar);
            System.out.println("Valor acrescido em virtude dos dependentes: " + adicionar*50);
        }
        System.out.println("Valor mensal: " + this.calcular_salario());
    }
}
