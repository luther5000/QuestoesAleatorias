#include <iostream>
    
using namespace std;


int main(){
    int quant;
    cin >> quant;

    for (int i = 0; i < quant; ++i){
        int n;
        cin >> n;

        int max = 0;
        int max_sum = 0;

        for (int j = 2; j <= n; ++j){
            int sum_atual = 0;

            for (int atual = j; atual <= n; atual += j){
                sum_atual += atual;
            }

            if (sum_atual > max_sum){
                max_sum = sum_atual;
                max = j;
            }

        }

        cout << max << endl;
    }
    
    return 0;
}
