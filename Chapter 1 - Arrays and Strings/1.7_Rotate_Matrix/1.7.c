#include <stdio.h>

/*
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
*/

#define n 5

int matrix[n][n];

void rotate() {
    int temp;
    for (int j=0; j<n/2; j++) {
        for (int i=j; i<n-1-j; i++) {
            temp = matrix[j][j+i];
            matrix[j][j+i] = matrix[n-1-i-j][j];
            matrix[n-1-i-j][j] = matrix[n-1-j][n-1-i-j];
            matrix[n-1-j][n-1-i-j] = matrix[j+i][n-1-j];
            matrix[j+i][n-1-j] = temp;
        }
    }
}

void scanMatrix() {
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }
}

void printMatrix() {
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
}

void transpose() {
    int temp;
    for (int i=0; i<n; i++) {
        for (int j=0; j<i; j++) {
            temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}

void invertRows() {
    int temp;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n/2; j++) {
            temp = matrix[i][j];
            matrix[i][j] = matrix[i][n-1-j];
            matrix[i][n-1-j] = temp;
        }
    }
}

void rotate2() {
    transpose();
    invertRows();
}

int main() {
    scanMatrix();
    rotate(); //O(n^2) Faster
    //rotate2(); //O(n^2)
    printf("\n");
    printMatrix();
}
