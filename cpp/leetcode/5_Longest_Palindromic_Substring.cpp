#include <vector>
#include <iostream>
#include <string>

using namespace std;
int main()
{
	string s = "bcbbbb";
	int slen = s.size();

	int max_pal = 0;
	int l = 0; int r = 0;

	for (int i = 0; i < slen; i++) {
		int cur_pal = 0;
		while (i + cur_pal + 1 < slen and i - cur_pal >= 0 and
		 s[i - cur_pal] == s[i + cur_pal + 1]) {
			cur_pal++;
		}
		if (max_pal < cur_pal * 2) {
			max_pal = cur_pal * 2;
			l = i - cur_pal + 1;
			r = i + cur_pal;
		}
	}

	for (int i = 0; i < slen; i++) {
		int cur_pal = 0;
		while (i - 1 - cur_pal >= 0 and i + cur_pal + 1 < slen and
			s[i - cur_pal - 1] == s[i + cur_pal + 1]) {
			cur_pal++;
		}		
		if (max_pal < cur_pal  * 2 + 1) {
			max_pal = cur_pal * 2 + 1;
			l = i - cur_pal;
			r = i + cur_pal;
		}
	}


	cout << max_pal << endl;
	cout << s[l] << " to " << s[r] << endl;
	return 0;
}