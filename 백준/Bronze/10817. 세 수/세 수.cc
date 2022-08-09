#include <stdio.h>

int main(){

   int a;
   int max=0,max2=0;

   for(int i=0;i<3;i++){
      scanf("%d",&a);
      if(a>max){
         max2 = max;
         max = a;
      }
      else if(a>max2){
         max2 = a;
      }
      
   }

   printf("%d\n",max2);
   



   return 0;
}