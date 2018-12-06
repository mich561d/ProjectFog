package PresentationLayer;

import FunctionLayer.Exceptions.CarportCreationException;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.Exceptions.RegisterException;
import FunctionLayer.Logging.Logging;
import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Command action = CommandController.from(request);
            String view = action.execute(request, response);
            if ("index".equals(view)) {
                request.getRequestDispatcher(view + ".jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/Webpages/" + view + ".jsp").forward(request, response);
            }
        } catch (IOException | ServletException ex) {
            new Logging().write(Level.WARNING, ex.getMessage());
            request.getSession().setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("/Webpages/Error.jsp").forward(request, response);
        } catch (FogException ex) {
            new Logging().write(ex.LEVEL, ex.getMessage());
            request.getSession().setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("/Webpages/Error.jsp").forward(request, response);
        } catch (RegisterException ex) {
            new Logging().write(ex.LEVEL, ex.getMessage());
            request.getSession().setAttribute("ErrorMsg", ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (LoginException ex) {
            new Logging().write(ex.LEVEL, ex.getMessage());
            request.getSession().setAttribute("ErrorMsg", ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (CarportCreationException ex) {
            new Logging().write(ex.LEVEL, ex.getMessage());
            request.getSession().setAttribute("ErrorMsg", ex.getMessage());
            request.getRequestDispatcher("CustomCarport.jsp").forward(request, response);
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
