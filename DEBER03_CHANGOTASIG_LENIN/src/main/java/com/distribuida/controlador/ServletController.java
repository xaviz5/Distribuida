package com.distribuida.controlador;


import com.distribuida.entity.Persona;
import com.distribuida.servicios.Crud;
import com.distribuida.servicios.CrudInterfaz;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/servletController")
public class ServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Persona persona = new Persona();

    CrudInterfaz crud = new Crud();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println(action);

        try {
            if(action.equals("guardar")){
                guardar(request,response);
            }else if(action.equals("editar")){
                editar(request,response);
            }else if(action.equals("eliminar")){
                eliminar(request,response);
            }else if(action.equals("buscar")){
                buscar(request,response);
            }else if(action.equals("actualizar")){
                actualizar(request,response);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    private void guardar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        persona.setId(Integer.parseInt(request.getParameter("id")));
        persona.setNombre(request.getParameter("nombre"));
        persona.setDireccion(request.getParameter("direccion"));
        System.out.println(persona.getNombre());
        crud.Ingresar(persona);
        actualizar(request,response);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
    private void editar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        persona.setId(Integer.parseInt(request.getParameter("id")));
        persona.setNombre(request.getParameter("nombre"));
        persona.setDireccion(request.getParameter("direccion"));
        crud.Editar(persona);
        actualizar(request,response);
    }
    private void eliminar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        crud.Eliminar(id);
        actualizar(request,response);
    }
    private void buscar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("idB"));
        persona = crud.Buscar(id);
        request.setAttribute("persona", persona);
        actualizar(request,response);
    }
    private void actualizar (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, SQLException{
        List<Persona> listar = crud.Listar();
        request.setAttribute("listaPersonas", listar);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
