        #include <iostream>
        #include <vector>
         
        using namespace std;
         
        int main() {
        	int n;
        	cin >> n;
        	
        	for (int i = 0; i < n; ++i){
        		int tam, k;
        		cin >> tam;
        		cin >> k;
        		vector<int> vetor(tam);
        
                int j = 1;
                int indice = k - 1;
        		while (indice < tam){
                    vetor[indice] = j++;
                    indice += k;
                }
     
                for (indice = 0; indice < tam; ++indice){
                    if (vetor[indice] != 0)
                        continue;
     
                    vetor[indice] = j++;    
                } 
        	
        			
        		for (int j = 0; j < tam; ++j){
        			if (j != tam - 1)
        				cout << vetor[j] << " ";
        			else
        				cout << vetor[j] << endl;
        			
        		}
        	}
        	
        	return 0;
        }
