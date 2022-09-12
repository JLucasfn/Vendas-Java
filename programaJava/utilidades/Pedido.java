package utilidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utilidades.enums.MomentoDoPedido;

public class Pedido {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date momento;
    private MomentoDoPedido status;
    private Cliente cliente;

    private List <OrdemDoPedido> pedido = new ArrayList<>();

    public Pedido(){

    }    

    public Pedido(Date momento, MomentoDoPedido status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }
    
    public List<OrdemDoPedido> getPedido() {
        return pedido;
    }
    
    public void addPedido(OrdemDoPedido ordemPedido){
        pedido.add(ordemPedido);
    }

    public void removePedido(OrdemDoPedido ordemDoPedido){
        pedido.remove(ordemDoPedido);
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public MomentoDoPedido getStatus() {
        return status;
    }

    public void setStatus(MomentoDoPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double total() {
		double sum = 0.0;
		for (OrdemDoPedido it : pedido) {
			sum += it.subTotal();
		}
		return sum;
	}

    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data do pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Momento atual do pedido: ");
		sb.append(status + "\n");
		sb.append("Dados do cliente: ");
		sb.append(cliente + "\n");
		sb.append("Dados do pedido:\n");
		for (OrdemDoPedido item : pedido) {
			sb.append(item + "\n");
		}
		sb.append("Preço Total: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}	

}
