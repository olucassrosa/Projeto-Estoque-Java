import javax.swing.JOptionPane;

class Empresa {
    String n;
    int e;

    public Empresa(String n, int EstoqueI) {
        this.n = n;
        this.e = EstoqueI;
    }

    public void adicionarEstoque(int qtd) {
        if (qtd > 0) {
            e += qtd;
            JOptionPane.showMessageDialog(null, "Quantidade adicionada no saldo da empresa " + n + "!");
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade deve ser positiva!");
        }
    }

    public void registrarSaida(int qtd) {
        if (qtd > 0) {
            if (e >= qtd) {
                e -= qtd;
                JOptionPane.showMessageDialog(null, "Quantidade retirada do saldo da empresa " + n + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade insuficiente para realizar a retirada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade deve ser positiva");
        }
    }

    public void transferirEstoque(Empresa destino, int qtd) {
        if (qtd > 0) {
            if (e >= qtd) {
                e -= qtd;
                destino.adicionarEstoque(qtd);
                JOptionPane.showMessageDialog(null, "Quantidade transferida da empresa " + n + " para " + destino.getN() + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade insuficiente para realizar a transferência");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade deve ser positiva");
        }
    }

    int getE() {
        return e;
    }

    String getN() {
        return n;
    }
}
public class EstoqueEmpresaJatiboca{
    public static void main(String[] args) {
        int estoqueIJati = Integer.parseInt(JOptionPane.showInputDialog("Escreva o estoque inicial da empresa Jatiboca:"));
        Empresa jatiboca = new Empresa("Jatiboca", estoqueIJati);

        int estoqueIPontal = Integer.parseInt(JOptionPane.showInputDialog("Escreva o estoque inicial da empresa Pontal:"));
        Empresa pontal = new Empresa("Pontal", estoqueIPontal);

        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    int adicionar = Integer.parseInt(JOptionPane.showInputDialog("Adicionar estoque para qual empresa?\n1 - Jatiboca\n2 - Pontal"));
                    if (adicionar == 1) {
                        adicionarEstoque(jatiboca);
                    } else if (adicionar == 2) {
                        adicionarEstoque(pontal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Empresa inválida");
                    }
                    break;

                case 2:
                    int retirar = Integer.parseInt(JOptionPane.showInputDialog("Retirar estoque de qual empresa?\n1 - Jatiboca\n2 - Pontal"));
                    if (retirar == 1) {
                        registrarSaida(jatiboca);
                    } else if (retirar == 2) {
                        registrarSaida(pontal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Empresa inválida!");
                    }
                    break;

                case 3:
                    exibirEstoque(jatiboca, pontal);
                    break;

                case 4:
                    int transf = Integer.parseInt(JOptionPane.showInputDialog("Transferir estoque de qual empresa?\n1 - Jatiboca -> Pontal\n2 - Pontal -> Jatiboca"));
                    if (transf == 1) {
                        transferirEstoque(jatiboca, pontal);
                    } else if (transf == 2) {
                        transferirEstoque(pontal, jatiboca);
                    } else {
                        JOptionPane.showMessageDialog(null, "Empresa inválida!");
                    }
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }

    public static int menu() {
        String menu = """
                Menu:
                1. Adicionar entrada de estoque
                2. Registrar saída de estoque
                3. Exibir estoque atual
                4. Transferir estoque
                5. Sair
                """;
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    public static void adicionarEstoque(Empresa empresa) {
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Escreva a quantidade de açúcar para adicionar:"));
        empresa.adicionarEstoque(quantidade);
    }

    public static void registrarSaida(Empresa empresa) {
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Escreva a quantidade de açúcar para retirar:"));
        empresa.registrarSaida(quantidade);
    }

    public static void transferirEstoque(Empresa origem, Empresa destino) {
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Escreva a quantidade de açúcar para transferir:"));
        origem.transferirEstoque(destino, quantidade);
    }

    public static void exibirEstoque(Empresa jatiboca, Empresa pontal) {
        String msg = "Estoque atual:\n" +
                jatiboca.getN() + ": " + jatiboca.getE() + " unidades\n" +
                pontal.getN() + ": " + pontal.getE() + " unidades";
        JOptionPane.showMessageDialog(null, msg);
    }
}
