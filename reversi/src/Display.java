
import acm.graphics.*;

import java.awt.*;

public class Display {

    private final Color SIDE_COLOR = new Color(172, 133, 25);
    private final Color CENTER_COLOR = new Color(73, 179, 24);

    private final Geometry geometry;
    private final GCanvas gcanvas;

    public Display(Geometry geometry, GCanvas gcanvas) {
        this.geometry = geometry;
        this.gcanvas = gcanvas;
        showInitial();
    }

    public void showInitial() {
        gcanvas.setBackground(SIDE_COLOR);
        showBoard();
        showLines();
    }

    private void showBoard() {
        GPoint boardTopLeft = geometry.boardTopLeft();
        GDimension boardDimension = geometry.boardDimension();
        GRect board = new GRect(boardTopLeft.getX(), boardTopLeft.getY(), boardDimension.getWidth(), boardDimension.getHeight());
        board.setFilled(true);
        board.setColor(CENTER_COLOR);
        gcanvas.add(board);
        board.sendToBack(); // TODO: The first four cells do not show if not
    }

    private void showLines() {
        GDimension cellDimension = geometry.cellDimension();
        GPoint boardTopLeft = geometry.boardTopLeft();
        GDimension boardDimension = geometry.boardDimension();
        for (int row = 0; row <= geometry.getRows(); row++) {
            gcanvas.add(new GLine(
                    boardTopLeft.getX(),
                    boardTopLeft.getY() + row * cellDimension.getHeight(),
                    boardTopLeft.getX() + boardDimension.getWidth(),
                    boardTopLeft.getY() + row * cellDimension.getHeight()));
        }
        for (int col = 0; col <= geometry.getColumns(); col++) {
            gcanvas.add(new GLine(
                    boardTopLeft.getX() + col * cellDimension.getWidth(),
                    boardTopLeft.getY(),
                    boardTopLeft.getX() + col * cellDimension.getWidth(),
                    boardTopLeft.getY() + boardDimension.getHeight()));
        }
    }

    private void setDisk(Position p, Color color) {
        GDimension diskDimension = geometry.tokenDimension();
        GPoint diskPosition = geometry.tokenTopLeft(p.getRow(), p.getColumn());
        GOval disk = new GOval(
                diskPosition.getX(),
                diskPosition.getY(),
                diskDimension.getWidth(),
                diskDimension.getHeight());
        disk.setFilled(true);
        disk.setFillColor(color);
        gcanvas.add(disk);
    }

    public void setWhite(Position p) {
        setDisk(p, Color.WHITE);
    }

    public void setBlack(Position p) {
        setDisk(p, Color.BLACK);
    }

    public void reverse(Position p) {
        GOval disk = (GOval) gcanvas.getElementAt(geometry.centerAt(p.getRow(), p.getColumn()));
        if (disk.getFillColor() == Color.BLACK)
            disk.setFillColor(Color.WHITE);
        else
            disk.setFillColor(Color.BLACK);
    }

    public Position toPosition(double x, double y) {
        return geometry.xyToCell(x, y);
    }
}
