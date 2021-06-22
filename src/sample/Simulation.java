package sample;

public class Simulation {
    int width;
    int height;
    int[][] board;
    int[][] newBoardGeneration;

    public static void main(String[] args) {
        Simulation simulation = new Simulation(400,400);
        simulation.setAlive(3, 2);
        simulation.setAlive(3, 3);
        simulation.setAlive(3, 4);
        simulation.printBoard();
        simulation.step();
        System.out.println();
        simulation.printBoard();
    }

    public Simulation(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
        this.newBoardGeneration = new int[width][height];
    }

    public void setAlive(int x, int y) {
        this.board[x][y] = 1;
    }

    public void setDead(int x, int y) {
        this.board[x][y] = 0;
    }

    public void printBoard() {
        char symbol;
        System.out.println("----------");
        for (int y = 0; y < height; y++) {
            StringBuilder line = new StringBuilder("|");
            for (int x = 0; x < width; x++) {
                if (this.board[x][y] == 0) {
                    symbol = '.';
                }
                else {
                    symbol = '*';
                }
                line.append(symbol);
            }
            line.append("|");
            System.out.println(line);
        }
        System.out.println("----------");
    }


    public int getState(int x, int y) {
        if (x < 0 || x >= width) {
            return 0;
        }
        if (y < 0 || y >= height) {
            return 0;
        }
        return this.board[x][y];
    }


    public int countAliveNeighbors(int x, int y){
        int count = 0;
        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);
        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);
        return count;
    }

    public void step(){
        int [][] newBoard = new int [width][height];
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                int aliveNeighbors = countAliveNeighbors(x, y);

                if (getState(x, y) == 1) {
                    if (aliveNeighbors == 2 || aliveNeighbors == 3)
                        newBoard[x][y] = 1;

                    else
                        newBoard[x][y] = 0;
                }

                if(getState(x, y) == 0){
                    if (aliveNeighbors == 3)
                        newBoard[x][y] = 1;

                    else
                        newBoard[x][y] = 0;
                }
            }
        }
        this.board = newBoard;
    }


}
