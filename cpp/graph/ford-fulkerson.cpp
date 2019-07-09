#include <iostream>
#include <algorithm>
#include <vector>
#include "util.cpp"

using namespace std;

template <typename T>
struct list {
    T val;
    list* next;

    list(T val, list* next) {
        this->val = val;
        this->next = next;
    }
};

template <typename T>
void printList(list<T>* l) {
    cout << "list: ";
    while (l != nullptr) {
        cout << l->val << "->";
        l = l->next;
    }
    cout << "null" << endl;
}

list<int>* resPathDfs(int** r, int A, int B, int N, int mask) {
    if (A == B) {
        return new list<int>(B, nullptr);
    }
    list<int>* res = nullptr;
    for (int i = 0; i < N; i++) {
        if (r[A][i] <= 0 or (mask & (1 << i)) > 0) {
            continue;
        }
        list<int>* tmpRes = resPathDfs(r, i, B, N, mask | (1 << A));
        if (tmpRes != nullptr) {
            res = new list<int>(A, tmpRes);
            break;
        }
    }
    return res;
}

list<int>* resPathDfs(int** r, int A, int B, int N) {
    return resPathDfs(r, A, B, N, 0);
}

int minC(list<int>* path, int** r) {
    int res = INT_MAX;
    list<int>* tmp = path;
    while (tmp != nullptr and tmp->next != nullptr) {
        res = min(res, r[tmp->val][tmp->next->val]);
        tmp = tmp->next;
    }
    return res;
}

int main() {
    const int N = 6;
    const int S = 0;
    const int T = 5;

    // init capacities
    int** c = createGraph(N, 0); 
    // do we need residual graph? no, but it makes everything more clear
    int** r = createGraph(N, 0);

    //c[0][1] = r[0][1] = 10;
    //c[0][2] = r[0][2] = 5;
    //c[1][2] = r[1][2] = 15;
    //c[1][3] = r[1][3] = 5;
    //c[2][3] = r[2][3] = 10;
    
    c[0][1] = r[0][1] = 16;
    c[0][2] = r[0][2] = 13;
    c[1][2] = r[1][2] = 10;
    c[2][1] = r[2][1] = 4;
    c[1][3] = r[1][3] = 12;
    c[3][2] = r[3][2] = 9;
    c[2][4] = r[2][4] = 14;
    c[4][3] = r[4][3] = 7;
    c[3][5] = r[3][5] = 20;
    c[4][5] = r[4][5] = 4;

    printMat(c, N);

    // result flow
    int** f = createGraph(N, 0);

    while (true) {
        // find residual path
        list<int>* path = resPathDfs(r, S, T, N);
        if (path == nullptr) {
            break;
        }
        // if found, update flow and residual graph
        int minCost = minC(path, r);
        list<int>* tmpPath = path;
        while (tmpPath != nullptr and tmpPath->next != nullptr) {
            int s = tmpPath->val;
            int t = tmpPath->next->val;
            f[s][t] += minCost;
            r[s][t] -= minCost;

            f[t][s] -= minCost;
            r[t][s] += minCost;
            tmpPath = tmpPath->next;
        }
    }
    cout << "flow (mat): " << endl;
    printMat(f, N);

    int flow = 0;
    for (int i = 0; i < N; i++) {
        flow += f[S][i];
    }
    cout << "flow: " << flow << endl;
}

