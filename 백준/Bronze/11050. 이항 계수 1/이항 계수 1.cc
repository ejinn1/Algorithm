#include <stdio.h>

int nCk(int n, int k){
   int result;
   int a=1,b=1;

   for(int i=n;i>n-k;i--){
      a*=i;
   }
   for(int i=1;i<=k;i++){
      b*=i;
   }

   result = a/b;

   return result;
}
int main(){

   int n,k;

   scanf("%d %d",&n,&k);

   printf("%d\n",nCk(n,k));




   return 0;
}