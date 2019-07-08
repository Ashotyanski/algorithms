#include <iostream>
#include <vector>

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
