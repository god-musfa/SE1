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
        return 11;
    }

    @Override
    String config(){
        this.parkhaus = new Parkhaus(this.MAX());
        return this.MAX()+",6,24,100,1"; // inital config
        // Config Format is "Max, open_from, open_to, delay, simulation_speed"
    }



}