import java.util.*;

public class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        final boolean[] visited = new boolean[n];                                //������� ������ visited �������� n
        final Queue<Integer> bfsQueue = new LinkedList<Integer>();               //������� ������� ��� ���������� BFS ���������
        bfsQueue.add(start);                                                     //�������� ��������� ��������� ������������ ������� � ������� (� ����� ������ ��������� ������� �������)
        visited[start] = true;                                                   //�������� ��������� �������� ���� start ��� ����������
        while (!bfsQueue.isEmpty()) {                                            //�������� BFS �������� �� ��� ���, ���� ����� �� ����� �����
            final int currentVertex = bfsQueue.poll();                           //����������� ���������� currentVertex �������� ���������� �������� ������� � ������� ���(����� poll)
            if (currentVertex == end) {                                          //���� ������� ������� ����� ���� end �������������� ������� �������
                return true;
            }
            final Set<Integer> neighbors = findNeighbors(edges, currentVertex);  //���������� ������� �������� ����
            for (int neighbor : neighbors) {                                     //��� ������� ������ ������ ���������:
                if (!visited[neighbor]) {                                        //��������� "���������� �� �� ����� ������ ��� ������ �����?(��������)
                    visited[neighbor] = true;                                    //���� ��� - �� �������� ��� ��� ����������
                    bfsQueue.add(neighbor);                                      //��������� ������ � ��������� ��� �� ����� ��������� ��� �������
                }
            }
        }                                                                        //���� ������� ������ - ������ �� �������� ���� ������� ���� start
        return false;                                                            //� ���� �� �� ����� ���� end ������ � ���� ���� ������.
    }

    private static Set<Integer> findNeighbors(int[][] edges, int v) {            //����� ��� ������ ������� ���� v
        final Set<Integer> neighbors = new HashSet<Integer>();                   //������ ������� ���� v
        for (int i = 0; i < edges.length; i++) {                                 //���������� �� �������
            int[] edge = edges[i];                                               //"����� ������ �����" , ��������([3],[18])
            if (edge[0] == v) {                                                  //���� �� ���� ������� ���� 3, �� edge[0]==[3] == v
                neighbors.add(edge[1]);                                          //��������� � ������ ������� ���� v(3) ������� [18]
            } else if (edge[1] == v) {                                           //���� �� ����� ���� ([18][3]), �� ��� ����� ��������
                neighbors.add(edge[0]);                                          //18 � ������ ������� 3���.
            }
        }
        return neighbors;
    }
}
