import java.util.Scanner;

public class Empresa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        int horas;
        float[] salarios = new float[15];
        int cont100 = 0;
        float salarioMaiorMenor[] = new float[2];
        String nomeMaiorMenor[] = new String[2];
        int i = 0;
        char resposta;

        do {
            System.out.print("Nome do " + (i + 1) + "º funcionário: ");
            nome = receberNome(i + 1);

            horas = receberHoras(nome);

            salarios[i] = calcularSalario(horas, cont100);

            System.out.printf("Salário final do funcionário %s: R$ %.2f%n", nome, salarios[i]);

            avaliarMenorMaior(nome, salarios[i], salarioMaiorMenor, nomeMaiorMenor);

            i++;

            System.out.print("Deseja continuar? (S/N): ");
            resposta = scanner.next().charAt(0);

        } while (resposta == 'S' || resposta == 's');

        double mediaSalarial = calcularMediaSalarial(salarios);
        int qtdFuncionarios100Horas = contarFuncionarios100Horas(cont100);

        System.out.printf("Média geral de salário final: R$ %.2f%n", mediaSalarial);
        System.out.printf("Quantidade de funcionários com 100 horas trabalhadas ou mais: %d%n", qtdFuncionarios100Horas);
        System.out.printf("Maior salário final: R$ %.2f, recebido por %s%n", salarioMaiorMenor[0], nomeMaiorMenor[0]);
        System.out.printf("Menor salário final: R$ %.2f, recebido por %s%n", salarioMaiorMenor[1], nomeMaiorMenor[1]);
    }

    public static String receberNome(int numero) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do " + numero + "º funcionário: ");
        return scanner.nextLine();
    }

    public static int receberHoras(String nomeFuncionario) {
        Scanner scanner = new Scanner(System.in);
        int horas;
        do {
            System.out.print("Quantidade de horas trabalhadas pelo funcionário " + nomeFuncionario + ": ");
            horas = scanner.nextInt();
            if (horas < 0 || horas > 160) {
                System.out.println("Número de horas inválido. Digite um número entre 0 e 160.");
            }
        } while (horas < 0 || horas > 160);
        return horas;
    }

    public static char verificarFim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja finalizar? (S/N): ");
        return scanner.next().charAt(0);
    }

    public static float calcularSalario(int horas, int cont100[]) {
        float salario;
        if (horas <= 50) {
            salario = horas * 12.5f;
        } else if (horas <= 80) {
            salario = horas * 17.9f;
        } else if (horas <= 120) {
            salario = horas * 21.7f;
        } else {
            salario = horas * 25.4f;
            cont100[0