#include <stdio.h>

int main(){

   int n, t;
   long long arr[101] = {1,1,1,};

   scanf("%d",&t);

   for(int i=0;i<t;i++){
      scanf("%d",&n);
      for(int j=3;j<=n-1;j++){
         arr[j] = arr[j-3] + arr[j-2];
      }
      printf("%lld\n",arr[n-1]);
   }

   return 0;
}