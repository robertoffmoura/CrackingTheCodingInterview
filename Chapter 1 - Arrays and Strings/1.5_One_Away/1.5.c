#include <stdio.h>
#include <string.h>

/*
There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
*/

int checkSameLengthStrings(char* string1, char* string2) {
    int errorCount = 0;
    for (int i=0; i<strlen(string1); i++) {
        if (string1[i] != string2[i]) {
            errorCount++;
        }
        if (errorCount > 1) {
            return 0;
        }
    }
    return 1;
}

int checkDifferentLengthStrings(char* string1, char* string2) {
    int errorCount = 0;
    for (int i=0; i<strlen(string1); i++) {
        if (string1[i+errorCount] != string2[i]) {
            errorCount++;
        }
        if (errorCount > 1) {
            return 0;
        }
    }
    return 1;
}

int absValue(int x) {
    return x > 0 ? x : -x;
}

int checkStrings(char* string1, char* string2) {
    int diff = absValue((int)strlen(string1) - (int)strlen(string2));
    if (diff > 1) return 0;
    int errorCount = 0;
    for (int i=0; i<strlen(string1); i++) {
        if (string1[i+errorCount*diff] != string2[i]) {
            errorCount++;
        }
        if (errorCount > 1) {
            return 0;
        }
    }
    return 1;
}

int main() {
    unsigned long x = 1;
    unsigned long y = 2;
    char string1[256];
    char string2[256];
    fgets(string1,256,stdin);
    fgets(string2,256,stdin);
    printf(checkStrings(string1, string2) ? "True\n" : "False\n");
    /*
    if (strlen(string1) == strlen(string2)) {
        printf(checkSameLengthStrings(string1,string2) ? "True\n" : "False\n");
        return 0;
    }
    if (strlen(string1) == strlen(string2) + 1) {
        printf(checkDifferentLengthStrings(string1,string2) ? "True\n" : "False\n");
        return 0;
    }
    if (strlen(string2) == strlen(string1) + 1) {
        printf(checkDifferentLengthStrings(string2,string1) ? "True\n" : "False\n");
        return 0;
    }
    printf("False\n");
    */
}
