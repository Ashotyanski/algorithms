#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;

void printMat(int** mat, const int size) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            cout << mat[i][j] << " ";
        }
        cout << endl;	
    }
}

template<class T>
void printVec(vector<T>* vec) {
    for (int i = 0; i < vec->size(); i++) {
        cout << (*vec)[i] << ", ";
    }
    cout << endl;
}

void printPathRec(vector<int>* paths, int node) {
    if (node != (*paths)[node]) {
        printPathRec(paths, (*paths)[node]);
        cout << ", ";
    }
    cout << node;
}

void printPath(vector<int>* paths, int node) {
    cout << "path: ";
    printPathRec(paths, node);
    cout << endl;
}

struct Edge {
    int src, dst, w;

    Edge(int s, int d, int w) {
        this->src = s;
        this->dst = d;
        this->w = w;
    }
};

bool compEdge(const Edge* a, const Edge* b) {
    if (a and b) {
        return a->w > b->w;
    }
    return a == nullptr;
}

int main() {
    const int N = 5;
    const int A = 0;
    const int B = 4;

    int** mat = new int*[N];
    for (int i = 0; i < N; i++) {
        mat[i] = new int[N]();
        fill((mat[i]), (mat[i]) + N, 0);
    }

    mat[0][1] = mat[1][0] = 9;
    mat[0][2] = mat[2][0] = 1;
    mat[2][3] = mat[3][2] = 1;
    mat[3][4] = mat[4][3] = 1;
    mat[1][4] = mat[4][1] = 9;
    mat[2][4] = mat[4][2] = 9;
    printMat(mat, N);

    // init distances to other nodes to inf
    vector<int> dists(N);
    for (int i = 0; i < N; i++) {
        if (i != A) {
            dists[i] = INT_MAX;
        }
    }

    // init heap with start node
    vector<Edge*> heap;
    heap.push_back(new Edge(A,A,0));
    push_heap(heap.begin(), heap.end(), compEdge);

    // paths: each node stores previous node down the shortest path
    vector<int> paths(N);

    // visited nodes
    uint mask = 0;
    while (!heap.empty()) {
        // pop the cheapest edge
        Edge* e = heap.front();
        pop_heap(heap.begin(), heap.end());
        heap.pop_back();

        // update dist
        if (dists[e->src] + e->w < dists[e->dst]) {
            dists[e->dst] = dists[e->src] + e->w;
            paths[e->dst] = e->src;
        }

        // add adjacents to heap, if this node wasn't visited
        if ((mask & (1 << e->dst)) == 0) {
            mask |= 1 << e->dst;
            for (int i = 0; i < N; i++) {
                if (mat[e->dst][i] > 0) {
                    heap.push_back(new Edge(e->dst, i, mat[e->dst][i]));
                    push_heap(heap.begin(), heap.end(), compEdge);
                }
            }
        }
    }
    printVec(&dists);
    printPath(&paths, B);
}
