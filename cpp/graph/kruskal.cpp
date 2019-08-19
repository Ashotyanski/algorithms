#include "util.cpp"
#include <vector>

using namespace std;

struct Edge {
    int a, b, w;
    Edge(int a, int b, int w) {
        this->a = a;
        this->b = b;
        this->w = w;
    }
};

bool comp(Edge* e1, Edge* e2) {
    return e1->w < e2->w;
}

void printEdgeVec(vector<Edge*>* vec) {
    for (Edge* e : *vec) {
        cout << e->a << "->" << e->b << " |" << e->w << endl;
    }
}

int Find(int* unions, int a) {
    int tmp = a;
    while (unions[tmp] != tmp) {
        tmp = unions[tmp];
    }
    return tmp;
}

void Union(int* unions, int a, int b) {
    unions[b] = a;
}

/**
 * Kruskal algorithm
 */
int main() {
    // take matrix
    const int N = 5;
    int** mat = new int*[N];
    for (int i = 0; i < N; i++) {
        mat[i] = new int[N]();
    }
    printMat(mat, N);
    mat[0][1] = mat[1][0] = 1;
    mat[1][2] = mat[2][1] = 2;
    mat[2][3] = mat[3][2] = 4;
    mat[3][0] = mat[0][3] = 5;
    mat[0][2] = mat[2][0] = 1;
    mat[1][3] = mat[3][1] = 1;

    // convert to list of edges
    vector<Edge*> edges;
    for (int i = 0; i < N; i++) {
        for (int j = i; j < N; j++) {
            if (mat[i][j] > 0) {
                edges.push_back(new Edge(i, j, mat[i][j]));
            }
        }
    }
    printEdgeVec(&edges);
    
    // sort
    sort(edges.begin(), edges.end(), comp);
    cout << "Sorted:" << endl;
    printEdgeVec(&edges);
    
    // use union find to build span
    int* unions = new int[N]();
    for (int i = 0; i < N; i++) {
        unions[i] = i;
    }

    vector<Edge*> result;
    for (Edge* e : edges) {
        int unionA = Find(unions, e->a);
        int unionB = Find(unions, e->b);
        if (unionA != unionB) {
            Union(unions, unionA, unionB);
            result.push_back(e);
        }
    }
    cout << "Result" << endl;
    printEdgeVec(&result);

    return 0;
}
