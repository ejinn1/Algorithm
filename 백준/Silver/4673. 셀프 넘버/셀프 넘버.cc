#include <stdio.h>

int d(int n){

   int sum=n;
   while(n>0){
      sum+=n%10;
      n/=10;
   }

   return sum;
}
int main(){

   int arr[100002] = {0,};
   int result;
   
   for(int i=1;i<=10000;i++){
      result = d(i);
      arr[result]=1;
   }

   for(int i=1;i<=10000;i++){
      if(arr[i]==0){
         printf("%d\n",i);
      }
   }




   return 0;
}