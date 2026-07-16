#include <stdio.h>
#include <string.h>


void url_encode(char *str, int true_length) {
    int space_count = 0;
    
    // Count the number of spaces to determine new length
    for (int i = 0; i < true_length; i++) {
        if (str[i] == ' ') {
            space_count++;
        }
    }


    int new_length = true_length + (space_count * 2);
    int index = new_length;

    // Fill the string from the back
    for (int i = true_length - 1; i >= 0; i--) {
        if (str[i] == ' ') {
            str[index - 1] = '0';
            str[index - 2] = '2';
            str[index - 3] = '%';
            index -= 3;
        } else {
            str[index - 1] = str[i];
            index--;
        }
    }
}

int main() {
    char mystr[100];
    printf("Enter a string: ");
    if (fgets(mystr, sizeof(mystr), stdin) != NULL) {
        // Remove newline character if present
        mystr[strcspn(mystr, "\n")] = '\0';
        int true_length = strlen(mystr);
        url_encode(mystr, true_length);
        printf("URL Encoded string: %s\n", mystr);
    }

    return 0;
}