#include <stdio.h>

int main(){
   
   int n,k,p,i,j;
   int check[5001]={0,};

   scanf("%d %d",&n,&k);

   p=k;
   printf("<%d",p);
   check[k]=1;

   for(i=0;i<n-1;i++){
      for(j=0;j<k;j++){
         while(1){
            p++;
            if(p>n) p=1;
            if(check[p]==0) break;
         }
      }
      printf(", %d",p);
      check[p]=1;
   }
   printf(">");


   return 0;
}