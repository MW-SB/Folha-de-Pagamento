package folhadepagamento;

import java.util.ArrayList;
/**
 *
 * @author murilo
 */
public class Funcionario {
    private int codigo;
    private double salario;
    private int tempo;
    
    public ArrayList<Dependente> dependentes = new ArrayList();
    
    public Funcionario(int codigo, double salario, int tempo) {
        this.codigo = codigo;
        this.salario = salario;
        this.tempo = tempo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    public boolean adicionarDependente(Dependente dep){
        if(dependentes.size() < 5) {
            dependentes.add(dep);
            return true;
        } else {
            System.out.println("Você excedeu o limite de cadastro de dependentes.");
            return false;
        }
    }
}
