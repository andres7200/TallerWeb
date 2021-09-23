<%-- 
    Document   : Principal
    Created on : 15-sep-2021, 23:05:21
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Se utiliza modelo Bootstrap para el login y pagina principal navbar-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light" style="background-color:#009999">
            <div class="container-fluid">
                <img src="Imagenes/LOGO.jpg" alt="60" width="100"/>
                <div> &nbsp;&nbsp;&nbsp;&nbsp;</div>
                <b class="navbar-brand" href="#">INSTATECHNOLOGY </b>   
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a style="border: none;margin-left: 10px" class="btn btn-outline-light" href="Controlador?menu=Inicio" target="myFrame">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a style="border: none;margin-left: 10px" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a style="border: none;margin-left: 10px" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame" >Empleados</a>
                        </li>
                        <li class="nav-item">
                            <a style="border: none;margin-left: 10px"  class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a style="border: none;margin-left: 10px" class="btn btn-outline-light" href="Controlador?menu=Ventas" target="myFrame">Carrito Compras</a>
                        </li>
                        <li class="nav-item">
                            <a  class="btn btn-outline-light" href="Controlador?menu=Conoce" target="myFrame">Conoce Mas sobre nosotros</a>
                        </li>
                                      
                    </ul>
                </div>
                <div class="dropdown">
                    <button class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false"> 
                        ${usuario.getNombre()}
                    </button>
                    <div class="dropdown-menu" text-center >
                        <div align="center"><a class="dropdown-item" href="#">
                            <img src="Imagenes/Usuario.png" alt="60" width="60"/>        
                        </a></div>
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <div  align="center"><button name="accion" value="Salir"  class="dropdown-item" href="#">Salir</a></div>
                        </form>
  
                    </div>
                    
                </div>
                    
            </div>
        </nav>
                    <div align="center">
                        <img src="Imagenes/LOGO.jpg" alt="30" height="400" widht="160"/>
                    </div>
        <div class="m-4" style="height:1000px;">
            <iframe name="myFrame" style="height:100%;width:100% "> </iframe>
            <!-- Se instancia Iframe para permitir navegar por el navbar en la pestaña principal-->
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
 
    </body>
</html>
