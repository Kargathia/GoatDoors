/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goatdoors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author karga
 */
public class Game {

    private Set<Integer> doors = new HashSet<>();
    private Set<Integer> droppedDoors = new HashSet<>();
    private final Random rand = new Random();
    private int selectedDoor = 1, 
            goatDoor = -1;
    private final int numDoors;

    public Game(int numDoors) {
        this.numDoors = numDoors;

        for (int i = 0; i < numDoors; i++) {
            this.doors.add(i);
        }
    }

    public void prepareGame() {
        goatDoor = rand.nextInt(numDoors);
    }

    public void dropDoor() {
        int candidate = rand.nextInt(numDoors);
        while (candidate == selectedDoor || candidate == goatDoor) {
            candidate = rand.nextInt(numDoors);
        }
        doors.remove(candidate);
        droppedDoors.add(candidate);
    }

    public void selectDoor() {
        int candidate = rand.nextInt(numDoors);
        while (candidate == selectedDoor || droppedDoors.contains(candidate)) {
            candidate = rand.nextInt(numDoors);
        }
        selectedDoor = candidate;
    }

    public boolean checkSelection() {
        return selectedDoor == goatDoor;
    }
}
