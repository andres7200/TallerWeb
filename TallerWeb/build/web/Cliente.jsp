<%-- 
    Document   : Clientes
    Created on : 19-sep-2021, 17:45:49
    Author     : andre
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" integrity="sha384-Uu6IeWbM+gzNVXJcM9XV3SohHtmWE+3VGi496jvgX1jyvDTXfdK+rfZc8C1Aehk5" crossorigin="anonymous">
        <title>JSP Page</title>
                <style scoped="">
    .button-success,
    .button-error,
    .button-warning,
    .button-secondary {
        color: white;
        border-radius: 4px;
        text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
    }

    .button-success {
        background: rgb(28, 184, 65);
        /* this is a green */
    }

    .button-error {
        background: rgb(202, 60, 60);
        /* this is a maroon */
    }

    .button-warning {
        background: rgb(223, 117, 20);
        /* this is an orange */
    }

    .button-secondary {
        background: rgb(66, 184, 221);
        /* this is a light blue */
    }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="card ">
                <div align="center"class="card-body ">
                    <form class="pure-form pure-form-aligned" action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group ">
                            <label>Identificacion</label>
                            <br></br>
                            <input type="text" value="${cliente.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <br></br>
                            <input type="text" value="${cliente.getNombres()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <br></br>
                            <input type="text" value="${cliente.getDireccion()}"name="txtDireccion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <br></br>
                            <input type="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <br></br>
                            <input type="text" value="${cliente.getUser()}"name="txtUser" class="form-control">
                        </div>
                        <br></br>
                        <input type="submit" name="accion" value="Agregar" class="pure-button">
                        <input type="submit" name="accion" value="Actualizar" class="pure-button">
                        <br></br>
                    </form>
                </div>
            </div>
            <div>
                <table align="center" class="pure-table pure-table-bordered">
                    <thead>
                        <tr>
                            
                            <th>Dni</th>
                            <th>Nombres</th>
                            <th>Direccion</th>
                            <th>Estado</th>
                            <th>Usuario</th>
                            <th>Accion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cli" items="${clientes}">
                            <tr>
                                
                                <td>${cli.getDni()}</td>
                                <td>${cli.getNombres()}</td>
                                <td>${cli.getDireccion()}</td>
                                <td>${cli.getEstado()}</td>
                                <td>${cli.getUser()}</td>
                                <td><a class="button-warning pure-button" href="Controlador?menu=Cliente&accion=Editar&id=${cli.getId()}">EDITAR</a>
                                    <a class="button-error pure-button" href="Controlador?menu=Cliente&accion=Eliminar&id=${cli.getId()}">BORRAR</a>
                                </td>
                            </tr>
                        </c:forEach >  
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
