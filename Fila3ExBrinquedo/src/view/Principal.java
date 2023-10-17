package view;

import java.util.LinkedList;
import java.util.Queue;

class Cliente {
    String nome;
    int idade;
    float altura;

    public Cliente(String nome, int idade, float altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }
}

class ParqueController {
    public static void brinquedo(Queue<Cliente> fila) {
        while (!fila.isEmpty()) {
            Cliente cliente = fila.poll();
            if (cliente.idade > 16 && cliente.altura > 1.60) {
                System.out.println(cliente.nome + " pode entrar no brinquedo.");
            } else {
                String razao = "não atende aos requisitos de idade e altura";
                System.out.println(cliente.nome + " não pode entrar no brinquedo. Razão: " + razao);
            }
        }
    }
}

public class Principal {
    public static void main(String[] args) {
        Queue<Cliente> fila = new LinkedList<>();
        for (int i = 1; i <= 30; i++) {
            String nome = "Pessoa" + i;
            int idade = (int) (Math.random() * 31) + 10;  // Idade entre 10 e 40
            float altura = (float) (1.35 + Math.random() * 0.65);  // Altura entre 1.35 e 2.00
            Cliente cliente = new Cliente(nome, idade, altura);
            fila.offer(cliente);
        }

        ParqueController.brinquedo(fila);
    }
}
