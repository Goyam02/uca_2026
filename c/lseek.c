#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<sys/stat.h>
#include<string.h>


int main(int argc, char *argv[]){
    size_t len;
    off_t offset;
    int fd;  
    char *buf;  //if its a very big we do not want to read at onec ww would read in size of buffer
    size_t numRead, numWritten;


    if(argc < 3){
        printf("Usage %s <file> {r<length>|w<string> | s<offset>...}\n",argv[0]);
        exit(-1);
    }

    fd = open(argv[1], O_RDWR | O_CREAT , S_IWUSR | S_IRUSR | 
                                        S_IRGRP | S_IWGRP | 
                                        S_IROTH);

                                        
    if(fd==-1){
        printf("Failed to open file \n");
        exit(-1);
    }

    for(int i = 2;i<argc;i++){
        switch(argv[i][0]){
            case 'w':
                // printf("trying ");
                numWritten = write(fd,&argv[i][1],strlen(&argv[i][1]));
                printf("number of bytes written : %ld\n",numWritten);
                break;
            case 'r':
                len = atoi(&argv[i][1]);
                buf = malloc(len);
                numRead = read(fd,buf,len);
                if(numRead==0){
                    free(buf);
                    printf("we have reached the end of file\n");
                    exit(-1);
                }
                for(int j=0;j<len;j++){
                    printf("%c",((unsigned char)buf[j]));
                }
                free(buf);

                break;
            case 's':
                offset = atoi(&argv[i][1]);
                if(lseek(fd,offset,SEEK_CUR)==-1){
                    printf("seek failed\n");
                    exit(-1);
                }
                printf("seek succeded");
                
                break;
            default:
                printf("argument must be one of the [wsr]\n");
                exit(-1);
                break;
             
        }
    }




    exit(EXIT_SUCCESS);


}
