#include<stdio.h>
int main()
{
	int arr[200][200];
	int t,n,i,j;
	scanf("%d",&t);
	while(t--)
	{
		scanf("%d",&n);
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=i;j++)
			{
				scanf("%d",&arr[i][j]);
			}
		}
		for(i=n-1;i>=1;i--)
		{
			for(j=1;j<=i;j++)
			{
				if(arr[i+1][j]>=arr[i+1][j+1])
				arr[i][j]+=arr[i+1][j];
				else
				arr[i][j]+=arr[i+1][j+1];
			}
		}
		printf("%d\n",arr[1][1]);
	}
}
