#include <stdio.h>

int main(){  
   
   int stack[100001];
   int top=-1,f=0;
   char result[200001];
   int n;
   int target[100001];

   scanf("%d",&n);

   for(int i=0;i<n;i++){
      scanf("%d",&target[i]);
   }
   
   int num=1;
   int i=0,k=0;
   while(1){
      if(top==-1 || stack[top]<target[i]){
         top++;
         stack[top] = num;
         num++;
         result[k] = '+';
         k++;
      }
      else if(stack[top] == target[i]){
         top--;
         result[k] = '-';
         k++;
         i++;
      }
      else{
         printf("NO\n");
         f=1;
         break;
      }

      if(k == n*2){
         break;
      }

   }
   if(f==0){
      for(int i=0;i<k;i++){
         printf("%c\n",result[i]);
      }
   }
   

   return 0;
}