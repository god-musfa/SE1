package servlets;

import base.Parkhaus;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "level1Servlet", value = "/level1-servlet")
public class Level1Servlet extends ParkhausServlet {

    @Override
    String NAME(){
        return "Level1";
    }

    @Override
    int MAX(){ // maximum number of parking slots on level 1
        return this.parkhaus.getParkplatzSize();
    }

    @Override
    String config(){
        if (this.parkhaus == null) {
            this.parkhaus = new Parkhaus(10); //initial Size for Parkhause Etage 1
        }
        return this.MAX()+",6,24,50,7000"; // config
        // Config Format is "Max, open_from, open_to, delay, simulation_speed"
    }



}