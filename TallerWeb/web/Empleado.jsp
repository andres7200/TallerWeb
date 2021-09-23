<%-- 
    Document   : Empleados
    Created on : 19-sep-2021, 17:45:38
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
            <div class="card col-sm-5">
                <div align="center" class="card-body">
                    <form class="pure-form pure-form-aligned" action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label align="center">Identificacion</label>
                            <br></br>
                            <input type="text" value="${empleado.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">

                            <label>Nombre</label>
                            <br></br>
                            <input type="text" value="${empleado.getNombre()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">

                            <label>Telefono</label>
                            <br></br>
                            <input type="text" value="${empleado.getTelefono()}"name="txtTelefono" class="form-control">
                        </div>
                        <div class="form-group">

                            <label>Estado</label>
                            <br></br>
                            <input type="text" value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <div class="form-group">

                            <label>Usuario</label>
                            <br></br>
                            <input type="text" value="${empleado.getUser()}"name="txtUser" class="form-control">
                        </div>
                        <br></br>
                        <input type="submit" name="accion" value="Agregar" class="pure-button">
                        <input type="submit" name="accion" value="Actualizar" class="pure-button">
                        <br></br>
                    </form>
                </div>
            </div>
            <div align="center" class="col-sm-7">
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr>
                            
                            <th>Dni</th>
                            <th>Nombre</th>
                            <th>Telefono</th>
                            <th>Estado</th>
                            <th>Usuario</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${empleados}">
                            <tr>
                                <!-- Se listan las bases de datos-->
                                <td>${em.getDni()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
                                <td>${em.getNombre()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
                                <td>${em.getTelefono()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
                                <td>${em.getEstado()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
                                <td>${em.getUser()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
                                <td><a class="button-warning pure-button" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">EDITAR </a>
                                    <a class="button-error pure-button" href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getId()}">ELIMINAR</a>
                                    <!--botones para realizar ediciones en la base de datos-->

                                </td>
                            </tr>
                        </c:forEach >  
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
