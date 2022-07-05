package servlets;

import base.Parkhaus;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "level2Servlet", value = "/level2-servlet")
public class Level2Servlet extends ParkhausServlet {

    @Override
    String NAME(){
        return "Level2";
    }

    @Override
    int MAX(){ // maximum number of parking slots on level 2
        return this.parkhaus.getParkplatzSize();
    }

    @Override
    String config(){
        if (parkhaus == null) {
            this.parkhaus = new Parkhaus(14); //initial Size for Parkhause Etage 2
            getContext().setAttribute("Etage2",this.parkhaus);
        }
        return this.MAX()+",0,24,100,10"; // config
        // Config Format is "Max, open_from, open_to, delay, simulation_speed"
    }


}