package com.mycompany.assignment8_classesobject;

import java.util.ArrayList;
import java.util.List;

/*
5. Write two DTO classes to exhibit the has-a relationship given in the diagram. 
https://cdn-proxy.slickplan.com/wp-content/uploads/2023/10/8_uml.png
TeamDTO class
 */
public class TeamDTO {
    private String name;
    private String city;
    private String division;
    private List<PlayerDTO> players;

    public TeamDTO() {
        players = new ArrayList<>();
    }

    public TeamDTO(String name, String city, String division) {
        this.name = name;
        this.city = city;
        this.division = division;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void addPlayer(PlayerDTO player) {
        players.add(player);
    }

    public void playGame() {
        System.out.println(name + " team is playing a game.");
    }

    public void hireCoach() {
        System.out.println(name + " team is hiring a new coach.");
    }

    public String getTeamDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Team Details:\n")
               .append("Name: ").append(name).append("\n")
               .append("City: ").append(city).append("\n")
               .append("Division: ").append(division).append("\n")
               .append("Players:\n");

        for (PlayerDTO player : players) {
            details.append(player.getPlayerDetails()).append("\n");
        }

        return details.toString();
    }

    public static void main(String[] args) {
        TeamDTO team = new TeamDTO("Warriors", "San Francisco", "Pacific");

        PlayerDTO player1 = new PlayerDTO("Stephen Curry", "Guard", 30);
        PlayerDTO player2 = new PlayerDTO("Klay Thompson", "Guard", 11);

        team.addPlayer(player1);
        team.addPlayer(player2);

        team.playGame();
        team.hireCoach();

        System.out.println(team.getTeamDetails());
    }
}
