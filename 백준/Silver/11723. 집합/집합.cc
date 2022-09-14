#include <stdio.h>
#include <string.h>

int main(){

    int m,x;
    char op[11];
    int set[21]={0,};

    scanf("%d",&m);

    for (int i = 0; i < m; ++i) {
        getchar();
        scanf("%s",op);
        if(strcmp(op, "add")==0){
            scanf("%d",&x);
            if(set[x] == 0) set[x] = 1;
        }
        else if(strcmp(op,"remove")==0){
            scanf("%d",&x);
            if(set[x] == 1) set[x] = 0;
        }
        else if(strcmp(op,"check")==0){
            scanf("%d",&x);
            printf("%d\n",set[x]);
        }
        else if(strcmp(op,"toggle")==0){
            scanf("%d",&x);
            if(set[x] == 0)
                set[x] = 1;
            else
                set[x] = 0;
        }
        else if(strcmp(op,"all")==0){
            for (int j = 1; j <= 20; ++j) {
                set[j] = 1;
            }
        }
        else if(strcmp(op,"empty")==0){
            for (int j = 1; j <= 20; ++j) {
                set[j] = 0;
            }
        }
    }


    return 0;
}