#include <stdio.h>
#include <string.h>

/*
Given a string, write a function to check if it is a permutation of a palin­drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)
*/

int letterIndex(char c) {
    if (0 <= c-'a' && c-'a' <= 26) {
        return c-'a';
    }
    if (0 <= c-'A' && c-'A' <= 26) {
        return c-'A';
    }
    return 26;
}

int charCount[26+1];

int isPalindromePermutation(char* string) {
    int oddCount = 0;
    for (int i=0; i<strlen(string); i++) {
        if (string[i] == ' ') {
            continue;
        }
        int index = letterIndex(string[i]);
        if (charCount[index]) {
            continue;
        } else {
            charCount[index]++;
        }
        for (int j=i+1; j<strlen(string); j++) {
            if (string[j] == string[i]) {
                charCount[index]++;
            }
        }
        if (charCount[index]%2 == 1) {
            oddCount++;
        }
        if (oddCount > 1) {
            return 0;
        }
    }
    return 1;
}

int isPalindromePermutation2(char* string) {
    int oddCount = 0;
    for (int i=0; i<26; i++) {
        charCount[i] = 0;
    }
    for (int i=0; i<strlen(string); i++) {
        if (string[i] == ' ') {
            continue;
        }
        int index = letterIndex(string[i]);
        charCount[index]++;
    }
    for (int i=0; i<26; i++) {
        if (charCount[i]%2 == 1) {
            oddCount++;
        }
        if (oddCount > 1) {
            return 0;
        }
    }
    return 1;
}

int main() {
    char string[256];
    fgets(string,256,stdin);
    printf(isPalindromePermutation2(string) ? "True\n" : "False\n");
}
