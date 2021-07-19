package lessons;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final char DOT_HUMAN='X';
    private static final char DOT_AI='0';
    private static final char DOT_EMPTY='.';
    private static final int length=5; // длина ряда для победы

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int scoreHuman;
    private static int scoreAI;


    public static void main(String[] args) {
        while (true) {
            playRound();
            System.out.printf("SCORE IS: HUMAN   AI\n            %d      %d\n", scoreHuman, scoreAI);
            System.out.print("Play again? Y/N: ");
            if (!SCANNER.next().toLowerCase().equals("y")) break;
        }

    }

    private static void playRound() {
        initField(15,9);
        printField();
        while (true) {
            humanTurn();
            printField();
            if (gameCheck(DOT_HUMAN)) break;
            advancedAiTurn();
            //aiTurn();
            System.out.println();
            printField();
            if (gameCheck(DOT_AI)) break;
        }
    }

    private static boolean gameCheck(char dot) {
        if (checkDraw()) {
            System.out.println("DRAW!!!");
            return true;
        }
        if (checkWin(dot)) {
            if (dot == DOT_HUMAN) {
                System.out.println("HUMAN WINS!!!");
                scoreHuman++;
            } else {
                System.out.println("AI WINS!!!");
                scoreAI++;
            }
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x,y)) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char dot) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                boolean flagWin1=false,flagWin2=false,flagWin3=false,flagWin4=false;
                if (i<=fieldSizeX-length) {
                    flagWin1 = true;
                    for (int k = 0; k < length; k++)
                        if (field[i + k][j] != dot)
                            flagWin1 = false;
                }
                if (j<=fieldSizeY-length) {
                    flagWin2=true;
                    for (int k = 0; k < length; k++)
                        if (field[i][j+k] != dot)
                            flagWin2=false;
                }
                if ((i<=fieldSizeX-length) && (j<=fieldSizeY-length)) {
                    flagWin3=true;
                    for (int k = 0; k < length; k++)
                        if (field[i+k][j+k] != dot)
                            flagWin3=false;
                }
                if ((j<=fieldSizeY-length) && (i>=length-1)) {
                    flagWin4=true;
                    for (int k = 0; k < length; k++)
                        if (field[i-k][j+k] != dot)
                            flagWin4=false;
                }
                if (flagWin1 || flagWin2 || flagWin3 || flagWin4) return true;
            }
        }
        return false;
    }

    private static void aiTurn() {
        int x,y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x,y));
        field[x][y] = DOT_AI;
    }

    private static void advancedAiTurn() {
        int x,y,            //  искомый x,y
            ix=-1,iy=-1,    //  первый ход для победы
            dx=-1,dy=-1,    //  первый ход для защиты
            fx=-1,fy=-1,    //  перспективный ход для победы в следующем ходу
            fdx=-1,fdy=-1;  //  перспективный ход для бороны в следующем ходу
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if(isCellEmpty(i,j)) {
                    field[i][j]=DOT_AI;
                    if (checkWin(DOT_AI)) {
                        ix=i;iy=j;
                    } else if (ix<0){
                        for (int k = 0; k < fieldSizeX; k++) {  // на второй ход AI вперёд
                            for (int l = 0; l < fieldSizeY; l++) {
                                if(isCellEmpty(k,l)) {
                                    field[k][l]=DOT_AI;
                                    if(fx<0 && checkWin(DOT_AI)) { fx=k;fy=l; }
                                    field[k][l]=DOT_EMPTY;
                                }
                            }
                        }
                    }
                    field[i][j]=DOT_HUMAN;
                    if (checkWin(DOT_HUMAN)) {
                        dx=i;dy=j;
                    } else if(dx<0) {
                        for (int k = 0; k < fieldSizeX; k++) {  // на второй ход игрока вперёд
                            for (int l = 0; l < fieldSizeY; l++) {
                                if(isCellEmpty(k,l)) {
                                    field[k][l]=DOT_HUMAN;
                                    if(fdx<0 && checkWin(DOT_HUMAN)) { fdx=k;fdy=l; }
                                    field[k][l]=DOT_EMPTY;
                                }
                            }
                        }

                    }
                    field[i][j]=DOT_EMPTY;
                }
            }
        }
        if (ix>=0) {
            x=ix;y=iy;
        } else if (dx>=0) {
            x=dx;y=dy;
        } else if (fx>=0) {
            x=fx;y=fy;
        } else if (fdx>=0) {
            x=fdx;y=fdy;
        } else do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x,y));
        field[x][y] = DOT_AI;
    }

    private static void humanTurn() {
        int x,y;
        do {
            System.out.println("Enter coordinates X Y: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x,y) || !isCellEmpty(x,y));
        field[x][y] = DOT_HUMAN;
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    private static void initField(int sizeX, int sizeY) {
        fieldSizeX = sizeX;
        fieldSizeY = sizeY;
        field = new char[fieldSizeX][fieldSizeY];
        for (int y = 0; y < fieldSizeY ; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX *2 +1; i++) {
            if (i<18) System.out.print((i%2==0)? "-- " : i/2 +1);
            else System.out.print((i%2==0)? "--" : i/2 +1);
        }
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            if (i<9) System.out.print(" ");
            System.out.print(i+1+"| ");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[j][i]+" | ");
            }
            System.out.println();
        }
    }

}
