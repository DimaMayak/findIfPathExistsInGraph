import java.util.*;

public class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        final boolean[] visited = new boolean[n];                                //Создаем массив visited размером n
        final Queue<Integer> bfsQueue = new LinkedList<Integer>();               //Создаем очередь для реализации BFS алгоритма
        bfsQueue.add(start);                                                     //Согласно алгоритму добавляем произвольный елемент в очередь (в нашем случае начальный елемент цепочки)
        visited[start] = true;                                                   //Согласно алгоритму помечаем узел start как посещенный
        while (!bfsQueue.isEmpty()) {                                            //Алгоритм BFS работает до тех пор, пока очедь не будет пуста
            final int currentVertex = bfsQueue.poll();                           //Присваивает переменной currentVertex значение последнего елемента очереди и удаляет его(метод poll)
            if (currentVertex == end) {                                          //Если елемент очереди равен узлу end соответственно вершины связаны
                return true;
            }
            final Set<Integer> neighbors = findNeighbors(edges, currentVertex);  //Определяем соседей текущего узла
            for (int neighbor : neighbors) {                                     //Для каждого соседа делаем следующее:
                if (!visited[neighbor]) {                                        //Проверяем "добирались мы до етого соседа уже другим путем?(посещали)
                    visited[neighbor] = true;                                    //Если нет - то отмечаем его как посещенный
                    bfsQueue.add(neighbor);                                      //Добасляем соседа в очерередь что бы потом проверить его соседей
                }
            }
        }                                                                        //Если очередь пустая - значит мы посетили всех соседей узла start
        return false;                                                            //И если мы не нашли узел end значит к нему нету связей.
    }

    private static Set<Integer> findNeighbors(int[][] edges, int v) {            //Метод для поиска соседей узла v
        final Set<Integer> neighbors = new HashSet<Integer>();                   //Список соседей узла v
        for (int i = 0; i < edges.length; i++) {                                 //Проходимся по массиву
            int[] edge = edges[i];                                               //"берем первую связь" , допустим([3],[18])
            if (edge[0] == v) {                                                  //Если мы ищем соседей узла 3, то edge[0]==[3] == v
                neighbors.add(edge[1]);                                          //Добавляем в список соседей узла v(3) елемент [18]
            } else if (edge[1] == v) {                                           //Если бы связь была ([18][3]), то все равно добаляем
                neighbors.add(edge[0]);                                          //18 в список соседей 3йки.
            }
        }
        return neighbors;
    }
}
