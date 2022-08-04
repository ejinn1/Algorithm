#include <stdio.h>

int main(){
   
   int x,y;
   int cnt=0;

   scanf("%d %d",&x,&y);

   for(int i=1;i<x;i++){
      if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12){
         cnt+=31;
      }
      else if(i==2){
         cnt+=28;
      }
      else{
         cnt+=30;
      }
   }
   cnt+=y;
   cnt%=7;

   if(cnt==0){
      printf("SUN\n");
   }
   else if(cnt==1){
      printf("MON\n");
   }
   else if(cnt==2){
      printf("TUE\n");
   }
   else if(cnt==3){
      printf("WED\n");
   }
   else if(cnt==4){
      printf("THU\n");
   }
   else if(cnt==5){
      printf("FRI\n");
   }
   else if(cnt==6){
      printf("SAT\n");
   }


   
   return 0;
}