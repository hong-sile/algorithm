#include<iostream>
#include<stack>
using namespace std;

int arr[20][20];
int pastStates[5][20][20];
int arraySize;
int ans;

void restoreState(int cnt){
	for(int i=0;i<arraySize;i++)
		for(int j=0;j<arraySize;j++)
			arr[i][j]=pastStates[cnt][i][j];
}

void storeState(int cnt){
	for(int i=0;i<arraySize;i++)
		for(int j=0;j<arraySize;j++)
			pastStates[cnt][i][j]=arr[i][j];
}

void moveLeft(){
	for(int i=0;i<arraySize;i++){
		bool isMerged[20];
		for(int j=0;j<arraySize;j++)
			isMerged[j]=false;
		for(int j=1;j<arraySize;j++){
			if(arr[i][j]==0) continue;
			for(int k=j-1;k>=0;k--){
				if(k==0 && arr[i][k]==0)
					arr[i][k]=arr[i][j];
				else if(arr[i][k]==0) continue;
				else if(arr[i][k]==arr[i][j] && !isMerged[k]){
					arr[i][k]=arr[i][k]*2;
					isMerged[k]=true;
				}
				else{
					arr[i][k+1]=arr[i][j];
					if(k+1==j)
						break;
				}
				
				arr[i][j]=0;
					
				break;
			}
		}
	}
}

void moveRight(){
	for(int i=0;i<arraySize;i++){
		bool isMerged[20];
		for(int j=0;j<arraySize;j++)
			isMerged[j]=false;
		for(int j=arraySize-2;j>=0;j--){
			if(arr[i][j]==0) continue;
			for(int k=j+1;k<arraySize;k++){
				if(k==arraySize-1 && arr[i][k]==0)
					arr[i][k]=arr[i][j];
				else if(arr[i][k]==0) continue;
				else if(arr[i][k]==arr[i][j] && !isMerged[k]){
					arr[i][k]=arr[i][k]*2;
					isMerged[k]=true;
				}
				else{
					arr[i][k-1]=arr[i][j];
					if(k-1==j)
						break;
				}
				
				arr[i][j]=0;
					
				break;
			}
		}
	}
}

void moveUp(){
	for(int i=0;i<arraySize;i++){
		bool isMerged[20];
		for(int j=0;j<arraySize;j++)
			isMerged[j]=false;
		for(int j=1;j<arraySize;j++){
			if(arr[j][i]==0) continue;
			for(int k=j-1;k>=0;k--){
				if(k==0 && arr[k][i]==0)
					arr[k][i]=arr[j][i];
				else if(arr[k][i]==0) continue;
				else if(arr[k][i]==arr[j][i] && !isMerged[k]){
					arr[k][i]=arr[k][i]*2;
					isMerged[k]=true;
				}
				else{
					arr[k+1][i]=arr[j][i];
					if(k+1==j)
						break;
				}
				
				arr[j][i]=0;
					
				break;
			}
		}
	}
}

void moveDown(){
	for(int i=0;i<arraySize;i++){
		bool isMerged[20];
		for(int j=0;j<arraySize;j++)
			isMerged[j]=false;
		for(int j=arraySize-2;j>=0;j--){
			if(arr[j][i]==0) continue;
			for(int k=j+1;k<arraySize;k++){
				if(k==arraySize-1 && arr[k][i]==0)
					arr[k][i]=arr[j][i];
				else if(arr[k][i]==0) continue;
				else if(arr[k][i]==arr[j][i] && !isMerged[k]){
					arr[k][i]=arr[k][i]*2;
					isMerged[k]=true;
				}
				else{
					arr[k-1][i]=arr[j][i];
					if(k-1==j)
						break;
				}
				
				arr[j][i]=0;
					
				break;
			}
		}
	}
}

void backTrack(int cnt){
	if(cnt==5){
		for(int i=0;i<arraySize;i++)
			for(int j=0;j<arraySize;j++)
				ans=(ans>arr[i][j])?ans:arr[i][j];
	}
	else{
		storeState(cnt);
		moveLeft();
		backTrack(cnt+1);
		restoreState(cnt);
		
		moveRight();
		backTrack(cnt+1);
		restoreState(cnt);
		
		moveUp();
		backTrack(cnt+1);
		restoreState(cnt);
		
		moveDown();
		backTrack(cnt+1);
		restoreState(cnt);
		
	}
}

int main(){
	scanf("%d", &arraySize);
	
	for(int i=0;i<arraySize;i++)
		for(int j=0;j<arraySize;j++){
			scanf("%d", &arr[i][j]);
		}
	
	
	backTrack(0);
	cout << ans;

	/*
	moveDown();
	for(int i=0;i<arraySize;i++){
		for(int j=0;j<arraySize;j++)
			cout << arr[i][j] << " ";
		cout << endl;
	}
	*/
}