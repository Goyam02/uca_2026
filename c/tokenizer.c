#include<stdio.h>
#include<string.h>


int main(){
    char mystr[100];
    printf("Enter a string: ");
    scanf("%s", mystr);

    char *token = strtok(mystr, ",");
    while(token != NULL){
        printf("%s\n", token);
        token = strtok(NULL, ",");
    }
    return 0;


}