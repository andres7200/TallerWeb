<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!Modelo>

<!-- Se utiliza modelo Bootstrap para el login y pagina principal navbar-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="Validar" method="POST"><!--Formulario login, validar cajas txt-->
                        <div class="form-group text-center">
                            <h3>Bienvenido a Instatechnology por favor ingrese sus datos</h3>
                            <img src="Imagenes/LOGO.jpg" alt="70" width="170"/>
                        </div>
                        <div align="center" class="form-group">
                            <label>Usuario</label>
                            <input type="text" name="txtuser" class="form-control">
                        </div>
                        <div align="center" class="form-group">
                            <label>Contraseña</label>
                            <input type="password" name="txtpass" class="form-control">
                        </div>
                        <br>
                        <div align="center"><input  type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block"></div><!-- Boton Accion ingresar -->
                        </br>
                    </form>
                </div>
            </div>
        </div>
        <!-- Scripts Boot strap-->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
        
    </body>
</html>
