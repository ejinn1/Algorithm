#include <stdio.h>
#include <string.h>

int main(){

   char a[51];
   int len,i=0,j=0,sum=0,r;
   int t=0,b[51];

   scanf("%s",a);
   len = strlen(a);

   for(i=0;i<=len;i++){
      if(a[i]=='-' || i==len){
         sum+=t;
         b[j]=sum;
         j++;
         t=0;
         sum=0;
      }
      else if(a[i]=='+'){
         sum+=t;
         t=0;
      }
      else{
         t*=10;
         t+=(int)(a[i]-'0');
      }
   }

   r=b[0];
   for(i=1;i<j;i++){
      r-=b[i];
   }
   printf("%d\n",r);




   return 0;
}