#include<stdio.h>
int main()
{
 char a1[100],a2[100];
 int l;
  gets(a1);
  for(l=0;a1[l]!=NULL;l++)
  {
    a2[l]=a1[l];
  }
  puts(a2);
 return 0;

}
