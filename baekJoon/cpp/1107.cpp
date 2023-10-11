#include<iostream>
#include<string>
using namespace std;

int N,M;
bool buggedButton[10];

bool checkCanRemote(int goal){
	if(goal==0 && buggedButton[0])
		return false;
	while(goal!=0){
		if(buggedButton[goal%10]) return false;
		goal=goal/10;
	}
	
	return true;
}

int checkLength(int temp){
	int length=0;
	if(temp==0) return 1;
	while(temp!=0){
		temp=temp/10;
		length+=1;
	}
	return length;
}

int main(){
	int button;
	int ans=500000;
	int cnt=0;
	cin >> N >> M;
	int length;
	
	for(int i=0;i<M;i++){
		scanf("%d",&button);
		buggedButton[button]=true;
	}
	
	while(1){
		if(100+cnt==N || 100-cnt==N){
			ans=(cnt<ans)?cnt:ans;
			break;
		}
		if(N-cnt>=0 && checkCanRemote(N-cnt)){
			length=checkLength(N-cnt);
			ans=(cnt+length<ans)?cnt+length:ans;
		}
		if(checkCanRemote(N+cnt)){
			length=checkLength(N+cnt);
			ans=(cnt+length<ans)?cnt+length:ans;
		}
		cnt+=1;
	}
	cout << ans;
}