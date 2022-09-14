#include <stdio.h>

int main(){

    int n=1,b,f=0;

    while(1){
        scanf("%d",&n);
        if(n==0){
            break;
        }
        f=0;
        b=n;
        while(b>0){
            f*=10;
            f+=b%10;
            b/=10;
        }
        if(f-n){
            printf("no\n");
        }
        else{
            printf("yes\n");
        }
    }




    return 0;
}