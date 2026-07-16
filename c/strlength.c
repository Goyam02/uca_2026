#include<stdio.h>
#include<string.h>

int my_strlen(const char *str){
    int length = 0;
    while (str[length] != '\0') {
        length++;
    }
    return length;
} 


int main() {
    char mystr[100];
    printf("Enter a string: ");
    if (fgets(mystr, sizeof(mystr), stdin) != NULL) {
        int length = my_strlen(mystr);
        printf("Length of the string: %d\n", length); 
    }


    return 0;
}