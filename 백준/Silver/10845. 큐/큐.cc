#include <stdio.h>
#include <string.h>

int queue[10001];
int f=0,b=0,cnt=0;;

void push(int x){
   queue[b] = x;
   b++;
   cnt++;
}
void pop(){
   if(cnt==0){
      printf("-1\n");
   }
   else{
      printf("%d\n",queue[f]);
      f++;
      cnt--;
   }

}
void size(){
   printf("%d\n",cnt);
}
void empty(){
   if(cnt==0){
      printf("1\n");
   }
   else{
      printf("0\n");
   }
}
void front(){
   if(cnt==0){
      printf("-1\n");
   }
   else{
      printf("%d\n",queue[f]);
   }
}
void back(){
   if(cnt==0){
      printf("-1\n");
   }
   else{
      printf("%d\n",queue[b-1]);
   }
}
int main(){  
   
   int n, x;
   char op[10];

   scanf("%d",&n);

   for(int i=0;i<n;i++){
      scanf("%s",op);
      getchar();

      if(strcmp(op,"push")==0){
         scanf("%d",&x);
         push(x);
      }
      else if(strcmp(op,"pop")==0){
         pop();
      }
      else if(strcmp(op,"size")==0){
         size();
      }
      else if(strcmp(op,"empty")==0){
         empty();
      }
      else if(strcmp(op,"front")==0){
         front();
      }
      else if(strcmp(op,"back")==0){
         back();
      }
   }

   



   return 0;
}