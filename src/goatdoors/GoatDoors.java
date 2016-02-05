/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goatdoors;

/**
 *
 * @author karga
 */
public class GoatDoors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numGames = 10000;
        int successRate = 0;
        
        for (int i = 0; i < numGames; i++){
            Game game = new Game(3);       
            game.prepareGame();
            game.selectDoor();
            game.dropDoor();
            game.selectDoor();
            if(game.checkSelection()){
                successRate++;
            }
        }
        
        System.out.println("Sucess rate: " + successRate + " / " + numGames);
    }
}
