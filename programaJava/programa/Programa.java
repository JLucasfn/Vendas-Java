package programa;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import utilidades.Cliente;
import utilidades.OrdemDoPedido;
import utilidades.Pedido;
import utilidades.Produto;
import utilidades.enums.MomentoDoPedido;

public class Programa{
    public static void main( String [] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seus dados:");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu email: ");
        String email = sc.next();
        System.out.print("Digite sua data de nascimento (dd/MM/yyyy): ");
        Date nascimento = sdf.parse(sc.next());
        Cliente cliente = new Cliente(nome,email,nascimento);

        System.out.print("Digite o atual momento do pedido: ");
        MomentoDoPedido status = MomentoDoPedido.valueOf(sc.next());
        Pedido pedido = new Pedido(new Date(), status, cliente);

        System.out.println("Digite os dados do pedido:");
        System.out.print("Quantos produtos irá pedir: ");
        int cont = sc.nextInt();

        for(int i=1;i <= cont;i++){
            System.out.print("Digite o nome do produto: ");
            String nomeProduto = sc.nextLine();
            System.out.print("Digite o valor do produto: R$");
            Double valorDoProduto = sc.nextDouble();
            System.out.print("Digite a quantidade: ");
            int quantidade = sc.nextInt();

            Produto produto = new Produto(nomeProduto, valorDoProduto);

            OrdemDoPedido ordemPedido = new OrdemDoPedido(quantidade, valorDoProduto, produto);

            pedido.addPedido(ordemPedido);

        }

        System.out.println();
        System.out.println(pedido);

        sc.close();
    }
}
