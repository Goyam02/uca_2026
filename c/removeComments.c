#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<sys/stat.h>


int main(int argc, char *argv[]){

    int fd;
    char ch, next;
    int inString = 0;
    int inChar = 0;
    int escaped = 0;


    if(argc != 2){
        printf("Usage %s <file.c>\n",argv[0]);
        exit(-1);
    }


    fd = open(argv[1],O_RDONLY);

    if(fd == -1){
        printf("Failed to open file\n");
        exit(-1);
    }


    while(read(fd,&ch,1) > 0){


        // if we are inside a string
        if(inString){

            write(STDOUT_FILENO,&ch,1);

            if(escaped){
                escaped = 0;
            }
            else if(ch == '\\'){
                escaped = 1;
            }
            else if(ch == '"'){
                inString = 0;
            }

            continue;
        }


        // if we are inside a character constant
        if(inChar){

            write(STDOUT_FILENO,&ch,1);

            if(escaped){
                escaped = 0;
            }
            else if(ch == '\\'){
                escaped = 1;
            }
            else if(ch == '\''){
                inChar = 0;
            }

            continue;
        }


        // starting of string
        if(ch == '"'){
            inString = 1;
            write(STDOUT_FILENO,&ch,1);
        }


        // starting of character constant
        else if(ch == '\''){
            inChar = 1;
            write(STDOUT_FILENO,&ch,1);
        }


        // possible comment
        else if(ch == '/'){

            if(read(fd,&next,1) == 0){
                write(STDOUT_FILENO,&ch,1);
                break;
            }


            // single line comment
            if(next == '/'){

                while(read(fd,&ch,1) > 0){

                    if(ch == '\n'){
                        write(STDOUT_FILENO,&ch,1);
                        break;
                    }
                }
            }


            // multi line comment
            else if(next == '*'){

                while(read(fd,&ch,1) > 0){

                    if(ch == '*'){

                        if(read(fd,&next,1) == 0){
                            break;
                        }

                        if(next == '/'){
                            break;
                        }

                        // next was not / so go back one character
                        lseek(fd,-1,SEEK_CUR);
                    }

                    // keeping new lines
                    else if(ch == '\n'){
                        write(STDOUT_FILENO,&ch,1);
                    }
                }
            }


            // it was just a normal /
            else{
                write(STDOUT_FILENO,&ch,1);
                write(STDOUT_FILENO,&next,1);
            }
        }


        // normal character
        else{
            write(STDOUT_FILENO,&ch,1);
        }

    }


    close(fd);

    exit(EXIT_SUCCESS);
}
