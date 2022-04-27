package de.hbrs.team89.se1_starter_repo;

public interface ParkhausIF {

    int enter(Car c);

    boolean leave(int nr);

    Car[] getCars();
}
