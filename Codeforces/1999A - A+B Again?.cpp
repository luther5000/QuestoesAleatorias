#include <iostream>
#include <vector>
     
using namespace std;

int main(){
    int quant;
    cin >> quant;
    
	string linha;
	getline(cin, linha);
    for (int i = 0; i < quant; ++i){
		getline(cin, linha);

		cout << linha[0] - '0' + linha[1] - '0' << endl;

    }
    
    return 0;
}
