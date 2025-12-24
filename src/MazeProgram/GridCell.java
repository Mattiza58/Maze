package MazeProgram;

import MazeProgram.MazeGUI.Cell;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.*;

/**
 * The graphical component of the maze grid
 */
public class GridCell extends JPanel {

    /**
     * The list of cell objects
     */
    private ArrayList<Cell> cells;

    /**
     * The color of each cell
     */
    private Color color;

    /**
     * Constructs a new 'GridCell' object
     */
    public GridCell(ArrayList<Cell> cells, Color color) {
        this.cells = cells;
        this.color = color;
    }

    /**
     * Updates the reference to the cell list. Requires 'newCells' is not null.
     */
    public void updateCells(ArrayList<Cell> newCells) {
        assert newCells != null;
        this.cells = newCells;
    }

    /**
     * Updates the color of each cell. Requires that 'newColor' is not null.
     */
    public void updateColor(Color newColor) {
        assert newColor != null;
        this.color = newColor;
    }

    @Override
    public void paintComponent(Graphics g) {
        for (Cell cell : cells) {
            boolean[] walls = cell.walls();
            int x = cell.xPos();
            int y = cell.yPos();
            int w = cell.cellWidth();
            g.setColor(color);
            if (walls[0]) {
                g.drawLine(x, y, x + w, y); // top
            }
            if (walls[1]) {
                g.drawLine(x + w, y, x + w, y + w); // right
            }
            if (walls[2]) {
                g.drawLine(x + w, y + w, x, y + w); // bottom
            }
            if (walls[3]) {
                g.drawLine(x, y + w, x, y); // left
            }
        }
    }
}
