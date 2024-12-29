/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piece;

import chess.game.GamePanel;
import chess.game.Type;

/**
 *
 * @author darknight
 */
public class Rook extends Piece{

    public Rook(int color, int col, int row) {
        super(color, col, row);
        
        type = Type.ROOK;
        
        if(color==GamePanel.WHITE){
            image=getImage("/Piece_images/white_rook");
        }
        else{
            image=getImage("/Piece_images/black_rook");
        }
    }
    
    public boolean canMove(int targetCol, int targetRow){
        if(isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow)==false){
            //Rook can move as long as either its col or row is the same
            if (targetCol== preCol || targetRow == preRow){
                if(isValidSquare(targetCol, targetRow) && pieceIsOnStraightLine(targetCol, targetRow)== false){
                    return true;
                }
            }
        }
        return false;
    }
}
