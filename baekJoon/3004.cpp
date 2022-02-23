#include <iostream>
using namespace std;

int main(){
    int N, piece = 1,  increase= 1;
    cin>>N;
    for(int i = 0; i < N; i++){
        if(i%2 != 0){
            increase += 1;
        }
        piece += increase;
    }
    cout<<piece;
    return 0;
}