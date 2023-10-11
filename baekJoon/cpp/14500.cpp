#include<iostream>
#include<utility>
using namespace std;

int N,M;
int paper[500][500];
int ans=-1;

int dx[4]={0,1,0,-1};
int dy[4]={1,0,-1,0};

void checkPaper(pair<int,int>startPoint, int pastCase, int size, int sum){
	if(size==4){
		if(ans<sum) ans=sum;
		return;
	}
	
	for(int i=0;i<4;i++){
		if(i==pastCase) continue;
		
		pair<int,int>nextPoint(startPoint.first+dy[i],startPoint.second+dx[i]);
		
		if(nextPoint.first<0 || nextPoint.first>=N
		  || nextPoint.second<0 || nextPoint.second>=M) continue;
		
		if(size==2){
			for(int j=1;j<=3;j++){
				if((i+j)%4==pastCase) continue;
				
				if(startPoint.first+dy[(i+j)%4] < 0 || startPoint.first+dy[(i+j)%4]>=N ||
				  startPoint.second+dx[(i+j)%4] < 0 || startPoint.second+dx[(i+j)%4]>=M) continue;
				checkPaper(startPoint,(i+2)%4,size+2, 
					   sum+paper[nextPoint.first][nextPoint.second]
					   +paper[startPoint.first+dy[(i+j)%4]][startPoint.second+dx[(i+j)%4]]);
			}
		}
		
		checkPaper(nextPoint,(i+2)%4,size+1,sum+paper[nextPoint.first][nextPoint.second]);
	}
}

int main(){
	cin >> N >> M;
	
	for(int i=0;i<N;i++)
		for(int j=0;j<M;j++)
			cin >> paper[i][j];
	
	for(int i=0;i<N;i++)
		for(int j=0;j<M;j++)
			checkPaper(pair<int,int>(i,j),-1,1,paper[i][j]);
	
	cout << ans<<endl;
}