#include <stdio.h>

int main(){

   int a[10],b[10];
   int i,min=9999,sum=0;

   for(i=0;i<3;i++){
      scanf("%d",&a[i]);
      if(a[i]<min){
         min = a[i];
      }
   }
   sum+=min;

   for(i=0;i<2;i++){
      scanf("%d",&b[i]);
      if(b[i]<min){
         min = b[i];
      }
   }
   sum+=min;

   printf("%d\n",sum-50);



   return 0;
}