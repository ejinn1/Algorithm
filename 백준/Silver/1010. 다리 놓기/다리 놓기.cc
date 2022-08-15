#include <stdio.h>

int main(){

   int n,m,t,r;

   scanf("%d",&t);
   for(int i=0;i<t;i++){
      r=1;
      scanf("%d %d",&n,&m);
      for(int j=0;j<n;j++){
         r*=m-j;
         r/=j+1;
      }
      printf("%d\n",r);
   }

   return 0;
}