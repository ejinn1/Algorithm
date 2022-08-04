#include <stdio.h>

int main(){
   
   int a,b,c,d,i;

   scanf("%d %d",&a, &b);


   i=1;
   while(1){
      if(a%i==0 && b%i==0){
         c = i;
      }
      if(i>=a || i>=b){
         break;
      }
      i++;
   }

   i = a > b ? a : b;
   while(1){
      if(i%a==0 && i%b==0){
         d = i;
         break;
      }
      i++;
   }

   printf("%d\n",c);
   printf("%d\n",d);


   
   return 0;
}