package Day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Position {
    private int x;
    private int y;
    private Integer xPrev;
    private Integer yPrev;
    private Character character;
    private final List<Character> VALID_ABOVE = List.of('|', '7', 'F', 'S');
    private final List<Character> VALID_BELOW = List.of('|', 'J', 'L', 'S');
    private final List<Character> VALID_RIGHT = List.of('-', '7', 'J', 'S');
    private final List<Character> VALID_LEFT = List.of('-', 'F', 'L', 'S');

    public Position(int x, int y , Character character){
        this.x = x;
        this.y = y;
        this.character = character;
        this.xPrev = null;
        this.yPrev = null;
    }

    public void findNextPosition(List<List<Character>> pipeMaze){
        List<Position> possiblePositions = new ArrayList<>();

        if(getPositionRight(pipeMaze) != null && this.getCharacter() != '7' && this.getCharacter() != 'J' && this.getCharacter() != '|')
            possiblePositions.add( getPositionRight(pipeMaze));
        if(getPositionLeft(pipeMaze) != null  && this.getCharacter() != '|' && this.getCharacter() != 'L' && this.getCharacter() != 'F')
            possiblePositions.add( getPositionLeft(pipeMaze));
        if(getPositionDown(pipeMaze) != null && this.getCharacter() != 'J' && this.getCharacter() != 'L' && this.getCharacter() != '-')
            possiblePositions.add( getPositionDown(pipeMaze));
        if(getPositionUp(pipeMaze) != null && this.getCharacter() != '7' && this.getCharacter() != 'F' && this.getCharacter() != '-')
            possiblePositions.add( getPositionUp(pipeMaze));


        if(this.xPrev != null && this.yPrev != null){
            possiblePositions = possiblePositions.stream().filter(this::wasNotPrevious).toList();
        }
        Position newPos = possiblePositions.get(0);
        setxPrev(this.x);
        setyPrev(this.y);
        setX(newPos.getX());
        setY(newPos.getY());
        this.character = newPos.getCharacter();

    }

    private boolean wasNotPrevious(Position position) {
        return xPrev != position.x || yPrev != position.y;
    }

    private Position getPositionRight(List<List<Character>> pipeMaze){
        int currentX = this.x+1;
        int currentY = this.y;
        if( currentX >= pipeMaze.size() || !this.VALID_RIGHT.contains(pipeMaze.get(currentY).get(currentX)))
            return null;

        return new Position(currentX,currentY,pipeMaze.get(currentY).get(currentX));
    }
    private Position getPositionLeft(List<List<Character>> pipeMaze){
        int currentX = this.x-1;
        int currentY = this.y;
        if( currentX < 0 || !this.VALID_LEFT.contains(pipeMaze.get(currentY).get(currentX)))
            return null;

        return new Position(currentX,currentY,pipeMaze.get(currentY).get(currentX));
    }
    private Position getPositionUp(List<List<Character>> pipeMaze){
        int currentX = this.x;
        int currentY = this.y-1;

        if( currentY < 0 || !this.VALID_ABOVE.contains(pipeMaze.get(currentY).get(currentX)))
            return null;

        return new Position(currentX,currentY,pipeMaze.get(currentY).get(currentX));
    }
    private Position getPositionDown(List<List<Character>> pipeMaze){
        int currentX = this.x;
        int currentY = this.y+1;

        if( currentY >= pipeMaze.size() || !this.VALID_BELOW.contains(pipeMaze.get(currentY).get(currentX)))
            return null;

        return new Position(currentX,currentY,pipeMaze.get(currentY).get(currentX));
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Integer getxPrev() {
        return xPrev;
    }

    public void setxPrev(Integer xPrev) {
        this.xPrev = xPrev;
    }

    public Integer getyPrev() {
        return yPrev;
    }

    public void setyPrev(Integer yPrev) {
        this.yPrev = yPrev;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
