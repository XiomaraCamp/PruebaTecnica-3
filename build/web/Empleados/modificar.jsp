<%-- 
    Document   : modificar
    Created on : 28 ago. 2023, 07:58:08
    Author     : jc997
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar</title>
    </head>
    <body>
        <h1>Modificar registro</h1>

        <form action="EmpleadosController?accion=actualizar" method="POST" autocomplete="off">

            <input type="hidden" id="id" name="id" value="<c:out value="${empleado.id}" />" />

            <p>
                Nommbre: <input type="text" id="nombre" name="nombre" value="<c:out value="${empleado.nombre}" />" required />
            </p>

            <p>
                Apellido: <input type="text" id="apellido" name="apellido" value="<c:out value="${empleado.apellido}" />" required />
            </p>

            <p>
                Correo: <input type="text" id="correo" name="correo" value="<c:out value="${empleado.correo}" />" required />
            </p>

            <p>
                Puesto: <input type="text" id="puesto" name="puesto" value="<c:out value="${empleado.puesto}" />" required />
            </p>

            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>