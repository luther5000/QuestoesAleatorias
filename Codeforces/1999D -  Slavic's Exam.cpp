#include <iostream>
#include <vector>
     
using namespace std;

int main(){
    int quant;
    cin >> quant;
    
	string linha;
	getline(cin, linha);

    for (int i = 0; i < quant; ++i){
		string subsequencia;
		getline(cin, linha);
		getline(cin, subsequencia);

		if (subsequencia.size() > linha.size()){
			cout << "NO" << endl;
			continue;
		}

		int k = 0;
		int j = 0;
		for (; j < linha.size(); ++j){
			if (k == subsequencia.size()){
				break;
			}

			if (linha[j] == subsequencia[k]){
				++k;
				continue;
			}

			if (linha[j] == '?'){
				linha[j] = subsequencia[k];
				++k;
			}
		}

		if (k == subsequencia.size()){
			cout << "YES" << endl;

			for (int l = 0; l < linha.size(); ++l){
				if (linha[l] == '?')
					cout << 'a';
				else 
					cout << linha[l];
			}

			cout << endl;
		} else
			cout << "NO" << endl;
    }
    
    return 0;
}
