package udem.edu.co.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import udem.edu.co.Modelo.Cliente;
import udem.edu.co.Modelo.ClienteDAO;
import udem.edu.co.Modelo.Empleado;
import udem.edu.co.Modelo.EmpleadoDAO;
import udem.edu.co.Modelo.Producto;
import udem.edu.co.Modelo.ProductoDAO;

/**
Se redirecciona entre las paginas de la barra de navegacion debido al iframe creado
* adicional se instancion operaciones crud para las ventanas que desee el usuario
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente cli = new Cliente();
    ClienteDAO clidao = new ClienteDAO();
    Producto pro = new Producto();
    ProductoDAO prodao = new ProductoDAO();
    int idcli;
    int ide;
    int idpro;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu = request.getParameter("menu");// Se utiliza para menus correspondientes
        String accion = request.getParameter("accion");
        
        //se valida el menu seleccionado , y se realizan operaciones crud para actualizar BD
        if (menu.equals("Principal")) {
           
            request.getRequestDispatcher("Principal.jsp").forward(request, response);

        }if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);

                    break;

                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombre");
                    String tel = request.getParameter("txtTelefono");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNombre(nom);
                    em.setTelefono(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Editar":

                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":
                    String dniac = request.getParameter("txtDni");
                    String nomac = request.getParameter("txtNombre");
                    String telac = request.getParameter("txtTelefono");
                    String estac = request.getParameter("txtEstado");
                    String userac = request.getParameter("txtUser");
                    em.setDni(dniac);
                    em.setNombre(nomac);
                    em.setTelefono(telac);
                    em.setEstado(estac);
                    em.setUser(userac);
                    em.setId(ide);
                    edao.Actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;

                default:

                    throw new AssertionError();

            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);

        }

        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List lista = clidao.listar();
                    request.setAttribute("clientes", lista);
                    break;

                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombre");
                    String dir = request.getParameter("txtDireccion");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    cli.setDni(dni);
                    cli.setNombres(nom);
                    cli.setDireccion(dir);
                    cli.setEstado(est);
                    cli.setUser(user);
                    clidao.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Editar":

                    idcli = Integer.parseInt(request.getParameter("id"));
                    Cliente cl = clidao.listarId(idcli);
                    request.setAttribute("cliente", cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":
                    String dniac = request.getParameter("txtDni");
                    String nomac = request.getParameter("txtNombre");
                    String telac = request.getParameter("txtDireccion");
                    String estac = request.getParameter("txtEstado");
                    String userac = request.getParameter("txtUser");
                    cli.setDni(dniac);
                    cli.setNombres(nomac);
                    cli.setDireccion(telac);
                    cli.setEstado(estac);
                    cli.setUser(userac);
                    cli.setId(ide);
                    clidao.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":
                    idcli = Integer.parseInt(request.getParameter("id"));
                    clidao.delete(idcli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;

                default:

                    throw new AssertionError();

            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);

        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = prodao.listar();
                    request.setAttribute("productos", lista);

                    break;

                case "Agregar":
                    String nom = request.getParameter("txtNombre");
                    String prec = request.getParameter("txtPrecio");
                    String stock = request.getParameter("txtStock");
                    String est = request.getParameter("txtEstado");
                    pro.setNombre(nom);
                    pro.setPrecio(prec);
                    pro.setStock(stock);
                    pro.setEstado(est);
                    prodao.agregar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Editar":

                    idpro = Integer.parseInt(request.getParameter("id"));
                    Producto pr = prodao.listarId(idpro);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":
                    String nomac = request.getParameter("txtNombre");
                    String precac = request.getParameter("txtPrecio");
                    String stockac = request.getParameter("txtStock");
                    String estac = request.getParameter("txtEstado");
                    pro.setNombre(nomac);
                    pro.setPrecio(precac);
                    pro.setStock(stockac);
                    pro.setEstado(estac);
                    pro.setId(idpro);
                  
                    prodao.actualizar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":
                    idpro = Integer.parseInt(request.getParameter("id"));
                    prodao.delete(idpro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

                default:

                    throw new AssertionError();
            }

            request.getRequestDispatcher("Producto.jsp").forward(request, response);

        }

        if (menu.equals("Ventas")) {

            request.getRequestDispatcher("Ventas.jsp").forward(request, response);

        }
        
        if (menu.equals("Conoce")) {

            request.getRequestDispatcher("Conoce.jsp").forward(request, response);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
