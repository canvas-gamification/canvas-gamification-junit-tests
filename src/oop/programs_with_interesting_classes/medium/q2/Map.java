package oop.programs_with_interesting_classes.medium.q2;

public class Map {
    private static final int[][] connections = {
            {0, 200, 300, 224, 312},
            {200, 0, -1, -1, 12},
            {300, -1, 0, 651, 167},
            {224, -1, 651, 0, -1},
            {312, 12, 167, -1, 0}
    };

    public static int calculateDistance(int a, int b) {
        int distance = 0;
        if (connections[a][b] != -1)
            distance = connections[a][b];
        else {
            for (int i = 0; i < connections[a].length; i++) {
                if (i != a && i != b)
                    if (connections[a][i] != -1 && connections[i][b] != -1) {
                        distance = connections[a][i] + connections[i][b];
                        break;
                    }
            }
        }
        return distance;
    }
}
