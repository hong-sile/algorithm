#include<iostream>
#include<utility>
#include<string>
using namespace std;

int video[64][64];
string ans;

void checkVideo(int size, pair<int,int> startPoint){
	
	int checkSum=0;
	
	for(int i=startPoint.first ; i<startPoint.first+size ; i++)
		for(int j=startPoint.second ; j<startPoint.second+size ; j++)
			if(video[i][j]==1) checkSum+=1;
	
	if(checkSum==0) ans+="0";
	else if(checkSum==size*size) ans+="1";
	else{
		ans+="(";
		checkVideo(size/2,startPoint);
		checkVideo(size/2,pair<int,int>(startPoint.first,startPoint.second+size/2));
		checkVideo(size/2,pair<int,int>(startPoint.first+size/2,startPoint.second));
		checkVideo(size/2,pair<int,int>(startPoint.first+size/2,startPoint.second+size/2));
		ans+=")";
	}
	
}

int main(){
	int N;
	string input;
	cin >> N;
	
	for(int i=0;i<N;i++){
		cin >> input;
		for(int j=0;j<input.size();j++)
			video[i][j]=input[j]-'0';
	}
	
	
	checkVideo(N,pair<int,int>(0,0));
	
	cout << ans;
	
}