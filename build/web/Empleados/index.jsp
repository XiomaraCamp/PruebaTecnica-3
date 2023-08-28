<%-- 
    Document   : index
    Created on : 28 ago. 2023, 07:58:00
    Author     : jc997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registros</title>
    </head>
    <body>
        <h1>Registro de Libros</h1>

        <p><a href="EmpleadosController?accion=nuevo">Registra los datos</a></p>

        <table border="1" width="80%">
            <thead>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Correo</th>
            <th>Puesto</th>
            
            <th></th>
            <th></th>
        </thead>

        <tbody>
            <c:forEach var="empleado" items="${lista}">
                <tr>
                    <td><c:out value="${empleado.nombre}" /></td>
                    <td><c:out value="${empleado.apellido}" /></td>
                    <td><c:out value="${empleado.correo}" /></td>
                    <td><c:out value="${empleado.puesto}" /></td>

              <td><a href="EmpleadosController?accion=modificar&id=<c:out value="${empleado.id}" />">Modificar</a></td>

             <td><a href="EmpleadosController?accion=eliminar&id=<c:out value="${empleado.id}" />">Eliminar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>