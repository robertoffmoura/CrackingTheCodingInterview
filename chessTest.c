for (int i=0; i<8; i++) {
    for (int j=0; j<8; j++) {
        printf("%d ", canMoveTo(i, j) ? 1 : 0);
    }
    printf("\n");
}

/*
expected output for a knight at (4, 4):

0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 1 0 1 0 0
0 0 1 0 0 0 1 0
0 0 0 0 1 0 0 0
0 0 1 0 0 0 1 0
0 0 0 1 0 1 0 0
0 0 0 0 0 0 0 0

Then i would test for integers outside the range [0,7]

*/
