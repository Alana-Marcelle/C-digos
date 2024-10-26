/*
 ============================================================================
 Name        : Atividade.c
 Author      : Alana Marcelle
 Version     :
 Copyright   : Universidade
 Description : Hello World in C, Ansi-style
 ============================================================================
 */
#include <stdio.h>

// Função que recebe um valor inteiro do usuário
int receberValorInteiro(char *frase) {
    int valor = 0; // Variável para armazenar o valor digitado pelo usuário

    // Loop para garantir que o valor digitado esteja dentro do intervalo válido
    do {
        printf("%s", frase); // Exibe a frase solicitando a entrada do usuário
        scanf("%d", &valor); // Lê o valor digitado pelo usuário e armazena em 'valor'

        // Verifica se o valor está fora do intervalo permitido
        if (valor < 1 || valor > 50) {
            printf("Valor inválido! Digite um número entre 1 e 50.\n"); // Mensagem de erro
        }
    } while (valor < 1 || valor > 50); // Continua pedindo a entrada até que um valor válido seja fornecido

    return valor; // Retorna o valor validado
}

int main() {
    // Mensagem solicitando a entrada do usuário
    char frase[] = "Por favor, insira um número entre 1 e 50: ";
    int numero = receberValorInteiro(frase); // Chama a função para receber o valor e armazena na variável 'numero'
    printf("Número digitado e validado: %d\n", numero); // Exibe o número validado

    return 0; // Indica que o programa terminou com sucesso
}
