#include <stdio.h>

/*
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
*/

#define m 3
#define n 4

int matrix[m][n];

int imemory[m];
int jmemory[n];

void scan() {
    for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) {
            scanf("%d",&matrix[i][j]);
        }
    }
}

void check() {
    for (int i=0; i<m; i++) {
        if (imemory[i]) continue;
        for (int j=0; j<n; j++) {
            if (jmemory[j]) continue;
            if (matrix[i][j] == 0) {
                imemory[i] = 1;
                jmemory[j] = 1;
                break;
            }
        }
    }
}

void modify() {
    for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) {
            if (imemory[i] || jmemory[j]) {
                matrix[i][j] = 0;
            }
        }
    }
}

void print() {
    for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    scan();
    check();
    modify();
    print();
}
