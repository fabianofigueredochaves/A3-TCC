import java.util.Scanner;

public class ProgramaCompilado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int AA = 10;
        String nome = "fabiano";
        int idade;
        idade = 36+85;
        idade = 76-35;
        idade = 80*5;
        double idades;
        idades = 80/5;
        double y = 5.5;
        System.out.println("Valor de x: "+1);
        System.out.println("Valor de y: "+y);
        System.out.println("Digite seu apelido: ");
        String apelido;
        apelido = scanner.nextLine();
        System.out.println("Digite sua idade: ");
        idade = scanner.nextInt();
        System.out.println("Digite seu salário: ");
        double salario;
        salario = scanner.nextDouble();
        System.out.println("===================================");
        System.out.println("Dados informados:");
        System.out.println("Nome: "+nome);
        System.out.println("Idade: "+idade);
        System.out.println("Salário: "+salario);
    }
}

