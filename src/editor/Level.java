package editor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class Level
{
    public enum Cell
    {
        WALL("w"),
        SPACE("s"),
        DOT("d"),
        GHOST("g"),
        ENTRANCE("b"),
        EXIT("e");
        private String letter;

        Cell(String letter) {
            this.letter = letter;
        }

        public static Cell getByLetter(String letter) throws Exception
        {
            switch (letter)
            {
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
    }

    public Cell[][] cells = new Cell[15][15];

    public Level() { }

    public Level(String filename) throws Exception
    {
        String[] lines;

        FileReader f = new FileReader(filename);
        BufferedReader br  = new BufferedReader(f);
        lines = br.lines().filter(l -> l.trim().length() > 0).collect(Collectors.toList()).toArray(new String[]{});

        this.loadFromLines(lines);
    }

    public void loadFromLines(String[] lines) throws Exception
    {
        this.cells = new Cell[15][15];
        for (int l = 0; l < lines.length; l++)
        {
            if (l >= 15) throw new Exception("too many lines");
            String line = lines[l];
            for (int i = 0; i < line.length(); i++)
            {
                if (i >= 15) throw new Exception("too many columns");
                this.cells[l][i] = Cell.getByLetter(Character.toString(line.charAt(i)));
            }
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Cell[] line: cells)
        {
            for (Cell cell: line)
            {
                sb.append(cell.letter);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
