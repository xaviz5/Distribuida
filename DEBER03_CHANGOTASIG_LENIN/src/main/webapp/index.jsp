<%--
  Created by IntelliJ IDEA.
  User: xaviz
  Date: 13/05/2019
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <title>Ingreso datos</title>
  </head>
  <body>
  <h1>Registro de Personas</h1>
  <form action="./servletController" method="post">

      <table>
          <tr>
              <td><h5>Buscar:</h5></td>
              <td><input type="text" name="idB"></td>
          </tr>
          <tr>
              <td><input type="submit" name="action" value="buscar"></td>
          </tr>
      </table>
      <table>
          <tr>
            <td><h5>Id:</h5></td>
            <td><input type="text" name="id" value="${persona.id}"></td></br>
            <td><h5>Nombre:</h5></td>
            <td><input type="text" name="nombre" value="${persona.nombre}"></td></br>
            <td><h5>Direccion:</h5></td>
            <td><input type="text" name="direccion" value="${persona.direccion}"></td></br>
          </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="action" value="guardar"></td><td></td>
                <td><input type="submit" name="action" value="editar"></td>
                <td><input type="submit" name="action" value="eliminar"></td>
            </tr>
      </table>
      </br>
      <h1>Lista de personas</h1>
      </br>
      <tr>
          <td><input type="submit" name="action" value="actualizar"></td>
      </tr>
      </br></br>
      <table border="1" width="70%">
          <tr>
              <td> Id</td>
              <td> Nombre</td>
              <td>Direccion</td>
          </tr>
          <c:forEach var="persona" items="${listaPersonas}">
              <tr>
                  <td><c:out value="${persona.id}"/></td>
                  <td><c:out value="${persona.nombre}"/></td>
                  <td><c:out value="${persona.direccion}"/></td>
              </tr>
          </c:forEach>
      </table>

  </form>
  </body>
</html>
