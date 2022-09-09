#include<iostream>
using namespace std;

int gcd(int a, int b){
	int c;
	while (b != 0)
	{
		c = a % b;
		a = b;
		b = c;
	}
	return a;
}

long long int lcm(int a, int b){
    return a * b / gcd(a, b);
}

int main(){
	int T;
	int M, N, x,y;
	cin >> T;
	while(T--){
		scanf("%d %d %d %d",&M,&N,&x,&y);
		long long int max=lcm(M,N);
		long long int i=x;
		for(;i<=max;i+=M){
			if(i%N==y){
				cout << i<<'\n';
				break;
			}
			else if(N==y && i%N==0){
				cout << i<<'\n';
				break;
			}
		}
		if(i>max)
			cout << -1<<'\n';
	}
}