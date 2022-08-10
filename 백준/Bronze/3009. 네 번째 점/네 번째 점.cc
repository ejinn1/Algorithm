#include <stdio.h>
#include <string.h>

int main(){

   int a[4],b[4];

   for(int i=0;i<3;i++){
      scanf("%d %d",&a[i],&b[i]);
   }

   if(a[0]==a[1]){
      a[3] = a[2];
   }
   else{
      if(a[1]==a[2]){
         a[3] = a[0];
      }
      else{
         a[3] = a[1];
      }
   }

   if(b[0]==b[1]){
      b[3] = b[2];
   }
   else{
      if(b[1]==b[2]){
         b[3] = b[0];
      }
      else{
         b[3] = b[1];
      }
   }


   printf("%d %d\n",a[3],b[3]);




   return 0;
}