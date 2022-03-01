package com.brian;

public class PlayerInput {
    public static boolean isPlayerInputID(String playerInput){
        try{
            Integer.parseInt(playerInput);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
