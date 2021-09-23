<%-- 
    Document   : Ventas
    Created on : 19-sep-2021, 17:46:03
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

        <div class="form-group d-flex">

            <div class="col-sm-7">

                <div class ="card">
                    
                    <b><div align="center">
                    <label>¡Un gusto atenderte! por favor selecciona la cantidad con los productos deseados al carrito</label>
                        </div></b>
                    <br></br>
                    <br></br>
                    
                    <div align="center" class="card-body">

                        <table class="pure-table pure-table-bordered">
                            <thead>
                                <tr>
                                    <th>Nombre producto</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Ediciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="p" items="${productos}">
                                    <tr>
                                        <td>${p.getNombre()}</td>
                                        <td>${p.getPrecio()}</td>
                                        <td>cantidadeeee</td>
                                        <td>
                                            <a class="button-warning pure-button" href="Controlador?menu=Producto&accion=Editar&id=${p.getId()}">EDITAR </a>
                                            <a class="button-error pure-button" href="Controlador?menu=Producto&accion=Eliminar&id=${p.getId()}">ELIMINAR</a>                                        
                                        </td>
                                    </tr>
                                    </c:forEach > 
                                    </tbody>
                                </table>


                            </div>

                        </div>



                    </div>

                </div>



            </body>
        </html>
