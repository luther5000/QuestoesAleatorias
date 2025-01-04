    #include <iostream>
    #include <string>
         
    using namespace std;
     
    int main(){
        int quant;
        cin >> quant;
        
    	string linha;
    	getline(cin, linha);
        for (int i = 0; i < quant; ++i){
    		getline(cin, linha);
     
    		for (int j = linha.size() - 1; j >= 0 ; --j){
    			switch (linha[j]) {
    			case 'p':
    				cout << 'q';
    				break;
    			
    			case 'q':
    				cout << 'p';
    				break;
     
    			case 'w':
    				cout << 'w';
    				break;
    			}
    		}
    		cout << endl;
        }
        
        return 0;
    }
