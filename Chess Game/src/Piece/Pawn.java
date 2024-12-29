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
public class Pawn extends Piece{

    public Pawn(int color, int col, int row) {
        super(color, col, row);
        
        type= Type.PAWN;
        
        if(color== GamePanel.WHITE){
            image=getImage("/Piece_images/white_pawn");
        }
        else{
            image= getImage("/Piece_images/black_pawn");
        }
    }
    
    public boolean canMove(int targetCol, int targetRow){
        if(isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false){
            
            //Define the move value based in its color
            int moveValue;
            if(color == GamePanel.WHITE){
                moveValue= -1;
            }
            else{
                moveValue= 1;
            }
            
            //Check the hitting Piece
            hittingP= getHittingP(targetCol, targetRow);
            
            // 1 square movement
            if(targetCol == preCol && targetRow== preRow + moveValue && hittingP == null){
                return true;
            }
            //2 squares movement
            if(targetCol == preCol && targetRow == preRow + moveValue * 2 && hittingP == null && moved == false && 
                    pieceIsOnStraightLine(targetCol, targetRow) == false){
                return true;
            }
            //Diagonal movement & Capture (if a piece is on a square diagonally in front of it)
            if(Math.abs(targetCol - preCol ) == 1 && targetRow == preRow + moveValue && hittingP != null &&
                    hittingP.color !=color){
                return true;
            }
            // En Passant
            if(Math.abs(targetCol - preCol ) == 1 && targetRow == preRow + moveValue){
                for(Piece Piece : GamePanel.simPieces){
                  if(Piece.col== targetCol && Piece.row == preRow && Piece.twoStepped == true){
                  hittingP =Piece;
                  return true;
                }
                }
            }
        }
        return false;
    }
}
