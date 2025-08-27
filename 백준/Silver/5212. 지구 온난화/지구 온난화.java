

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        char[][] sea = new char[R][C];
        int[][] newSea = new int[R][C];

        for(int i=0 ; i<R ; i++){
            String line = sc.nextLine();
            for(int j=0 ; j<C ; j++){
                sea[i][j] = line.charAt(j);
                newSea[i][j] = 0;
            }
        }
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int cnt = 0;

                for(int d=0 ; d<4 ; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C){
                        cnt++;
                    } else if(sea[nx][ny] == '.'){
                        cnt++;
                    }
                }

                if(cnt < 3 && sea[i][j] != '.'){
                    newSea[i][j] = 1;
                }
            }
        }
        int minRow = R, maxRow = -1;
        int minCol = C, maxCol = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(newSea[i][j] == 1){
                    if(i<minRow) minRow = i;
                    if(i>maxRow) maxRow = i;
                    if(j<minCol) minCol = j;
                    if(j>maxCol) maxCol = j;
                }
            }
        }

        if(maxRow == -1){
            System.out.println(".");
        }

        for(int i=minRow ; i<=maxRow ; i++){
            for(int j=minCol ; j<=maxCol ; j++){
                System.out.print(newSea[i][j] == 0 ? "." : "X");
            }
            System.out.println();
        }

    }
}
