#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<windows.h>
#include<conio.h>
struct xs
{
	char name[20];
	int number;
	int sum;//�ܵ÷� 
	struct xs *next;
 };
struct xs *head=(struct xs *)malloc(sizeof (struct xs));
 
//�û��ṹ��
struct user
{
	char username[20];
	char usermima[20];
};
//��ʼ��
void addxs(struct xs *p)
{
	printf("������ѧ�����ƣ�");
	fflush(stdin);
	gets(p->name);
	printf("������ѧ������: ");
	scanf("%d",&p->number);
	printf("������ѧ���ܵ÷֣� ");
	scanf("%d",&p->sum); 
}

//����ϵͳ
void face();
void face2();
void search();
void cutout();
//����ϵͳ
void mixlooking(struct xs *p);
void lookingname(struct xs *p);
void lookingnumber(struct xs *p);
void readfile();
void wirtefile();
void sort();
void shanchu1(struct xs *p0);
void change(struct xs *p);
void create();
void addxs(struct xs *p);
void denglu();
void zhuce();
void  print(struct xs *head);
void sumpaixu(struct xs* head);
void sort(); 
int tongji(struct xs *head);
void charu(struct xs* p0);
 
//�������� 
void create()
{
	int i=0;
	char ch;
	struct xs *pnew;
	do
	{
		system("cls");
		pnew=(struct xs*)malloc(sizeof(struct xs));
		printf("\n\n\t\t\t\t\t��%dѧ������Ϣ\n",++i);
		addxs(pnew);
	    pnew->next=head->next;
	    head->next=pnew;
		printf("\n\n\t\t\t\t\t�Ƿ�������ѧ����Ϣ?(Y/N)");
		getchar(); 
		ch=getchar(); //����Y��y�ж��Ƿ������Ϣ 
	}while(ch=='Y');
}
//ͳ��ѧ������
int tongji(struct xs *head)
{
	struct xs *p = head->next;
	int count=0;    //ѧ������ 
	while(p!= NULL)
	{
		count++;
		p=p->next;
	}
	return count;
}
 
 //�׽��� 
void face()                                           
{
    printf("\n\n\n\n\n\n");
    printf("                                  ********************************************\n");
    printf("                                  --------------------------------------------\n");
    printf("\n");
    printf("                                  |         ��ӭʹ��ѧ������ϵͳ          |\n");
    printf("\n");
    printf("                                  --------------------------------------------\n"); 
    printf("                                  |           1-��¼                         |\n");
    printf("                                  |           2-ע��                         |\n");
	printf("                                  |           3-�˳�ϵͳ                     |\n");
    printf("                                  ********************************************\n");
    printf("\n                                ���ȵ�¼��ע��"); 
    printf("\n\n\n");
    printf("�����룺 ") ;
    fflush(stdin);
    int choice;
    scanf("%d",&choice);
    switch (choice)
    {
    	case 1:
    		system("cls");
    		denglu();                      //��¼����
			system("cls");
			face2() ;                      ///////////////////////////
			break;
		case 2:
			system("cls");
			zhuce();
			system("cls");
			face();
			break;
		case 3:
			break;
	}
    
 } 
void face2()                                           //��ӡ���� 2
{
	int n;
    printf("\n\n\n");
    printf("                                  ********************************************\n");
    printf("                                  --------------------------------------------\n");
    printf("\n");
    printf("                                  |         ��ӭʹ��ѧ������ϵͳ          |\n");
    printf("\n");
    printf("                                  --------------------------------------------\n"); 
    printf("                                  |           1-��Ϣ¼��                     |\n");
    printf("                                  |           2-��ѯѧ����Ϣ                 |\n");
    printf("                                  |          *3-�޸�ĳ��ѧ����Ϣ             |\n");
    printf("                                  |          *4-ɾ��ĳ��ѧ����Ϣ             |\n");
    printf("                                  |          *5-������ѧ����Ϣ               |\n");
    printf("                                  |           6-��ʾ������Ϣ                 |\n"); 
    printf("                                  |           7-�˳�ϵͳ��������Ϣ           |\n"); 
    printf("                                  ********************************************\n");
    printf("\n\n\n");
    printf("���������ѡ��\t");
    scanf("%d",&n);
    switch(n)
    {
    	case 1:
    		system("cls");
    		create();       //////////////////////// 
    		fflush(stdin);
    		printf("����������ؽ���");
			getch();
			system("cls");
			face2();
			break;
		case 2:
			system("cls");
			search();
			fflush(stdin);
			printf("����������ؽ���");
			getch();
			system("cls");
			face2();
			break; 
		case 3:
			system("cls");
			change(head);
			fflush(stdin);
			printf("����������ؽ���");
			getch();
			system("cls");
			face2();
			break; 
		case 4:
			system("cls");
			cutout();
			fflush(stdin);
			printf("����������ؽ���");
			getch();
			system("cls");
			face2();
			break;
		case 5:
			system("cls");
			charu(head);
			fflush(stdin);
			printf("����������ؽ���");
			getch();
			system("cls");
			face2();
			break;  
		case 6:
			system("cls");
			print(head);
			fflush(stdin);
			printf("����������ؽ���");
			getch();
			system("cls");
			face2();
			break;
		case 7:
			system("cls");
			break;
		default:
			break; 
	}
 } 
//��ѯ����ҳ��
void search() 
{
	int choice;
	printf("\n\t\t\t\t\t                ѧ����Ϣ��ѯ           \n");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|                                       |");
    printf("\n\t\t\t\t\t|         1.����ѧ�����ƽ��в�ѯ        |");
    printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|                                       |");
    printf("\n\t\t\t\t\t|         2.����ѧ����Ž��в�ѯ        |");
	printf("\n\t\t\t\t\t|                                       |"); 
    printf("\n\t\t\t\t\t|                                       |"); 
	printf("\n\t\t\t\t\t|         3.��ϲ�ѯ                    |"); 
	printf("\n\t\t\t\t\t|                                       |"); 
	printf("\n\t\t\t\t\t|                                       |");
    printf("\n\t\t\t\t\t|         4.�˳�                        |");
	printf("\n\t\t\t\t\t|                                       |"); 
	printf("\n\t\t\t\t\t|_______________________________________|"); 
	printf("\n\t\t\t\t\t������:");
	scanf("%d",&choice);
	switch(choice)
	{
		case 1:
			system("cls");
			lookingname(head);
			fflush(stdin);
			getch();
			system("cls");
			search();
			break;
		case 2:
			system("cls");
			lookingnumber(head);
			fflush(stdin);
			getch();
			system("cls");
			search();
			break;
		case 3:
			system("cls");
			mixlooking(head);
			fflush(stdin);
			getch();
			system("cls");
			search();
			break;
		default:
			break;
			
	}
 } 
//ɾ������ 
void cutout()
{
	int choice;
	printf("\n\n\t\t\t\t\t            ѧ����Ϣɾ��              |\n"); 
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|         1.����ѧ������ɾ��            |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|         2.������һ��                  |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|_______________________________________|");
	printf("\n\t\t\t\t\t��ѡ��:");
	scanf("%d",&choice);
	switch(choice)
	{
		case 1:
			system("cls");
			shanchu1(head);
			fflush(stdin);
			printf("\n\n\t\t\t\t\t����������ع��ܽ���\n");
			getch(); 
			system("cls");
			cutout(); 
			break;
		case 2:
			system("cls");
			face2();
			break;
		default:
			break;
			
	}
}
//����ҳ��
void sort()
{
	int choice;
	printf("\n\n\t\t\t\t\t                ѧ����Ϣ����              \n");
	printf("\n\t\t\t\t\t|          1.����ѧ���ܵ÷�����         |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|          2.������һ��                 |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|_______________________________________|");
	printf("\n\t\t\t\t\t������:");
	scanf("%d",&choice);
	switch(choice)
	{
		case 1:
			system("cls");
			
			fflush(stdin);
			printf("\n\n\t\t\t\t\t������������������\n");
			getch(); 
			system("cls");
			sort();
			break;
		case 2:
			system("cls");
			face2();
			break;
		default:
			break; 
			
	 } 
 } 
//����Ա�ܵ÷�����
void sumpaixu(struct xs* head)
{
	int choice,count=0,i,j;
	struct xs *p1=head,*p2,*temp,*t;
	printf("\n\t\t\t\t\t            ����ѧ���ܵ÷�����        \n ");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|           1.����                      |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|           2.����                      |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|           3.������һ��                |"); 
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|           4.�˳�                      |");
	printf("\n\t\t\t\t\t|_______________________________________|");
	printf("\n\t\t\t\t\t��ѡ��:");
	scanf("%d",&choice);
	while(p1=p1->next)
		count++;
	switch(choice)
	{
		case 1:
			{
				for(i=1;i<count;i++)
				{
					p1=head->next;
					p2=p1->next;
					temp=head;
					for(j=0;j<count-1;j++)
					{
						if(p1->sum  > p2->sum) 
						{
							p1->next=p2->next;
							p2->next=p1;
							temp->next=p2;
							t=p2;
							p2=p1;
							p1=t;
							
						}
						p1=p1->next;
						p2=p2->next;
						temp=temp->next;
					}
				}
				printf("\n\n\t\t\t\t\t��������Ϊ:");
				print(head);
			}
			break;
		case 2:
			{
				for(i=1;i<count;i++)
				{
					p1=head->next;
					p2=p1->next;
					temp=head;
					for(j=0;j<count-1;j++)
					{
						if(p1->sum <p2->sum)
						{
							p1->next=p2->next;
							p2->next=p1;
							temp->next=p2;
							t=p2;
							p2=p1;
							p1=t;
							
						}
						p1=p1->next;
						p2=p2->next;
						temp=temp->next;
					}	
				}
				printf("\n\n\t\t\t\t\t��������Ϊ:");
				print(head);		
			}
			break;
		case 3:
			system("cls");
			fflush(stdin);
			printf("\n\n\t\t\t\t\t�������������һ��\n");
			getch(); 
			system("cls");	
			sort();
				break;
		default:
			break;
	}
}
	


//����ѧ�����Ƽ������ϲ���
void mixlooking(struct xs *p)
{
	char membername[20];
	int haoma;
	int flag=0;
	struct xs *p1=p->next;
	printf("\n\n\t\t\t\t\t������ѧ������");
	fflush(stdin);
	gets(membername);
	printf("\n\n\t\t\t\t\t������ѧ������");
	fflush(stdin);
	scanf("%d",&haoma);
	while(p1->next!=NULL)
	{
		if(strcmp(p1->name,membername)==0 && p1->number==haoma)
		{
			printf("             \n�ҵ���!");
			flag=1;
			printf("\n\n\t\t\t\t\t%d\n",p1->number);
			printf("\n\n\t\t\t\t\t%s\n",p1->name);
			printf("\n\n\t\t\t\t\t%d\n",p1->sum);
			
		}
		p1=p1->next;
	}
	if(flag==0)
	{
		printf("û�ҵ���");
		
	}
 } 
//����xs���Ʋ���
void lookingname(struct xs *p)
{
	struct xs *p1=p->next;
	char membername[20];
	int flag=0;
	printf("\n\n\t\t\t\t\t������Ҫ��ѯ��ѧ������:");
	scanf("%s",membername);
	while(p1!=NULL) 
	{
		if(strcmp(p1->name,membername)==0)
		{
			printf("             \n�ҵ���!");
			flag=1;
			printf("\t\t") ;
			printf("\n");
			printf("\n\n\t\t\t\t\tѧ������:%s\n",p1->name);
			printf("\n\n\t\t\t\t\tѧ������:%d\n",p1->number);
			printf("\n\n\t\t\t\t\tѧ���ܷ�:%d\n",p1->sum);
		}
		p1=p1->next;
		if(flag==0)
		{
			printf("û�ҵ���");
			
		}
	}
 } 
//����ѧ���������
void lookingnumber(struct xs *p)
{
	struct xs *p1=p->next;
	int haoma;
	int flag=0;
	printf("\n\n\t\t\t\t\t������Ҫ��ѯ��ѧ������:");
	scanf("%d",&haoma);
	while(p1!=NULL)
	{
		if(p1->number==haoma);
		{
			printf("             \n�ҵ���!");
			flag=1;
			printf("\t\t") ;
			printf("\n");
			printf("\n\n\t\t\t\t\tѧ������:%s\n",p1->name);
			printf("\n\n\t\t\t\t\tѧ������:%d\n",p1->number);
			printf("\n\n\t\t\t\t\tѧ���ܷ�:%d\n",p1->sum);
		}
		p1=p1->next;
		if(flag==0)
		{
			printf("û�ҵ���");
			
		}
	}
 }
//ɾ��(ɾ������) 
void shanchu1(struct xs *p0)
{
	char mingzi[10];
	int flag=0;
	printf("\n\n\t\t\t\t\t������Ҫɾ����ѧ������:");
	scanf("%s",mingzi);
	struct xs *p=p0;
	if(p==NULL)  printf("\n\n\t\t\t\t\t����Ϊ�գ��Ҳ���������");
	while(p->next!=NULL)
	{
		if(strcmp(p->next->name,mingzi)==0)
		{
			struct xs *q=p->next;
			p->next=q->next;
			free(q);
			printf("ɾ���ɹ�!");
			return;
		}
		p=p->next;
	}
	if(flag==0)
	{
		printf("\n\n\t\t\t\t\tδ�ҵ�ɾ���Ľڵ�");
		
	 } 
 }
//�޸�
void change(struct xs *p)
{
	int num2,choice; 
	char qiuyuan[20];
	struct xs *p1=p->next;
	printf("\n\n\t\t\t\t\t|                 �޸���Ϣ            |\n ");
	printf("\n\t\t\t\t\t|            1.ͨ��ѧ���������         |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|            2.ͨ��ѧ�����Ʋ���         |");
	printf("\n\t\t\t\t\t|_______________________________________|");
	printf("\n\t\t\t\t\t������ѡ��");
	scanf("%d",&choice);
	if(choice==1)
	{
		printf("\n\n\t\t\t\t\t������Ҫ�ı��ѧ������:");
		scanf("%d",&num2); 
		while(1)
		{
			if(p1==NULL)
			{
				printf("\n\n\t\t\t\t\t����Ϊ�գ����Ҳ���");
				break;
			}
			if(num2!=p1->number)
				p1=p1->next;
			else
			{
				printf("\n\n\t\t\t\t\t������Ҫ�޸ĵ�ѡ��:");
				printf("\n\t\t\t\t\t|          1.ѧ������                   |");
				printf("\n\t\t\t\t\t|                                       |");
				printf("\n\t\t\t\t\t|          2.ѧ������                   |");
				printf("\n\t\t\t\t\t|                                       |");
				printf("\n\t\t\t\t\t|          3.ѧ���÷�                   |");
				printf("\n\t\t\t\t\t|_______________________________________|"); 
				printf("\n\t\t\t\t\t�������޸���:");
				scanf("%d",&choice);
				printf("\t\t\t\t\t�������޸ĺ������:");
				switch(choice)
				{
					case 1:
						scanf("%s",p1->name);
						break;
					case 2:
						scanf("%d",&p1->number);	
						break;
					case 3:
						scanf("%d",&p1->sum);
						break;
				} 
				printf("\n\n\t\t\t\t\t�޸ĳɹ�!");
				break;
				
			}
			
		}
		 
	}
	if(choice==2)
	{
		printf("\n\n\t\t\t\t\t������Ҫ�ı��ѧ������:");
		scanf("%s",qiuyuan); 
		while(1)
		{
			if(p1==NULL)
			{
				printf("\n\n\t\t\t\t\t����Ϊ�գ����Ҳ���");
				break;
			}
			if(strcmp(p1->name,qiuyuan)==0)
				p1=p1->next;
			else
			{
				printf("\n\n\t\t\t\t\t������Ҫ�޸ĵ�ѡ��:");
				printf("\n\t\t\t\t\t|          1.ѧ������                   |");
				printf("\n\t\t\t\t\t|                                       |");
				printf("\n\t\t\t\t\t|          2.ѧ������                   |");
				printf("\n\t\t\t\t\t|                                       |");
				printf("\n\t\t\t\t\t|          3.ѧ���÷�                   |");
				printf("\n\t\t\t\t\t|_______________________________________|"); 
	  			printf("\n\t\t\t\t\t�������޸���:");
				scanf("%d",&choice);
				printf("\t\t\t\t\t�������޸ĺ������:");
				switch(choice)
				{
					case 1:
						scanf("%s",p1->name);
						break;
					case 2:
						scanf("%d",&p1->number);	
						break;
					case 3:
						scanf("%d",&p1->sum);
						break;
				} 
				printf("\n\n\t\t\t\t\t�޸ĳɹ�!");
				break;
				
			}
		}
	}	
	
 }
//д�ļ�
void writefile()
{
	FILE *user;
	user=fopen("xs.txt","w");
	struct xs *q=head->next;
	while(q!=NULL)
	{
		fprintf(user,"%s %d %d\n",q->name,q->number,q->sum);
		q=q->next;
	}
	fclose(user);	
 } 
 //���ļ� 
void readfile() 
{
	FILE *user;
	user=fopen("xs.txt","r");
	struct xs *temp,*p=head;
	if(user!=NULL)
	{
		while(!feof(user))
			{
			temp = (struct xs *)malloc(sizeof(struct xs));
			fscanf(user,"%s %d %d\n",
											temp->name,
											&temp->number,
											&temp->sum); //////// 
			p->next=temp;
			p=temp; 
			
		}
	}
	p->next=NULL;
	fclose(user);	
}
//��¼ 
void denglu()
{
	FILE *fp;
	int i=0;
	char ch;
	struct user a;
	char code[20];
	char name[20];
	int	flag=0;
	fp=fopen("userdata.txt","r");
	printf("\n\n\t\t\t\t\t              �û���¼         \n\n");
	if(fp== NULL)
	{
		printf("\n\n\t\t\t\t\t�ļ�Ϊ�գ�����ȥע��!");
		system("cls");
		printf("\n\n\t\t\t\t\t�Ƿ�ѡ��ȥע��(Y/N)");
		getchar();
		if(getchar() =='Y')////////////////
			zhuce();	//ת�Ƶ�ע�����	 
	}
	fclose(fp); 
	do
	{
		fp=fopen("userdata.txt","r");
		printf("\n\n\t\t\t\t\t  �������û���:");
		scanf("%s",name);
		printf("\n\n\t\t\t\t\t  ����������:");
		while((ch=getch())!='\r')
		{
			if(ch=='\b')
			{
				if(i!=0)
				{
					printf("\b \b");
				    i--;	
				}
			}
			else
			{
				putchar('*');
				code[i++]=ch;
			}
			
		}
		code[i]='\0';
		while(!feof(fp))
		{
			fscanf(fp,"%s %s\n",a.username,a.usermima);  //����    /////////////////
			if(strcmp(name,a.username)==0 && strcmp(code,a.usermima)==0)
			{
				flag=1;
				break;
			} 
		}
		fclose(fp);
		if(flag)
		{
			printf("  \n\n\t\t\t\t\t      ��½�ɹ���\n");
			Sleep(1000);
			break;
		}
		else
		{
			printf("\n\t\n\n\t\t\t\t\t����������벻��ȷ��\n");
			printf("\n\n\t\t\t\t\t�Ƿ�Ҫ������½?(Y/N)");
			fflush(stdin);
			ch=getchar();
			if(ch!='Y'){
				face();	
			}
				//����ԭ������ 		
		}
		
	}while(ch=='Y');
}
//ע��
void zhuce()
{
	
	FILE *fp;
	int i,j,flag=0;
	char ch,bh;
	struct user a;
	char name[20];
	char code1[20];
	char code2[20];
	while(1)
	{	
		printf("\n\n\t\t\t\t\t              ��ӭʹ��ѧ������ϵͳ!        \n\n");
		printf("\n\n\t\t\t\t\t                 �û�ע��     \n");
		printf("\n\n\t\t\t\t\t�������û�����");
		scanf("%s",name);
		fflush(stdin); /////////// 
		fp= fopen("userdata.txt","r");
		if(fp==NULL)
		{
			fp= fopen("userdata.txt","w");//////////////
			fclose(fp);
			fp= fopen("userdata.txt","r");
		}
		flag=0;
		while(!feof(fp))
		{
			fscanf(fp,"%s %s\n",a.username,a.usermima);//��                       /////// 
			if(strcmp(a.username,name)==0)
			{
				flag=1;
				break;
			}	
		}
		fclose(fp);
		if(flag==1)
		{
			printf("\n\n\n\n\n\t\t\t\t\t\t���û����Ѵ��ڣ�"); 
			Sleep(1000);
			system("cls");
		}
		else
		{
			
			while(1)
			{
				printf("\n\t\t\t\t\t���������룺  ");
				while((ch=getch())!='\r')
				{
					if(ch=='\b')
					{
						if(i!=0)
						{
							printf("\b \b");
						    i--;	
						}
					}
					else
					{
						putchar('*');
						code1[i++]=ch;
					}
				}
				code1[i]='\0';
				i=0;
				j=0;
				printf("\n\n\t\t\t\t\t��ȷ������:   "); 
				while((bh=getch())!='\r')
				{
					if(bh=='\b')
					{
						if(j!=0)
						{
							printf("\b \b");
						    j--;	
						}
					}
					else
					{
						putchar('*');
						code2[j++]=bh;
					}
					
				}
				code2[j]='\0';
				j=0;
				if(strcmp(code1,code2)==0)
				{
					fp = fopen("userdata.txt","a"); ///////////////
					fprintf(fp,"%s %s\n",name,code1);
					fclose(fp);
					break;
				}
			}
			printf("\n\n\n\t\t\t\t\t\t ע��ɹ���");
			printf("\n\n\t\t\t\t\t�Ƿ����ע��:(N)");
			fflush(stdin); 
			if(getchar()=='N')
				break;
			Sleep(1000);
			system("cls");
			
		}
	}
			
 } 
//��ӡ
void  print(struct xs *head) 
{
	struct xs *p1 = head->next;
	printf("\n\n\n\n\n");
	printf("\t\t") ;
	printf("ѧ������  ѧ�����  �÷���\n");
	while(p1 != NULL)
	{       
		printf("\n\t\t%-10s %-3d %-10d ",p1->name,p1->number,p1->sum);
		p1=p1->next;
	}
}             
		
//����
void charu(struct xs* p0)
{
	int i,j=1;
	char ch;
	struct xs *p,*p1,*p2;
	int count=tongji(p0);
	p=(struct xs*)malloc(sizeof(struct xs));
	printf("\n\n\t\t\t\t\t|           ��ӭʹ��ѧ������ϵͳ            |\n");
	do
	{	
		printf("\n\n\t\t\t\t\t��������Ҫ�����λ��:\t");
		scanf("%d",&i);
		if(i==1)  //ͷ��
		{ 
			addxs(p); 
			p->next=p0->next;
			p0->next=p;
			printf("\n\n\t\t\t\t\t��ӳɹ�!\n");	
		} 
		else if(i>=count) //β��
		{
			p1=p0;
			while(p1->next!=NULL)
			{
				p1=p1->next;
			}
			addxs(p); 
			p1->next=p;
			p->next=NULL;
			printf("\n\n\t\t\t\t\t��ӳɹ�!\n");	
		 } 
		else
		{
			p1=p0->next;
			p2=p1->next;
			while(p1!=NULL)
			{	
				p1=p1->next;
				p2=p2->next;
				j++; 
				if(j==i)
				{
					addxs(p); 
					p->next=p2;
					p1->next=p;
					printf("\n\n\t\t\t\t\t��ӳɹ�!\n");	
				}	
			}	
		}
		printf("\n\n\t\t\t\t\t�Ƿ�Ҫ�������:");
		fflush(stdin);
		ch=getchar();
		
	}while(ch=='Y' || ch=='N');
}
//������
int main()
{
	head->next =NULL;
	readfile();
	face();
	writefile();
 } 

