package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

import base.Parkhaus;
import helper.ButtonCalc;
import template.StatisticCarTypes;
import base.Car;
import base.CarIF;

/**
 * common superclass for all servlets
 * groups all auxiliary common methods used in all servlets
 */
public abstract class ParkhausServlet extends HttpServlet {
    //TODO MVC Parkhaus Model
    //TODO Reset Button fürs resetten des Parkhauses

    /* abstract methods, to be defined in subclasses */
    abstract String NAME(); // each ParkhausServlet should have a name, e.g. "Level1"
    abstract int MAX(); // maximum number of parking slots of a single parking level
    abstract String config(); // configuration of a single parking level
    Parkhaus parkhaus;
    /**
     * HTTP GET
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String cmd = request.getParameter("cmd");
        System.out.println( cmd + " requested: " + request.getQueryString());
        switch ( cmd ){
            case "config":
                // Overwrite Parkhaus config parameters
                // Max, open_from, open_to, delay, simulation_speed
                out.println( config() );
                break;
            case "sum":
                out.println(ButtonCalc.calcSum(parkhaus.getCarsList()));
                break;
            case "avg":
                out.println(ButtonCalc.calcAvgPrice(parkhaus.getCarsList()));
                out.println(ButtonCalc.calcAvgDuration(parkhaus.getCarsList()));
                break;
            case "min":
                out.println(ButtonCalc.calcMin(parkhaus.getCarsList()));
                break;
            case "max":
                out.println(ButtonCalc.calcMax(parkhaus.getCarsList()));
                break;
            case "cars":
                // Cars are separated by comma.
                // Values of a single car are separated by slash.
                // Format: Nr, timer begin, duration, price, Ticket, color, space, client category, vehicle type, license (PKW Kennzeichen)
                // For example:
                // out.println("1/1648465400000/_/_/Ticket1/#0d1e0a/2/any/PKW/1,2/1648465499999/_/_/Ticket2/#dd10aa/3/any/PKW/2");
                out.println(parkhaus.carsListToString());
                break;
            case "chart":
                StatisticCarTypes sct = new StatisticCarTypes();
                out.println(sct.statistikErstellen(cars()));
                break;
            case "Gesamtanzahl Autos":
                out.println(ButtonCalc.calcGesamtAnzahlAutos(parkhaus.getCarsList()));

                break;
            default:
                System.out.println("Invalid Command: " + request.getQueryString());
        }

    }

    /**
     * HTTP POST
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String body = getBody( request );
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        System.out.println( body );
        String[] params = body.split(",");
        String event = params[0];
        String[] restParams = Arrays.copyOfRange(params, 1, params.length);

        switch( event ){
            case "enter":
                CarIF newCar = new Car( restParams );
                cars().add( newCar );
                // System.out.println( "enter," + newCar );

                // re-direct car to another parking lot
                out.println( parkhaus.enter(newCar) );
                System.out.println(parkhaus.getCars());
                break;
            case "leave":

                System.out.println(parkhaus.getCars());



                out.println( parkhaus.leave(Integer.parseInt(params[1]),Long.parseLong(params[3])));  // server calculated price
                //System.out.println( "leave," + oldCar + ", price = " + price );
                break;
            case "invalid": case "occupied":
                System.out.println( body );
                break;
            case "tomcat":
                out.println( getServletConfig().getServletContext().getServerInfo()
                        + getServletConfig().getServletContext().getMajorVersion()
                        + getServletConfig().getServletContext().getMinorVersion() );
                break;
            case "change_max":
                this.parkhaus.changeMax(Integer.parseInt(restParams[0]));
                break;
            default:
                System.out.println( body );
                // System.out.println( "Invalid Command: " + body );
        }

    }

    /**
     * @return the servlet context
     */
    ServletContext getContext(){
        return getServletConfig().getServletContext();
    }


    /**
     * @return the list of all cars stored in the servlet context so far
     */
    @SuppressWarnings("unchecked")
    List<CarIF> cars(){
        if ( getContext().getAttribute( "cars"+NAME() ) == null ){
            getContext().setAttribute( "cars"+NAME(), new ArrayList<Car>() );
        }
        return (List<CarIF>) getContext().getAttribute( "cars"+NAME() );
    }

    /**
    * @param request the HTTP POST request
    * @return the body of the request
    */
    String getBody( HttpServletRequest request ) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if ( inputStream != null ) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public void destroy() {
        System.out.println("Servlet destroyed.");
    }
}