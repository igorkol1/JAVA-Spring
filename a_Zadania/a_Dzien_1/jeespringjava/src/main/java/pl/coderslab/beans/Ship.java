package pl.coderslab.beans;

public class Ship {

    private Captain captain;

    public Ship(Captain captain) {
        this.captain = captain;
    }

    public Captain getCaptain() {
        return this.captain;
    }
}
