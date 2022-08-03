#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct Node{
   int num;
   struct Node *prev;
   struct Node *next;
}Node;

typedef struct Deque{
   Node *front;
   Node *rear;
   int cnt;
}Deque;

Node* getNode(){
   Node* newNode = (Node*)malloc(sizeof(Node));
   newNode->prev = NULL;
   newNode->next = NULL;

   return newNode;
}

Deque* getDeque(){
   Deque* newDeque = (Deque*)malloc(sizeof(Deque));
   newDeque->front = NULL;
   newDeque->rear = NULL;
   newDeque->cnt=0;

   return newDeque;
}

Deque * Dq;

void initDeque(){
   Dq = getDeque();
}

int empty(){
   if(Dq->cnt==0){
      return 1;
   }
   else{
      return 0;
   }
}

void push_front(int x){
   Node *newNode = getNode();
   newNode->num = x;

   if(empty()){
      Dq->front=newNode;
      Dq->rear=newNode;
   }
   else{
      newNode->next=Dq->front;
      Dq->front->prev=newNode;
      Dq->front=newNode;
   }

   (Dq->cnt)++;

   // printf("OK\n");
   
}
void push_back(int x){
   Node *newNode = getNode();
   newNode->num = x;

   if(empty()){
      Dq->front=newNode;
      Dq->rear=newNode;
   }
   else{
      newNode->prev=Dq->rear;
      Dq->rear->next=newNode;
      Dq->rear=newNode;
   }

   (Dq->cnt)++;
   
   // printf("OK\n");
}
void pop_front(){
   Node* del = getNode();

   del = Dq->front;

   if(del->next==NULL){
      Dq->rear=NULL;
   }
   else{
      Dq->front=Dq->front->next;
   }

   Dq->front->prev=NULL;

   printf("%d\n",del->num);
   free(del);

   (Dq->cnt)--;

   // printf("OK\n");

}
void pop_back(){
   Node* del = getNode();

   del = Dq->rear;

   if(del->prev==NULL){
      Dq->front=NULL;
   }
   else{
      Dq->rear=Dq->rear->prev;
   }

   Dq->rear->next=NULL;

   printf("%d\n",del->num);
   free(del);

   (Dq->cnt)--;

   // printf("OK\n");
}
void size(){
   printf("%d\n",Dq->cnt);
}
void front(){
   printf("%d\n",Dq->front->num);
}
void back(){
   printf("%d\n",Dq->rear->num);
}
int main(){
   
   int n,x;
   char op[50];

   scanf("%d",&n);
   getchar();

   initDeque();

   for(int i=0;i<n;i++){
      scanf("%s",op);
      getchar();

      if(strcmp(op,"push_front")==0){
         scanf("%d",&x);
         push_front(x);
      }
      else if(strcmp(op,"push_back")==0){
         scanf("%d",&x);
         push_back(x);
      }
      else if(strcmp(op,"pop_front")==0){
         if(empty()){
            printf("-1\n");
         }
         else{
            pop_front();
         }
      }
      else if(strcmp(op,"pop_back")==0){
         if(empty()){
            printf("-1\n");
         }
         else{
            pop_back();
         }
      }
      else if(strcmp(op,"size")==0){
         size();
      }
      else if(strcmp(op,"empty")==0){
         printf("%d\n",empty());
      }
      else if(strcmp(op,"front")==0){
         if(empty()){
            printf("-1\n");
         }
         else{
            front();
         }
      }
      else if(strcmp(op,"back")==0){
         if(empty()){
            printf("-1\n");
         }
         else{
            back();
         }
      }
   }


   return 0;
}