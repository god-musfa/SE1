package de.hbrs.team89.se1_starter_repo;

public class Parkhaus implements ParkhausIF{

    @Override
    public int enter(Car c) {
        return 0;
    }

    @Override
    public boolean leave(int nr) { //ToDo Rueckgabewert noch aendern
        return false;
    }
}
