#include <stdio.h>

int main(){

   int a,b,f=0;

   scanf("%d",&a);

   if(a==1){
      f=1;
      for(int i=2;i<=8;i++){
         scanf("%d",&b);
         if(i!=b){
            f=0;
            break;
         }
      }
   }
   else if(a==8){
      f=2;
      for(int i=7;i>=1;i--){
         scanf("%d",&b);
         if(i!=b){
            f=0;
            break;
         }
      }
   }

   if(f==1){
      printf("ascending\n");
   }
   else if(f==2){
      printf("descending\n");
   }
   else{
      printf("mixed\n");
   }


   return 0;
}