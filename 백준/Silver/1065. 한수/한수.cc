#include <stdio.h>

int main(){

   int n,i,cnt=0,p,j=0,k,c,f=0;
   int a[10];

   scanf("%d",&n);

   for(i=1;i<=n;i++){
      p=i;
      j=0;
      f=0;
      while(p>0){
         a[j] = p%10;
         j++;
         p/=10;
      }
      // for(k=0;k<j;k++){
      //    printf(" %d",a[k]);
      // }
      // printf("\n");
      if(j==1){
         cnt++;
      }
      else{
         c = a[1] - a[0];
         for(k=2;k<j;k++){
            if(c != a[k] - a[k-1]){
               f=1;
               break;
            }
         }
         if(f==0){
            cnt++;
         }
      }
   }

   printf("%d\n",cnt);


   return 0;
}