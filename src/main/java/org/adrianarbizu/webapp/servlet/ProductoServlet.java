package org.adrianarbizu.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.adrianarbizu.webapp.model.Producto;
import org.adrianarbizu.webapp.service.ProductoService;

@WebServlet("/producto-servlet")
@MultipartConfig
public class ProductoServlet extends HttpServlet {
    
    private ProductoService ps;
    
    @Override
    public void init() throws ServletException{
        super.init();
        this.ps = new ProductoService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Producto> productos = ps.listarProducto();
        req.setAttribute("productos",productos);
        req.getRequestDispatcher("/lista-productos/lista-productos.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> datosProducto = new ArrayList<>();
        List<String> errores = new ArrayList<>();
        
        String nombreProducto = req.getParameter("nombreProducto");
        String descripcionProducto = req.getParameter("descripcionProducto");
        String marcaProducto = req.getParameter("marcaProducto");
        String precioProducto = req.getParameter("precioProducto");
        
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
            errores.add("El nombre del producto es obligatorio.");
        }
        if (descripcionProducto == null || descripcionProducto.trim().isEmpty()) {
            errores.add("La descripción del producto es obligatoria.");
        }
        if (marcaProducto == null || marcaProducto.trim().isEmpty()) {
            errores.add("La marca del producto es obligatoria.");
        }
        if (precioProducto == null || precioProducto.trim().isEmpty()) {
            errores.add("El precio del producto es obligatorio.");
        }
        
        if (errores.isEmpty()) {
            datosProducto.add(nombreProducto);
            datosProducto.add(descripcionProducto);
            datosProducto.add(marcaProducto);
            datosProducto.add("Q." + precioProducto);
            
            req.setAttribute("datosProducto", datosProducto);
            getServletContext().getRequestDispatcher("/formulario-productos/formulario-productos.jsp").forward(req, resp);
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/formulario-productos/formulario-productos.jsp").forward(req, resp);
        }
    }
}
