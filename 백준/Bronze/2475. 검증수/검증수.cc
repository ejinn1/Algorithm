#include <stdio.h>

int main(){
   
   int a, sum=0;

   for(int i=0;i<5;i++){
      scanf("%d",&a);
      a = a*a;
      sum+=a;
   }

   printf("%d\n",sum%10);
   
   return 0;
}