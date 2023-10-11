#include<iostream>
#include<string>
#include<stack>
using namespace std;

int main(){
    stack<char> S;
    string input;
    char command;
    cin >> input;
    int ans=0;
    for(int i=0;i<input.length();i++){
        command=input[i];
        if(command=='('){
            S.push('(');
        }
        else {
            if(input[i-1]=='('){
                S.pop();
                ans+=S.size();
            }
            else{
                S.pop();
                ans+=1;
            }
        }
    }
    cout << ans;
}
