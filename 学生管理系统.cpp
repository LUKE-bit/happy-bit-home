#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<windows.h>
#include<conio.h>
struct xs
{
	char name[20];
	int number;
	int sum;//总得分 
	struct xs *next;
 };
struct xs *head=(struct xs *)malloc(sizeof (struct xs));
 
//用户结构体
struct user
{
	char username[20];
	char usermima[20];
};
//初始化
void addxs(struct xs *p)
{
	printf("请输入学生名称：");
	fflush(stdin);
	gets(p->name);
	printf("请输入学生号码: ");
	scanf("%d",&p->number);
	printf("请输入学生总得分： ");
	scanf("%d",&p->sum); 
}

//界面系统
void face();
void face2();
void search();
void cutout();
//功能系统
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
 
//创建链表 
void create()
{
	int i=0;
	char ch;
	struct xs *pnew;
	do
	{
		system("cls");
		pnew=(struct xs*)malloc(sizeof(struct xs));
		printf("\n\n\t\t\t\t\t第%d学生的信息\n",++i);
		addxs(pnew);
	    pnew->next=head->next;
	    head->next=pnew;
		printf("\n\n\t\t\t\t\t是否继续添加学生信息?(Y/N)");
		getchar(); 
		ch=getchar(); //接收Y或y判断是否添加信息 
	}while(ch=='Y');
}
//统计学生总数
int tongji(struct xs *head)
{
	struct xs *p = head->next;
	int count=0;    //学生总数 
	while(p!= NULL)
	{
		count++;
		p=p->next;
	}
	return count;
}
 
 //首界面 
void face()                                           
{
    printf("\n\n\n\n\n\n");
    printf("                                  ********************************************\n");
    printf("                                  --------------------------------------------\n");
    printf("\n");
    printf("                                  |         欢迎使用学生管理系统          |\n");
    printf("\n");
    printf("                                  --------------------------------------------\n"); 
    printf("                                  |           1-登录                         |\n");
    printf("                                  |           2-注册                         |\n");
	printf("                                  |           3-退出系统                     |\n");
    printf("                                  ********************************************\n");
    printf("\n                                请先登录或注册"); 
    printf("\n\n\n");
    printf("请输入： ") ;
    fflush(stdin);
    int choice;
    scanf("%d",&choice);
    switch (choice)
    {
    	case 1:
    		system("cls");
    		denglu();                      //登录函数
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
void face2()                                           //打印界面 2
{
	int n;
    printf("\n\n\n");
    printf("                                  ********************************************\n");
    printf("                                  --------------------------------------------\n");
    printf("\n");
    printf("                                  |         欢迎使用学生管理系统          |\n");
    printf("\n");
    printf("                                  --------------------------------------------\n"); 
    printf("                                  |           1-信息录入                     |\n");
    printf("                                  |           2-查询学生信息                 |\n");
    printf("                                  |          *3-修改某个学生信息             |\n");
    printf("                                  |          *4-删除某个学生信息             |\n");
    printf("                                  |          *5-增添新学生信息               |\n");
    printf("                                  |           6-显示所有信息                 |\n"); 
    printf("                                  |           7-退出系统并保存信息           |\n"); 
    printf("                                  ********************************************\n");
    printf("\n\n\n");
    printf("请输入你的选择：\t");
    scanf("%d",&n);
    switch(n)
    {
    	case 1:
    		system("cls");
    		create();       //////////////////////// 
    		fflush(stdin);
    		printf("按任意键返回界面");
			getch();
			system("cls");
			face2();
			break;
		case 2:
			system("cls");
			search();
			fflush(stdin);
			printf("按任意键返回界面");
			getch();
			system("cls");
			face2();
			break; 
		case 3:
			system("cls");
			change(head);
			fflush(stdin);
			printf("按任意键返回界面");
			getch();
			system("cls");
			face2();
			break; 
		case 4:
			system("cls");
			cutout();
			fflush(stdin);
			printf("按任意键返回界面");
			getch();
			system("cls");
			face2();
			break;
		case 5:
			system("cls");
			charu(head);
			fflush(stdin);
			printf("按任意键返回界面");
			getch();
			system("cls");
			face2();
			break;  
		case 6:
			system("cls");
			print(head);
			fflush(stdin);
			printf("按任意键返回界面");
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
//查询功能页面
void search() 
{
	int choice;
	printf("\n\t\t\t\t\t                学生信息查询           \n");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|                                       |");
    printf("\n\t\t\t\t\t|         1.按照学生名称进行查询        |");
    printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|                                       |");
    printf("\n\t\t\t\t\t|         2.按照学生序号进行查询        |");
	printf("\n\t\t\t\t\t|                                       |"); 
    printf("\n\t\t\t\t\t|                                       |"); 
	printf("\n\t\t\t\t\t|         3.混合查询                    |"); 
	printf("\n\t\t\t\t\t|                                       |"); 
	printf("\n\t\t\t\t\t|                                       |");
    printf("\n\t\t\t\t\t|         4.退出                        |");
	printf("\n\t\t\t\t\t|                                       |"); 
	printf("\n\t\t\t\t\t|_______________________________________|"); 
	printf("\n\t\t\t\t\t请输入:");
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
//删除界面 
void cutout()
{
	int choice;
	printf("\n\n\t\t\t\t\t            学生信息删除              |\n"); 
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|         1.按照学生名称删除            |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|         2.返回上一层                  |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|_______________________________________|");
	printf("\n\t\t\t\t\t请选择:");
	scanf("%d",&choice);
	switch(choice)
	{
		case 1:
			system("cls");
			shanchu1(head);
			fflush(stdin);
			printf("\n\n\t\t\t\t\t按任意键返回功能界面\n");
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
//排序页面
void sort()
{
	int choice;
	printf("\n\n\t\t\t\t\t                学生信息排序              \n");
	printf("\n\t\t\t\t\t|          1.按照学生总得分排序         |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|          2.返回上一层                 |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|_______________________________________|");
	printf("\n\t\t\t\t\t请输入:");
	scanf("%d",&choice);
	switch(choice)
	{
		case 1:
			system("cls");
			
			fflush(stdin);
			printf("\n\n\t\t\t\t\t按任意键返回排序界面\n");
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
//按球员总得分排序
void sumpaixu(struct xs* head)
{
	int choice,count=0,i,j;
	struct xs *p1=head,*p2,*temp,*t;
	printf("\n\t\t\t\t\t            按照学生总得分排序        \n ");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|           1.升序                      |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|           2.降序                      |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|           3.返回上一层                |"); 
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|           4.退出                      |");
	printf("\n\t\t\t\t\t|_______________________________________|");
	printf("\n\t\t\t\t\t请选择:");
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
				printf("\n\n\t\t\t\t\t正序排列为:");
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
				printf("\n\n\t\t\t\t\t逆序排列为:");
				print(head);		
			}
			break;
		case 3:
			system("cls");
			fflush(stdin);
			printf("\n\n\t\t\t\t\t按任意键返回上一层\n");
			getch(); 
			system("cls");	
			sort();
				break;
		default:
			break;
	}
}
	


//根据学生名称及号码混合查找
void mixlooking(struct xs *p)
{
	char membername[20];
	int haoma;
	int flag=0;
	struct xs *p1=p->next;
	printf("\n\n\t\t\t\t\t请输入学生姓名");
	fflush(stdin);
	gets(membername);
	printf("\n\n\t\t\t\t\t请输入学生号码");
	fflush(stdin);
	scanf("%d",&haoma);
	while(p1->next!=NULL)
	{
		if(strcmp(p1->name,membername)==0 && p1->number==haoma)
		{
			printf("             \n找到了!");
			flag=1;
			printf("\n\n\t\t\t\t\t%d\n",p1->number);
			printf("\n\n\t\t\t\t\t%s\n",p1->name);
			printf("\n\n\t\t\t\t\t%d\n",p1->sum);
			
		}
		p1=p1->next;
	}
	if(flag==0)
	{
		printf("没找到！");
		
	}
 } 
//根据xs名称查找
void lookingname(struct xs *p)
{
	struct xs *p1=p->next;
	char membername[20];
	int flag=0;
	printf("\n\n\t\t\t\t\t请输入要查询的学生姓名:");
	scanf("%s",membername);
	while(p1!=NULL) 
	{
		if(strcmp(p1->name,membername)==0)
		{
			printf("             \n找到了!");
			flag=1;
			printf("\t\t") ;
			printf("\n");
			printf("\n\n\t\t\t\t\t学生名称:%s\n",p1->name);
			printf("\n\n\t\t\t\t\t学生号码:%d\n",p1->number);
			printf("\n\n\t\t\t\t\t学生总分:%d\n",p1->sum);
		}
		p1=p1->next;
		if(flag==0)
		{
			printf("没找到！");
			
		}
	}
 } 
//根据学生号码查找
void lookingnumber(struct xs *p)
{
	struct xs *p1=p->next;
	int haoma;
	int flag=0;
	printf("\n\n\t\t\t\t\t请输入要查询的学生号码:");
	scanf("%d",&haoma);
	while(p1!=NULL)
	{
		if(p1->number==haoma);
		{
			printf("             \n找到了!");
			flag=1;
			printf("\t\t") ;
			printf("\n");
			printf("\n\n\t\t\t\t\t学生名称:%s\n",p1->name);
			printf("\n\n\t\t\t\t\t学生号码:%d\n",p1->number);
			printf("\n\n\t\t\t\t\t学生总分:%d\n",p1->sum);
		}
		p1=p1->next;
		if(flag==0)
		{
			printf("没找到！");
			
		}
	}
 }
//删除(删除名称) 
void shanchu1(struct xs *p0)
{
	char mingzi[10];
	int flag=0;
	printf("\n\n\t\t\t\t\t请输入要删除的学生名称:");
	scanf("%s",mingzi);
	struct xs *p=p0;
	if(p==NULL)  printf("\n\n\t\t\t\t\t链表为空，找不到此人物");
	while(p->next!=NULL)
	{
		if(strcmp(p->next->name,mingzi)==0)
		{
			struct xs *q=p->next;
			p->next=q->next;
			free(q);
			printf("删除成功!");
			return;
		}
		p=p->next;
	}
	if(flag==0)
	{
		printf("\n\n\t\t\t\t\t未找到删除的节点");
		
	 } 
 }
//修改
void change(struct xs *p)
{
	int num2,choice; 
	char qiuyuan[20];
	struct xs *p1=p->next;
	printf("\n\n\t\t\t\t\t|                 修改信息            |\n ");
	printf("\n\t\t\t\t\t|            1.通过学生号码查找         |");
	printf("\n\t\t\t\t\t|                                       |");
	printf("\n\t\t\t\t\t|            2.通过学生名称查找         |");
	printf("\n\t\t\t\t\t|_______________________________________|");
	printf("\n\t\t\t\t\t请输入选择：");
	scanf("%d",&choice);
	if(choice==1)
	{
		printf("\n\n\t\t\t\t\t请输入要改变的学生号码:");
		scanf("%d",&num2); 
		while(1)
		{
			if(p1==NULL)
			{
				printf("\n\n\t\t\t\t\t链表为空，查找不到");
				break;
			}
			if(num2!=p1->number)
				p1=p1->next;
			else
			{
				printf("\n\n\t\t\t\t\t请输入要修改的选项:");
				printf("\n\t\t\t\t\t|          1.学生名称                   |");
				printf("\n\t\t\t\t\t|                                       |");
				printf("\n\t\t\t\t\t|          2.学生号码                   |");
				printf("\n\t\t\t\t\t|                                       |");
				printf("\n\t\t\t\t\t|          3.学生得分                   |");
				printf("\n\t\t\t\t\t|_______________________________________|"); 
				printf("\n\t\t\t\t\t请输入修改项:");
				scanf("%d",&choice);
				printf("\t\t\t\t\t请输入修改后的内容:");
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
				printf("\n\n\t\t\t\t\t修改成功!");
				break;
				
			}
			
		}
		 
	}
	if(choice==2)
	{
		printf("\n\n\t\t\t\t\t请输入要改变的学生名称:");
		scanf("%s",qiuyuan); 
		while(1)
		{
			if(p1==NULL)
			{
				printf("\n\n\t\t\t\t\t链表为空，查找不到");
				break;
			}
			if(strcmp(p1->name,qiuyuan)==0)
				p1=p1->next;
			else
			{
				printf("\n\n\t\t\t\t\t请输入要修改的选项:");
				printf("\n\t\t\t\t\t|          1.学生名称                   |");
				printf("\n\t\t\t\t\t|                                       |");
				printf("\n\t\t\t\t\t|          2.学生号码                   |");
				printf("\n\t\t\t\t\t|                                       |");
				printf("\n\t\t\t\t\t|          3.学生得分                   |");
				printf("\n\t\t\t\t\t|_______________________________________|"); 
	  			printf("\n\t\t\t\t\t请输入修改项:");
				scanf("%d",&choice);
				printf("\t\t\t\t\t请输入修改后的内容:");
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
				printf("\n\n\t\t\t\t\t修改成功!");
				break;
				
			}
		}
	}	
	
 }
//写文件
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
 //读文件 
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
//登录 
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
	printf("\n\n\t\t\t\t\t              用户登录         \n\n");
	if(fp== NULL)
	{
		printf("\n\n\t\t\t\t\t文件为空，请先去注册!");
		system("cls");
		printf("\n\n\t\t\t\t\t是否选择去注册(Y/N)");
		getchar();
		if(getchar() =='Y')////////////////
			zhuce();	//转移到注册界面	 
	}
	fclose(fp); 
	do
	{
		fp=fopen("userdata.txt","r");
		printf("\n\n\t\t\t\t\t  请输入用户名:");
		scanf("%s",name);
		printf("\n\n\t\t\t\t\t  请输入密码:");
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
			fscanf(fp,"%s %s\n",a.username,a.usermima);  //读出    /////////////////
			if(strcmp(name,a.username)==0 && strcmp(code,a.usermima)==0)
			{
				flag=1;
				break;
			} 
		}
		fclose(fp);
		if(flag)
		{
			printf("  \n\n\t\t\t\t\t      登陆成功！\n");
			Sleep(1000);
			break;
		}
		else
		{
			printf("\n\t\n\n\t\t\t\t\t您输入的密码不正确！\n");
			printf("\n\n\t\t\t\t\t是否要继续登陆?(Y/N)");
			fflush(stdin);
			ch=getchar();
			if(ch!='Y'){
				face();	
			}
				//返回原来界面 		
		}
		
	}while(ch=='Y');
}
//注册
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
		printf("\n\n\t\t\t\t\t              欢迎使用学生管理系统!        \n\n");
		printf("\n\n\t\t\t\t\t                 用户注册     \n");
		printf("\n\n\t\t\t\t\t请输入用户名：");
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
			fscanf(fp,"%s %s\n",a.username,a.usermima);//读                       /////// 
			if(strcmp(a.username,name)==0)
			{
				flag=1;
				break;
			}	
		}
		fclose(fp);
		if(flag==1)
		{
			printf("\n\n\n\n\n\t\t\t\t\t\t该用户名已存在！"); 
			Sleep(1000);
			system("cls");
		}
		else
		{
			
			while(1)
			{
				printf("\n\t\t\t\t\t请输入密码：  ");
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
				printf("\n\n\t\t\t\t\t请确认密码:   "); 
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
			printf("\n\n\n\t\t\t\t\t\t 注册成功！");
			printf("\n\n\t\t\t\t\t是否继续注册:(N)");
			fflush(stdin); 
			if(getchar()=='N')
				break;
			Sleep(1000);
			system("cls");
			
		}
	}
			
 } 
//打印
void  print(struct xs *head) 
{
	struct xs *p1 = head->next;
	printf("\n\n\n\n\n");
	printf("\t\t") ;
	printf("学生姓名  学生编号  得分数\n");
	while(p1 != NULL)
	{       
		printf("\n\t\t%-10s %-3d %-10d ",p1->name,p1->number,p1->sum);
		p1=p1->next;
	}
}             
		
//插入
void charu(struct xs* p0)
{
	int i,j=1;
	char ch;
	struct xs *p,*p1,*p2;
	int count=tongji(p0);
	p=(struct xs*)malloc(sizeof(struct xs));
	printf("\n\n\t\t\t\t\t|           欢迎使用学生管理系统            |\n");
	do
	{	
		printf("\n\n\t\t\t\t\t请输入你要插入的位置:\t");
		scanf("%d",&i);
		if(i==1)  //头插
		{ 
			addxs(p); 
			p->next=p0->next;
			p0->next=p;
			printf("\n\n\t\t\t\t\t添加成功!\n");	
		} 
		else if(i>=count) //尾插
		{
			p1=p0;
			while(p1->next!=NULL)
			{
				p1=p1->next;
			}
			addxs(p); 
			p1->next=p;
			p->next=NULL;
			printf("\n\n\t\t\t\t\t添加成功!\n");	
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
					printf("\n\n\t\t\t\t\t添加成功!\n");	
				}	
			}	
		}
		printf("\n\n\t\t\t\t\t是否要继续添加:");
		fflush(stdin);
		ch=getchar();
		
	}while(ch=='Y' || ch=='N');
}
//主函数
int main()
{
	head->next =NULL;
	readfile();
	face();
	writefile();
 } 

