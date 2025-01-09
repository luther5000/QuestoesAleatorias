#include <iostream>
#include <vector>
     
using namespace std;

int main(){
    int quant;
    cin >> quant;
    
    for (int i = 0; i < quant; ++i){
		int numLinha;
		string linha;

		cin >> numLinha;
		getline(cin, linha);

		vector<int> nota(numLinha);

		for (int j = 1; j <= numLinha; ++j){
			getline(cin, linha);
			nota[numLinha - j] = linha.find_first_of("#") + 1;
		}

		for (int j = 0; j < numLinha; ++j)
			if (j != numLinha - 1)
				cout << nota[j] << " ";
			else 
				cout << nota[j];
		
		cout << endl;
    }
    
    return 0;
}
