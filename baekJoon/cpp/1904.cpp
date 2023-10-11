#include<iostream>
using namespace std;

int N;
int ans[1000000];

int main(){
    cin >> N;
    
    ans[0] = 0;
    ans[1] = 1;
    ans[2] = 2;

    for(int i = 3; i <= N; i++){
        ans[i] = ans[i-2] + ans[i-1];
        ans[i] = ans[i] % 15746;
    }

    cout << ans[N];
}