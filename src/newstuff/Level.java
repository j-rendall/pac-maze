package newstuff;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Level {
    public Object paint;

    public enum Cell {
        WALL("w", Color.decode("#000000")),
        SPACE("s", Color.decode("#35a3d6")),
        DOT("d", Color.decode("#35a3d6")),
        GHOST("g", Color.decode("#eeeeeee")),
        ENTRANCE("b", Color.decode("#0000ff")),
        EXIT("e", Color.decode("#ff0000"));

        private String letter;
        private Color color;

        Cell(String letter, Color color) {
            this.letter = letter;
            this.color = color;
        }

        public static Cell getByLetter(String letter) throws Exception {
            switch (letter) {
                case "w":
                    return Cell.WALL;
                case "s":
                    return Cell.SPACE;
                case "d":
                    return Cell.DOT;
                case "b":
                    return Cell.ENTRANCE;
                case "g":
                    return Cell.GHOST;
                case "e":
                    return Cell.EXIT;
                default:
                    throw new Exception("invalid character");
            }
        }

        public void drawOn(Graphics2D g, int x, int y, int w, int h) {
            g.setColor(this.color);
            g.fillRect(x, y, w, h);
        }
    }

    public static class Point {
        public final int row;
        public final int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public String toString() {
            return String.format("row=%d col=%d", this.row+1, this.col+1);
        }
    }

    public Cell getCell(Point p) {
        return this.cells[p.row][p.col];
    }

    public void setCell(Point p, Cell c) {
        this.cells[p.row][p.col] = c;
    }

    public Cell[][] cells = new Cell[15][15];

    public Level() {
    }

    public Level(String filename) throws Exception {
        String[] lines;

        FileReader f = new FileReader(filename);
        BufferedReader br = new BufferedReader(f);
        lines = br.lines().filter(l -> l.trim().length() > 0).collect(Collectors.toList()).toArray(new String[]{});

        this.loadFromLines(lines);
    }

    public Level(InputStream s) throws Exception {
        String[] lines;

        BufferedReader br = new BufferedReader(new InputStreamReader(s));
        lines = br.lines().filter(l -> l.trim().length() > 0).collect(Collectors.toList()).toArray(new String[]{});

        this.loadFromLines(lines);
    }

    public void loadFromLines(String[] lines) throws Exception {
        this.cells = new Cell[15][15];
        for (int l = 0; l < lines.length; l++) {
            if (l >= 15) throw new Exception("too many lines");
            String line = lines[l];
            for (int i = 0; i < line.length(); i++) {
                if (i >= 15) throw new Exception("too many columns");
                this.cells[l][i] = Cell.getByLetter(Character.toString(line.charAt(i)));
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] line : cells) {
            for (Cell cell : line) {
                sb.append(cell.letter);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // (x, y) is the place to start drawing the board
    // (cw, ch) is the cell size

    public void drawOn(Graphics2D g, int x, int y, int cw, int ch) {
        Graphics2D g2d = (Graphics2D) g;
        int curX;
        int curY = ch;

        Font stringFont = new Font( "Arial", Font.PLAIN, 20 );
        String menu = "MENU";
        String exit = "EXIT";

        g2d.setColor(Color.decode("#0000ff"));
        g2d.fillRect(0,0,5000, 5000);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(28, 25, 67, 25);
        g2d.fillRect(28, 65, 67, 25);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(23, 20, 67, 25);
        g2d.fillRect(23, 60, 67, 25);
        g2d.setColor(Color.BLACK);
        g2d.setFont(stringFont);
        g2d.drawString(menu, 29, 40);
        g2d.drawString(exit, 34, 80);

        for (Cell[] row: this.cells) {
            curX = cw;
            for (Cell cell: row) {
                cell.drawOn(g, x + curX - cw, y + curY - ch, cw, ch);
                if (cell.letter == "d")
                {
                    g2d.setColor(Color.decode("#ffffff"));
                    g2d.fillOval(x + curX - cw + 17, y + curY - ch + 17, 16, 16);
                }
                curX += cw;

            }
            curY += ch;
        }
    }

    // (x, y) is the place to start drawing the board
    // (cw, ch) is the cell size
    // (cx, cy) is the screen coordinates to get whichever cell is under it
    public Point getCellIndex(int x, int y, int width, int height, int cx, int cy) {
        if (cx-x <= 0 || cy-y <= 0) {
            // not on the board
            return new Point(0, 0);
        }

        int row, col;
        col = (cx - x) / width;
        row = (cy - y) / height;
        return new Point(row, col);
    }
}
