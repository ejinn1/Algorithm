#include <stdio.h>

int main(){

   int n,i,j;

   scanf("%d",&n);

   for(i=0;i<n-1;i++){
      for(j=0;j<i+1;j++){
         printf("*");
      }
      for(j=0;j<(n-i-1)*2;j++){
         printf(" ");
      }
      for(j=0;j<i+1;j++){
         printf("*");
      }
      printf("\n");
   }

   for(i=0;i<n*2;i++){
         printf("*");
   }
   printf("\n");

   for(i=0;i<n-1;i++){
      for(j=n;j>(i+1);j--){
         printf("*");
      }
      for(j=0;j<(i+1)*2;j++){
         printf(" ");
      }
      for(j=n;j>(i+1);j--){
         printf("*");
      }
      printf("\n");
   }


   return 0;
}