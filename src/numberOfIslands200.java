/*200. Количество островов
* Для m x n двумерной бинарной сетки grid с изображением карты, состоящей
* из '1' участков (суша) и '0' участков (вода), определите количество островов.
* Остров окружен водой и образован путем соединения соседних участков суши по
* горизонтали или вертикали. Можно считать, что все четыре края сетки окружены водой.*/

public class numberOfIslands200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int islands = 0;
            int m = grid.length;
            int n = grid[0].length;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1'){
                        islands++;
                        check(grid, i, j, m, n);
                    }
                }
            }
            return islands;
        }

        private static void check(char[][] grid, int i, int j, int m, int n){
            grid[i][j] = '0';
            if(j - 1 >= 0 && grid[i][j - 1] == '1'){
                check(grid, i, j - 1, m, n);
            }

            if(j + 1 < n && grid[i][j + 1] == '1'){
                check(grid, i, j + 1, m, n);
            }

            if(i - 1 >= 0 && grid[i - 1][j] == '1'){
                check(grid, i - 1, j, m, n);
            }

            if(i + 1 < m && grid[i + 1][j] == '1'){
                check(grid, i + 1, j, m, n);
            }
        }
    }
}
