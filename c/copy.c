#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<unistd.h>

#define BUF_SIZE 1024

int main(int argc, char *argv[]){
	int inputFd, outputFd, openFlags;
	mode_t filePerms;
	ssize_t	numRead;
	char buf[BUF_SIZE];
	if(argc!=3){
		printf("Usage ./a.out file1 file2");
		exit(-1);	
	}
	if (strcmp(argv[1], "--add") == 0) {
        if (argc != 3) {
            printf("Error: Missing message to add.\n");
            exit(-1);
        }
		openFlags = O_CREAT | O_WRONLY | O_APPEND;
		filePerms = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH; // rw-r--r-- 644
		outputFd = open(argv[2], openFlags, filePerms);
		if (outputFd == -1) {
			printf("Error opening output file %s\n", argv[2]);
			exit(-1);
		}
		// Write the message to the log file
		if (write(outputFd, argv[2], strlen(argv[2])) != strlen(argv[2])) {
			printf("Error writing to output file %s\n", argv[2]);
			close(outputFd);
			exit(-1);
		}
		close(outputFd);
	} else {
		inputFd = open(argv[1], O_RDONLY);
		if(inputFd == -1) {
			printf("Error opening input file %s\n", argv[1]);
			exit(-1);
		}

		openFlags = O_CREAT | O_WRONLY | O_TRUNC;
		filePerms = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH; // rw-r--r-- 644
		outputFd = open(argv[2], openFlags, filePerms);
		if (outputFd == -1) {
			printf("Error opening output file %s\n", argv[2]);
			close(inputFd);
			exit(-1);
		}

		while ((numRead = read(inputFd, buf, BUF_SIZE)) > 0) {
			if(write(outputFd, buf, numRead) != numRead){
				printf("Error writing to output file %s\n", argv[2]);
				close(inputFd);
				close(outputFd);
				exit(-1);
			}
		}

		close(inputFd);
		close(outputFd);
	}

	//printf("%d\n",argc);
	return 0;
}
