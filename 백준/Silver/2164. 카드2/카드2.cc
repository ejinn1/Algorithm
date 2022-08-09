#include <stdio.h>

int main(){

   int n,m,p=0,i,k=1;

   scanf("%d",&n);
   if(n==1){
      p=1;
   }
   else if(n==2){
      p=2;
   }
   else{
      m=n-1;
      while(m>1){
         m/=2;
         p++;
      }
      for(i=0;i<p;i++){
         k*=2;
      }
      k++;
      k=n-k;
      p=2;
      for(i=0;i<k;i++){
         p+=2;
      }
   }

   printf("%d\n",p);



   return 0;
}