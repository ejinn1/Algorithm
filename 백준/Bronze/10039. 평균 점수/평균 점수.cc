#include <stdio.h>

int main(){
   
   int test[5];
   int avg=0;

   for(int i=0;i<5;i++){
      scanf("%d",&test[i]);
      if(test[i]<=40) test[i]=40;
      avg+=test[i];
   }

   printf("%d\n",avg/5);


   
   return 0;
}