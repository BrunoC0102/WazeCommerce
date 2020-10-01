package com.bruno.waze_commerce.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.bruno.waze_commerce.model.Pedido;

import org.springframework.stereotype.Component;

@Component
public class PedidoRepository {
    
    private List<Pedido> pedidos;
    private int nextId;

    @PostConstruct
    public void init(){

        Pedido pd1 = new Pedido();
        pd1.setCodigo(1);
        pd1.setValor(250.00);
        pd1.setDescricao("Livro");
        pd1.setCliente("Bruno");
        pd1.setDataPedido("01/02/2020");
        
        Pedido pd2 = new Pedido();
        pd2.setCodigo(1);
        pd2.setValor(250.00);
        pd2.setDescricao("Livro");
        pd2.setCliente("Lucca");
        pd2.setDataPedido("01/02/2020");
        
        Pedido pd3 = new Pedido();
        pd3.setCodigo(1);
        pd3.setValor(250.00);
        pd3.setDescricao("Livro");
        pd3.setCliente("Duda");
        pd3.setDataPedido("01/02/2020");

        pedidos = new ArrayList<Pedido>();
        
        pedidos.add(pd1);
        pedidos.add(pd2);
        pedidos.add(pd3);

        nextId = 4;
        
    }

    public Pedido save(Pedido pedido){
        pedido.setCodigo(nextId);
        pedidos.add(pedido);
        nextId++;
        return pedido;
    }

    public List<Pedido> getPedidos(){
        return pedidos;
    }

    public Pedido getPedidoById(int codigo){
        
        for(Pedido aux : pedidos){
            if(aux.getCodigo() == codigo){
                return aux;
            }
        }

        return null;
    }

    public void delete(Pedido pedido){
        pedidos.remove(pedido);
    }

    public Pedido update(Pedido pedido){
        Pedido aux = getPedidoById(pedido.getCodigo());
        if(aux != null){
            aux.setValor(pedido.getValor());
            aux.setDescricao(pedido.getDescricao());
            aux.setCliente(pedido.getCliente());
            aux.setDataPedido(pedido.getDataPedido());
        }

        return aux;
    }
}
