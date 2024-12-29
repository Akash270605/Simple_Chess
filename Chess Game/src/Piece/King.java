package Piece;

import chess.game.GamePanel;
import chess.game.Type;

/**
 *
 * @author darknight
 */
public class King extends Piece{

    public King(int color, int col, int row) {
        super(color, col, row);
        
        type= Type.KING;
        
        if(color== GamePanel.WHITE){
            image=getImage("/Piece_images/white_king");
        }
        else{
            image= getImage("/Piece_images/black_king");
        }
    }
    
    public boolean canMove(int targetCol, int targetRow){
        if(isWithinBoard(targetCol, targetRow)){
            
            //Movement
            if(Math.abs(targetCol - preCol ) + Math.abs(targetRow - preRow) ==1 ||
                    Math.abs(targetCol -preCol) * Math.abs(targetRow - preRow) ==1){
               
                if(isValidSquare(targetCol, targetRow)){
                return true;
                }
            }
            //Castling
            if(moved == false){
                
                // Right castling
                if(targetCol == preCol+2 && targetRow == preRow && pieceIsOnStraightLine(targetCol, targetRow) == false){
                    for(Piece Piece : GamePanel.simPieces){
                        if(Piece.col == preCol +3 && Piece.row == preRow && Piece.moved == false){
                            GamePanel.castlingP =Piece;
                            return true;       
                        }
                    }
                }
                
                //left casting
                if(targetCol == preCol-2 && targetRow == preRow && pieceIsOnStraightLine(targetCol, targetRow) == false){
                    Piece p[] =new Piece[2];
                    for(Piece Piece : GamePanel.simPieces){
                        if(Piece.col == preCol-3 && Piece.row == targetRow ){
                            p[0]= Piece;
                        }
                        if(Piece.col == preCol -4 && Piece.row == targetRow ){
                            p[1] =Piece;
                        }
                        if(p[0] == null && p[1] != null && p[1].moved == false){
                            GamePanel.castlingP =p[1];
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
