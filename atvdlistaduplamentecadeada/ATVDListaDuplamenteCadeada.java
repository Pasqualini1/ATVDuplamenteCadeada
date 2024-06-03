
package br.vinicius.atvdlistaduplamentecadeada;

import javax.swing.JOptionPane;

public class ATVDListaDuplamenteCadeada {

    private static ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Gravar novo cadastro", 
                "Excluir cadastro", 
                "Alterar cadastro", 
                "Recuperar cadastro", 
                "Exibir todos os cadastros", 
                "Sair"};
            int opcao = JOptionPane.showOptionDialog(null, 
                    "Escolha uma opção:", "Menu",
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (opcao == JOptionPane.CLOSED_OPTION) {
                opcao = 5; 
            }

            switch (opcao) {
                case 0:
                    gravarNovoCadastro();
                    break;
                case 1:
                    excluirCadastro();
                    break;
                case 2:
                    alterarCadastro();
                    break;
                case 3:
                    recuperarCadastro();
                    break;
                case 4:
                    exibirTodosCadastros();
                    break;
                case 5:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static void gravarNovoCadastro() {
        try {
            int codigo = Integer.parseInt(JOptionPane.
                    showInputDialog("Código:"));
            String nome = JOptionPane.
                    showInputDialog("Nome:");
            String dataNascimento = JOptionPane.
                    showInputDialog("Data de Nascimento:");
            String telefone = JOptionPane.
                    showInputDialog("Telefone:");

            Cliente cliente = new Cliente(codigo, nome, dataNascimento, telefone);
            lista.adicionar(cliente);
            JOptionPane.showMessageDialog(null, 
                    "Cadastro realizado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                    "Código inválido! Deve ser um número.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao realizar cadastro: " + e.getMessage());
        }
    }

    private static void excluirCadastro() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(
                    "Código do cliente a ser excluído:"));
            Cliente cliente = lista.buscar(codigo);
            if (cliente != null) {
                lista.remover(codigo);
                JOptionPane.showMessageDialog(null, 
                        "Cadastro excluído: " + cliente);
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Cliente não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                    "Código inválido! Deve ser um número.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao excluir cadastro: " + e.getMessage());
        }
    }

    private static void alterarCadastro() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(
                    "Código do cliente a ser alterado:"));
            Cliente cliente = lista.buscar(codigo);
            if (cliente != null) {
                String nome = JOptionPane.showInputDialog(
                        "Novo nome:", cliente.getNome());
                String dataNascimento = JOptionPane.showInputDialog(
                        "Nova data de nascimento:", cliente.getDataNascimento());
                String telefone = JOptionPane.showInputDialog(
                        "Novo telefone:", cliente.getTelefone());
                lista.atualizar(codigo, nome, dataNascimento, telefone);
                JOptionPane.showMessageDialog(null, 
                        "Cadastro atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Cliente não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                    "Código inválido! Deve ser um número.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao alterar cadastro: " + e.getMessage());
        }
    }

    private static void recuperarCadastro() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(
                    "Código do cliente:"));
            Cliente cliente = lista.buscar(codigo);
            if (cliente != null) {
                JOptionPane.showMessageDialog(null, 
                        "Dados do cliente: " + cliente);
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Cliente não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                    "Código inválido! Deve ser um número.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao recuperar cadastro: " + e.getMessage());
        }
    }

    private static void exibirTodosCadastros() {
        lista.exibirTodos();
    }
}