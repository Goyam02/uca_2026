#include<stdio.h>

/* This is a
   multi-line comment
   and should disappear */

int main(){

    // This is a single-line comment
    int a = 10;
    int b = 20; // comment after code

    printf("Hello World\n");

    // These should NOT be treated as comments
    printf("This // is not a comment\n");
    printf("This /* is also not a comment */\n");

    char slash = '/';
    char star = '*';

    /* Another comment */
    int sum = a + b;

    printf("Sum = %d\n",sum); /* remove this comment */

    // Testing escaped quotes
    printf("He said \"Hello // World\" to me\n");

    return 0; // end of program
}
