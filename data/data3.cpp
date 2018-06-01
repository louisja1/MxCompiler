#include <cstdio>
#include <cstring>
#include <algorithm>
#include <iostream>

using namespace std;

int main() {
    freopen("3.mx", "w", stdout);
    srand(time(0));

    cout << "int main() {" << endl;

    for (int j = 0; j < 3; j++) {
        cout << "   string " << char('a' + j) << " = \"";
        for (int i = 0; i < 20; i ++) {
            int a = rand() % 7; // 4 : \n  5 : \\  6 : \"
            if (a < 4) {
                cout << char('a' + a);
            } else if (a == 4) {
                cout << "\\" << "n";
            } else if (a == 5) {
                cout << "\\" << "\\";
            } else if (a == 6) {
                cout << "\\" << "\"";
            }
        }
        cout << "\";" << endl;
    }

    for (int i = 0; i < 10; i++) {
        cout << "   print(";
        for (int j = 0; j < 10; j++) {
            if (j > 0) {
                cout << " + ";
            }
            cout << char('a' + rand() % 3);
        }
        cout << ");" << endl;
    }
    cout << "   return 0;" << endl;
    cout << "}" << endl;

    fclose(stdout);
    return 0;
}
