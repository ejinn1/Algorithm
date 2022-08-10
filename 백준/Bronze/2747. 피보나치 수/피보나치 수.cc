#include <stdio.h>

int main(){

   int n;
   int f[50]={0,1,};

   scanf("%d",&n);

   for(int i=2;i<=n;i++){
      f[i] = f[i-1] + f[i-2];
   }

   printf("%d\n",f[n]);



   return 0;
}