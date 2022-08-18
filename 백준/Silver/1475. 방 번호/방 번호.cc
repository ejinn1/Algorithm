#include <stdio.h>

int main(){

   int n,p,k=0;
   int check[11]={0,};

   scanf("%d",&n);

   p=n;
   while(p>0){
      check[p%10]++;
      p/=10;
   }

   k = (check[6]+check[9]+1)/2;

   for(int i=0;i<9;i++){
      if(check[i] >= k && i!=6){
         k = check[i];
      }
   }

   if(k==0){
      k++;
   }
   
   
   printf("%d\n",k);


   

   return 0;
}