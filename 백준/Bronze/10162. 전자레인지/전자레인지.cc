#include <stdio.h>

int main(){

   int T,f=0;
   int a=0, b=0, c=0;

   scanf("%d",&T);

   while(T>0){
      if(T>=300){
         a += T/300;
         T%=300;
      }
      else if(T>=60){
         b += T/60;
         T%=60;
      }
      else if(T>=10){
         c += T/10;
         T%=10;
      }
      else{
         f=-1;
         break;
      }
   }

   if(f==0){
      printf("%d %d %d\n",a,b,c);
   }
   else{
      printf("%d\n",f);
   }




   return 0;
}