#include <iostream>
    
using namespace std;


int main(){
    int quant;
    cin >> quant;
    string linha;

    getline(cin, linha);
    for (int i = 0; i < quant; ++i){
        getline(cin, linha);
        
        char a = linha[4];
        linha[4] = linha[0];
        linha[0] = a;

        cout << linha << endl;
    }
    
    return 0;
}
