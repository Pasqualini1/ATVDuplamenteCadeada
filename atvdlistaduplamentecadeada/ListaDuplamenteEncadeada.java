
package br.vinicius.atvdlistaduplamentecadeada;

import javax.swing.JOptionPane;

public class ListaDuplamenteEncadeada {
     private No head;
    private No tail;

    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
    }

    public void adicionar(Cliente cliente) {
        No novoNo = new No(cliente);
        if (head == null) {
            head = tail = novoNo;
        } else {
            tail.setProximo(novoNo);
            novoNo.setAnterior(tail);
            tail = novoNo;
        }
    }

    public boolean remover(int codigo) {
        No atual = head;
        while (atual != null) {
            if (atual.getCliente().getCodigo() == codigo) {
                if (atual == head) {
                    head = head.getProximo();
                    if (head != null) {
                        head.setAnterior(null);
                    }
                } else if (atual == tail) {
                    tail = tail.getAnterior();
                    tail.setProximo(null);
                } else {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                }
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public Cliente buscar(int codigo) {
        No atual = head;
        while (atual != null) {
            if (atual.getCliente().getCodigo() == codigo) {
                return atual.getCliente();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void atualizar(int codigo, 
            String nome, 
            String dataNascimento, 
            String telefone) {
        Cliente cliente = buscar(codigo);
        if (cliente != null) {
            cliente.setNome(nome);
            cliente.setDataNascimento(dataNascimento);
            cliente.setTelefone(telefone);
        }
    }

    public void exibirTodos() {
        No atual = head;
        StringBuilder sb = new StringBuilder();
        while (atual != null) {
            sb.append(atual.getCliente().toString()).append("\n");
            atual = atual.getProximo();
        }
        JOptionPane.showMessageDialog(null, sb.toString(), 
                "Todos os Cadastros", 
                JOptionPane.INFORMATION_MESSAGE);
    }
}