package editor;

public class LevelTest {
    public static void main(String[] args) {
        try {
            System.out.println(new Level("C:\\Users\\s201109649\\IdeaProjects\\pac-maze\\res\\level 1.txt").toString());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
