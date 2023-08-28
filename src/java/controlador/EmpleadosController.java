/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleados;
import modelo.EmpleadosDAL;


/**
 *
 * @author jc997
 */

@WebServlet(name = "EmpleadosController", urlPatterns = {"/EmpleadosController"})
public class EmpleadosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            EmpleadosDAL empleadosDAL = new EmpleadosDAL();
            String accion;
            RequestDispatcher dispatcher = null;
            
            accion = request.getParameter("accion");
            
            if (accion == null || accion.isEmpty()) {
                dispatcher = request.getRequestDispatcher("Empleados/index.jsp");
                List<Empleados> listaEmpleados = empleadosDAL.listarEmpleados();
                request.setAttribute("lista", listaEmpleados);
                
            } else if (accion.equals("nuevo")) {
                dispatcher = request.getRequestDispatcher("Empleados/nuevo.jsp");
                
            } else if (accion.equals("insertar")) {
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String correo = request.getParameter("correo");
                String puesto = request.getParameter("puesto");
                
                Empleados empleado = new Empleados(0, nombre, apellido, correo, puesto);
                empleadosDAL.insertar(empleado);
                
                dispatcher = request.getRequestDispatcher("Empleados/index.jsp");
                List<Empleados> listaEmpleados = empleadosDAL.listarEmpleados();
                request.setAttribute("lista", listaEmpleados);
                
            } else if (accion.equals("modificar")) {
                dispatcher = request.getRequestDispatcher("Empleados/modificar.jsp");
                int id = Integer.parseInt(request.getParameter("id"));
                Empleados empleado = empleadosDAL.mostarEmpleado(id);
                request.setAttribute("empleado", empleado);
                
            } else if (accion.equals("actualizar")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String correo = request.getParameter("correo");
                String puesto = request.getParameter("puesto");
                
                Empleados empleado = new Empleados(id, nombre, apellido, correo, puesto);
                empleadosDAL.actualizar(empleado);
                
                dispatcher = request.getRequestDispatcher("Empleados/index.jsp");
                List<Empleados> listaEmpleados = empleadosDAL.listarEmpleados();
                request.setAttribute("lista", listaEmpleados);
                
            } else if (accion.equals("eliminar")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                empleadosDAL.eliminar(id);
                dispatcher = request.getRequestDispatcher("Empleados/index.jsp");
                List<Empleados> listaProductos = empleadosDAL.listarEmpleados();
                request.setAttribute("lista", listaProductos);
            } else {
                dispatcher = request.getRequestDispatcher("Empleados/index.jsp");
                List<Empleados> listaEmpleados = empleadosDAL.listarEmpleados();
                request.setAttribute("lista", listaEmpleados);
            }
            
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}