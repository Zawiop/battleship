import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BattleShipPanel {
    int[][] scoreBoard = new int[9][9];
    for(int x =0; x < 10; x++){
        for(int y = 0; y < 10; y++){
            scoreBoard[x][y] = 0; 
        }
    }
    // 0 = Not Hit, No Ship on the coordinate
    // 2 = Hit, No Ship on the coordinate
    // 3 = Not Hit, Ship on the coordinate
    // 4 = Hit, Ship on coordinate


}


