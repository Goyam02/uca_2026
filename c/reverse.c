#include <stdio.h>
#include <string.h>

void reverse_string(char *str) {
    if (str == NULL || *str == '\0') {
        return;
    }

    int len = strlen(str);
    int start = 0;
    int end = len - 1;


    while (start < end) {
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;
        start++;
        end--;
    }

}

int main() {
    char mystr[100];
    printf("Enter a string: ");
    if (fgets(mystr, sizeof(mystr), stdin) != NULL) {
        reverse_string(mystr);
        printf("Reversed string: %s\n", mystr);
    }

    return 0;

    return 0;
}