#include<iostream>
#include<string>
#define endl '\n'
using namespace std;

int alpha[8]={0,};

int main(){
	string s;
	int length;
	int sets=1;
	int num;
	cin >> s;
	
	length = s.length();
	
	for(int i=0;i<length;i++){
		num=s.at(i)-'0';
		if(num==6 || num==9){
			alpha[6]+=1;
			if(2*sets<alpha[6])
				sets+=1;
		}
		else{
			alpha[num]+=1;
			if(sets<alpha[num])
				sets+=1;
		}
	}
	
	cout << sets;
}