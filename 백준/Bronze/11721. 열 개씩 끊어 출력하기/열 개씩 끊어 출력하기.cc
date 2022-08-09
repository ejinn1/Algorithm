#include <stdio.h>
#include <string.h>

int main(){

   char arr[101];
   int size,i,j=0;

   scanf("%s",arr);

   size = strlen(arr)/10;

   for(i=1;i<=size;i++){
      for(;j<10*i;j++){
         printf("%c",arr[j]);
      }
      printf("\n");
   }

   if(strlen(arr)-j>0){
      for(;j<strlen(arr);j++){
         printf("%c",arr[j]);
      }
   }






   return 0;
}