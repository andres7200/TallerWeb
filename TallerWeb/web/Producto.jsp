<%-- 
    Document   : Productos
    Created on : 19-sep-2021, 17:45:20
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
                    <form class="pure-form pure-form-aligned" action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>Nombre Producto</label>
                            <br></br>
                            <input type="text" value="${producto.getNombre()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <br></br>
                            <input type="text" value="${producto.getPrecio()}" name="txtPrecio" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <br></br>
                            <input type="text" value="${producto.getStock()}"name="txtStock" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <br></br>
                            <input type="text" value="${producto.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <br></br>
                        <input type="submit" name="accion" value="Agregar" class="pure-button">
                        <input type="submit" name="accion" value="Actualizar" class="pure-button">
                        <br></br>
                    </form>
                </div>
            </div>
            <br></br>
            <div align="center" class="col-sm-7" >
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th>Estado</th>
                            <th>Ediciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${productos}">
                            <tr>
                                <td>${p.getId()}</td>
                                <td>${p.getNombre()}</td>
                                <td>${p.getPrecio()}</td>
                                <td>${p.getStock()}</td>
                                <td>${p.getEstado()}</td>
                                <td><a class="button-warning pure-button" href="Controlador?menu=Producto&accion=Editar&id=${p.getId()}">EDITAR </a>
                                    <a class="button-error pure-button" href="Controlador?menu=Producto&accion=Eliminar&id=${p.getId()}">ELIMINAR</a>
                                </td>
                            </tr>
                        </c:forEach >  
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
