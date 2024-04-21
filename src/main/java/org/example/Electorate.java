package org.example;

public class Electorate {

    public Election election;
    public Electorate(Election election) {
        this.election = election;
    }

    // Get the electorate's selection


    public void elect() {
        election.elect();
    }
}
