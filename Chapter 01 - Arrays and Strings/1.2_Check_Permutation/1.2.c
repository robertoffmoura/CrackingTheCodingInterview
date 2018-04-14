#include <stdio.h>
#include <string.h>

/*
Given two strings,write a method to decide if one is a permutation of the
other.
*/
/*
Approach 1:
Sort both arrays, check if both arrays match
Approach 2:
Count how many times each character appears in each array and then compare for each character
*/

#define size 10

void sort(char* vector, int start, int end) {
    //printf("start,mid,end = %d,%d,%d\n",start,mid,end);
    if (start == end) {
        return;
    }
    int mid = (start + end) / 2;
    sort(vector,start,mid);
    sort(vector,mid+1,end);
    int length = end-start+1;
    int helperArray[length];
    int i = 0;
    int j = start;
    int k = mid+1;
    while (i<length && j < mid+1 && k < end+1) {
        helperArray[i++] = vector[j] < vector[k] ? vector[j++] : vector[k++];
    }
    while (j < mid+1) helperArray[i++] = vector[j++];
    while (k < end+1) helperArray[i++] = vector[k++];

    for (int i=0; i<length; i++) {
        vector[start+i] = helperArray[i];
    }
    return;
}

int isPermutation(char* a, char* b) {
    sort(a,0,strlen(a)-1);
    sort(b,0,strlen(b)-1);
    for (int i=0; i<strlen(a);i++) {
        if (a[i] != b[i]) {
            return 0;
        }
    }
    return 1;
}

int isPermutation2(char* a, char* b) {
    int count1[256];
    int count2[256];
    for (int i=0; i<256; i++) {
        count1[i] = 0;
        count2[i] = 0;
    }
    int length = strlen(a);
    for (int i=0; i<length; i++) {
        count1[a[i]]++;
    }
    length = strlen(b);
    for (int i=0; i<length; i++) {
        count2[b[i]]++;
    }
    for (int i=0; i<256; i++) {
        if (count1[i] != count2[i]) {
            return 0;
        }
    }
    return 1;
}

int main() {
    char a[size];
    char b[size];
    scanf("%s",a);
    scanf("%s",b);
    printf("%d\n",isPermutation(a,b));//O(n log(n)) time
    printf("%d\n",isPermutation2(a,b));//O(n) time
    //printf("%s\n",a);
    //printf("%s\n",b);
}
