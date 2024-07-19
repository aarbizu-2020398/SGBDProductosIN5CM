package org.adrianarbizu.webapp.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.adrianarbizu.webapp.model.Producto;
import org.adrianarbizu.webapp.util.JpaUtil;

public class ProductoService implements IProductoService {

    private static EntityManager em;

    public ProductoService() {
        this.em = JpaUtil.getEntityManager();
    }

    @Override
    public void agregarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarProducto(int productoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto buscarProductoPorId(int productoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> listarProducto() {
       return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
       
    }
}
