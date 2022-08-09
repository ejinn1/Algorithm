#include <stdio.h>

int main(){

   int arr[100001]={0,};
   int i,k,n,j=0,sum=0;

   scanf("%d",&k);

   for(i=0;i<k;i++){
      scanf("%d",&n);
      if(n==0){
         arr[j] = 0;
         j--;
      }
      else{
         arr[j] = n;
         j++;
      }
   }

   for(i=0;i<j;i++){
      sum+=arr[i];
   }

   printf("%d\n",sum);
   


   return 0;
}