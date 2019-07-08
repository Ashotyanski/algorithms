#include <algorithm>
#include <iostream>
#include "util.cpp"

using namespace std;

struct Edge {
    // src, dst, weight
    int s, d, w;

    Edge(int s, int d, int w) {
        this->s = s;
        this->d = d;
        this->w = w;
    }
};

bool compEdge(const Edge* a, const Edge* b) {
    if (a and b) {
        return a->w > b->w;
    }
    return a == nullptr;
}

bool inMask(int mask, int n) {
    return (mask & (1 << n)) > 0;
}

int main() {
    const int N = 5;
    const int A = 0;

    int** g = new int*[N];
    for (int i = 0; i < N; i++) {
        g[i] = new int[N]();
    }

    g[0][1] = g[1][0] = 9;
    g[0][2] = g[2][0] = 1;
    g[2][3] = g[3][2] = 1;
    g[3][4] = g[4][3] = 1;
    g[1][4] = g[4][1] = 9;
    g[2][4] = g[4][2] = 9;
    printMat(g, N);
    
    vector<Edge*> mst;
    vector<Edge*> heap;
    int mask = 0;

    heap.push_back(new Edge(A,A,0));
    push_heap(heap.begin(), heap.end(), compEdge);

    while (!heap.empty()) {
        // select closest vertex from heap, that doesn't cause cycle
        Edge* e = nullptr;
        while ((e == nullptr || (inMask(mask, e->s) && inMask(mask, e->d))) && !heap.empty()) {
            e = heap.front();
            pop_heap(heap.begin(), heap.end());
            heap.pop_back();
        }
        if (inMask(mask, e->s) && inMask(mask, e->d)) {
            break;
        }
        cout << "processing: " << e->s << "->" << e->d << endl;

        // mark vertex visited
        mask |= (1 << e->d);
        
        // add to result
        mst.push_back(e);

        // add adjacent edges
        for (int i = 0; i < N; i++) {
            if (g[e->d][i] > 0 && !inMask(mask, i)) {
                heap.push_back(new Edge(e->d, i, g[e->d][i]));
                push_heap(heap.begin(), heap.end(), compEdge);
            }
        }
    }

    cout << "mst: ";
    for (int i = 0; i < mst.size(); i++) {
        cout << mst[i]->s << "->" << mst[i]->d << endl;
    }
}
