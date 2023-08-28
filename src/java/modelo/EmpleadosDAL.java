/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jc997
 */


public class EmpleadosDAL {

    Connection conexion;

    public EmpleadosDAL() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }

    public List<Empleados> listarEmpleados() {

        PreparedStatement ps;
        ResultSet rs;

        List<Empleados> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT id, nombre, apellido, correo, puesto FROM empleados");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String puesto = rs.getString("puesto");
                

                Empleados empleado = new Empleados(id, nombre, apellido, correo, puesto);
                lista.add(empleado);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al listar empleados: " + e.toString());
            return null;
        }
    }

    public Empleados mostarEmpleado(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Empleados empleado = null;

        try {
            ps = conexion.prepareStatement("SELECT id, nombre, apellido, correo, puesto FROM empleados WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String puesto = rs.getString("puesto");
               

                empleado = new Empleados(id, nombre, apellido, correo, puesto);
            }
            return empleado;
        } catch (SQLException e) {
            System.out.println("Error al mostrar empleado: " + e.toString());
            return null;
        }
    }

    public boolean insertar(Empleados empleado) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO empleados (nombre, apellido, correo, puesto) VALUES (?,?,?,?)");
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
           ps.setString(3, empleado.getCorreo());
           ps.setString(4, empleado.getPuesto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.toString());
            return false;
        }
    }

    public boolean actualizar(Empleados empleado) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("UPDATE empleados SET nombre=?, apellido=?, correo=?, puesto=? WHERE id=?");
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getCorreo());
            ps.setString(4, empleado.getPuesto());
            ps.setInt(5, empleado.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("DELETE FROM empleados WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.toString());
            return false;
        }
    }

}