#include <stdio.h>

/*
Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
*/

int main() {
    char string[256];
    fgets(string,256,stdin);
    char string2[256];
    int j = 0;
    for (int i=0; i+j<256; i++) {
        while (string[i+j] == ' ') {
            string2[i++] = '%';
            string2[i++] = '2';
            string2[i++] = '0';
            j-=2;
        }
        string2[i] = string[i+j];
    }
    printf("%s", string2);
}
