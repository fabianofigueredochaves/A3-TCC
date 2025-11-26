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
        if (idade>18) {
        System.out.println("Você é maior de idade.");
        }
        else {
        System.out.println("Você é menor de idade.");
        }
        if (salario>2000.0) {
        System.out.println("Você tem um bom salário!");
        }
        int contador = 0;
        while (contador<3) {
        System.out.println("Loop enquanto - iteração: "+contador);
        contador = contador+1;
        }
    }
}

