#include <stdio.h>
#include <string.h>

/*
Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
*/

int count[256];

int isUnique(char* string) {
    //O(n) time, O(1) space
    for (int i=0; i<strlen(string); i++) {
        count[string[i]]++;
        if (count[string[i]] > 1) {
            return 0;
        }
    }
    return 1;
}

int isUnique2(char* string) {
    //O(n^2) time, O(1) space
    int len = strlen(string);
    for (int i=0; i<len; i++) {
        for (int j=i+1; j<len; j++) {
            if (string[i] == string[j]) {
                return 0;
            }
        }
    }
    return 1;
}

int main() {
    char string[256];
    fgets(string, 256, stdin);
    printf(isUnique1(string) ? "True\n" : "False\n");
}
