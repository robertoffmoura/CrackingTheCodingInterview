#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, sl and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g.,"waterbottle" is a rotation of "erbottlewat").
*/

int isSubstring(char* string, char* subString) {
    return (strstr(string, subString) != NULL);
}

int isRotation(char* string, char* string2) {
    int length = strlen(string2);
    char* largerString = malloc(sizeof(char)*length*2);
    for (int i=0; i<length; i++) {
        largerString[i] = string2[i];
    }
    for (int i=0; i<length; i++) {
        largerString[i+length] = string2[i];
    }
    return isSubstring(largerString, string);
}

int main() {
    char string[256];
    char string2[256];
    scanf("%s%s", string, string2);
    printf("%d\n", isRotation(string, string2));
}
