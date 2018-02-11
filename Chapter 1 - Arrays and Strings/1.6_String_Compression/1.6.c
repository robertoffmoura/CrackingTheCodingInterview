#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

/*
Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
*/

int numberOfDigits(int number) {
    int result = 0;
    while (number > 0) {
        result++;
        number /= 10;
    }
    return result;
}

/*
char* toString(int number) {
    int digits = numberOfDigits(number);
    char* string = malloc(sizeof(char)*digits);
    int value;
    for (int i=0; i<digits; i++) {
        value = number/pow(10,digits-1-i);
        number -= value*pow(10,digits-1-i);
        string[i] = '0' + value;
    }
    return string;
}
*/
char* toString(int number) {
    char* string = malloc(sizeof(char)*numberOfDigits(number));
    sprintf(string,"%d",number);
    return string;
}


int main() {
    char input[256];
    char output[256];
    scanf("%s", input);
    int j = 0;
    int count;
    for (int i=0; i<strlen(input); i+=count) {
        output[j++] = input[i];
        count = 0;
        while (input[i] == input[i+count]) {
            count++;
        }
        //output[j++] = '0' + count;/* Supposing count <= 9 */
        strcpy(output+j, toString(count));
        j += numberOfDigits(count);
    }

    printf("%s\n", strlen(output) < strlen(input) ? output : input);
}
