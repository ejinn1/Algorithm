#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){
   
   int t;
   int x1,x2,y1,y2,r1,r2;
   double d=0;

   scanf("%d",&t);

   for(int i=0;i<t;i++){
      scanf("%d %d %d",&x1,&y1,&r1);
      scanf("%d %d %d",&x2,&y2,&r2);

      d = sqrt(pow((x2-x1), 2) + pow((y2-y1), 2));

      if(r1+r2 < d){
         printf("0\n");
      }
      else if(abs(r1-r2) > d){
         printf("0\n");
      }
      else if(d==0 && r1==r2){
         printf("-1\n");
      }
      else if(r1+r2==d){
         printf("1\n");
      }
      else if(abs(r1-r2) == d){
         printf("1\n");
      }
      else{
         printf("2\n");
      }

   }
   
   return 0;
}