package Piece;

import chess.game.GamePanel;
import chess.game.Type;

/**
 *
 * @author darknight
 */
public class Queen extends Piece{

    public Queen(int color, int col, int row) {
        super(color, col, row);
        
        type = Type.QUEEN;
        
        if(color== GamePanel.WHITE){
            image=getImage("/Piece_images/white_queen");
        }
        else{
            image= getImage("/Piece_images/black_queen");
        }
    }
    
    public boolean canMove(int targetCol, int targetRow){
        if(isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow)== false){
            
            // Vertical & Horizontal 
            if(targetCol == preCol || targetRow == preRow){
                if(isValidSquare(targetCol, targetRow) && pieceIsOnStraightLine(targetCol, targetRow) ==false){
                    return true;
                }
            }
            //Diagonal
            if(Math.abs(targetCol- preCol) == Math.abs(targetRow - preRow)){
                if(isValidSquare(targetCol, targetRow) && pieceIsOnDiagonalLine(targetCol, targetRow) == false){
                    return true;
                }
            }
        }
        return false;
    }
}