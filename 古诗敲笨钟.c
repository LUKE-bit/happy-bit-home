#include<stdio.h>
int main()
{
	char gushi[100];
	int n;
	char ch;
	scanf("%d",&n);
	ch = getchar();
	int t = n;
	int i,j,q;
	while(t--){	
		int cot=0; 
		ch = getchar();
		for(i=0;ch!='\n';i++) {
			gushi[i] = ch;
			ch = getchar();
		}
		for(i=0;;i++){
			if(gushi[i]==',')break;
		}
		if(gushi[i-3]=='o'&&gushi[i-2]=='n'&&gushi[i-1]=='g') {
			for(j=i+1;;j++) {
				if(gushi[j]=='.') {
					gushi[j+1] = '\0';
					break;
				}
			}
			if(gushi[j-3]=='o'&&gushi[j-2]=='n'&&gushi[j-1]=='g') {
				int len = strlen(gushi);
				for(i=len-1;;i--){
					if(gushi[i]==' '){
						cot++;
					}
					if(cot==3){
						for(q=0;q<=i;q++) {
							printf("%c",gushi[q]);
						}
						printf("qiao ben zhong.\n");
						break;
					}
				}
			}else{
				printf("Skipped\n");
				continue;
			}
		}
		else {
			printf("Skipped\n");
			continue;	
		}				
	}
}
