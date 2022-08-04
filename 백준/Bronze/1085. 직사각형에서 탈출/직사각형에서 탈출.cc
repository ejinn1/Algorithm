#include <stdio.h>

int main(){
   
   int x,y,w,h;
   int a,b;

   scanf("%d %d %d %d",&x, &y, &w, &h);

   a = (w-x) < x ? (w-x) : x;
   b = (h-y) < y ? (h-y) : y;

   if(a > b){
      printf("%d\n",b);
   }
   else{
      printf("%d\n",a);
   }



   
   return 0;
}