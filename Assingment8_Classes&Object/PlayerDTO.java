/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment8_classesobject;

/**
 * 5. Write two DTO classes to exhibit the has-a relationship given in the diagram. 
 * https://cdn-proxy.slickplan.com/wp-content/uploads/2023/10/8_uml.png
 * Player Data Transfer Object (DTO) class.
 * Represents a player in a sports team.
 * Provides methods to manage the player's information.

 */
public class PlayerDTO {
    private String name;
    private String position;
    private int jerseyNumber;

    public PlayerDTO() {}

    public PlayerDTO(String name, String position, int jerseyNumber) {
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void playGame() {
        System.out.println(name + " is playing a game as " + position + ".");
    }

    public void train() {
        System.out.println(name + " is training.");
    }

    public String getPlayerDetails() {
        return "Player Details:\n" +
               "Name: " + name + "\n" +
               "Position: " + position + "\n" +
               "Jersey Number: " + jerseyNumber;
    }

    public static void main(String[] args) {
        PlayerDTO player = new PlayerDTO("Stephen Curry", "Guard", 30);
        player.playGame();
        player.train();
        System.out.println(player.getPlayerDetails());
    }
}
