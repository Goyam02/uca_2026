#include<stdio.h>
#include<string.h>

int find_substring(const char *haystack, const char *needle) {
    if (*needle == '\0') return 0;

    for (int i = 0; haystack[i] != '\0'; i++) {
        int j = 0;
        while (needle[j] != '\0' && haystack[i + j] == needle[j]) {
            j++;
        }
        if (needle[j] == '\0') {
            return i;
        }
    }

    return -1;
}

int main() {
    char haystack[100], needle[100];
    printf("Enter the main string: ");
    if (fgets(haystack, sizeof(haystack), stdin) != NULL) {
        printf("Enter the substring to search for: ");
        if (fgets(needle, sizeof(needle), stdin) != NULL) {
            // Remove newline characters from the input strings
            haystack[strcspn(haystack, "\n")] = '\0';
            needle[strcspn(needle, "\n")] = '\0';

            int index = find_substring(haystack, needle);
            if (index != -1) {
                printf("Substring found at index: %d\n", index);
            } else {
                printf("Substring not found.\n");
            }
        }
    }

    return 0;
}