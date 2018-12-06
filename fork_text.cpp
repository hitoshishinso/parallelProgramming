/*Created By HitoshiShinso (Karan Kanojia) Date : October 2018 :: 9:14 AM :: Windows Operating System*/
#include <bits/stdc++.h>
#include <unistd.h>
#include <sys/wait.h>
#define MAX 11111
#define lim 1e9+7
#define ll long long 
#define SQRT 1060
#define sci(a) scanf("%d", &a)
#define scl(a) scanf("%lld", &a)
#define pfi(a) printf("%d\n", a)
#define pfl(a) printf("%lld\n", a)
#define pfcase(t) printf("Case #%d:\n",t)
#define pf(d) printf("%s\n",d)
#define mp make_pair
#define fi first
#define se second
#define pb push_back
#define vec vector<ll> ls
#define smap unordered_map <int,int> 
#define N 5

using namespace std ;


int main(){


	//File handling start 
	#ifndef ONLINE_JUDGE
	freopen("input.txt","r", stdin);
	freopen("output.txt", "w", stdout);
	#endif
	//File Handing ends 

    //Code starts from here

    pid_t chi1 = fork(), chi2 = fork(); 

    //4 banches = (1)Parent + (2)Children +(1) GrandChild
    int stable_counter = 0 ;
    /**/
    if(chi1 > 0 && chi2 > 0 ){
    	/*In Parent*/
    	cout << chi1 << " " << chi2 << " " << getpid() <<" "<<getppid() << endl;
    	for(int i=0; i<N; i++){
    		sleep(0.1);
    		cout << "parent :\t" << stable_counter++ << endl;
    	}
    }
    else if(chi1 == 0 && chi2 > 0){
    	/*In child One*/
    	cout << chi1 << " " << chi2 << " " << getpid() <<" "<<getppid() << endl;
    	for(int i=0; i<N; i++){
    		sleep(0.2);
    		cout << "child1 :\t" << stable_counter++ << endl;
    	}
    }
    else if(chi1 > 0 &&  chi2 == 0){
    	/*In child Two , chi2 called by parent */
    	cout << chi1 << " " << chi2 << " " << getpid() <<" "<<getppid() << endl;
    	for(int i=0; i<N; i++){
    		sleep(0.3);
    		cout << "child2 :\t" << stable_counter++ << endl;
    	}
    }
    else{
    	/*In grand Child, chi2 called by chi1*/
    	cout << chi1 << " " << chi2 << " " << getpid() <<" "<<getppid() << endl;
    	for(int i=0; i<N; i++){
    		sleep(0.5);
    		cout << "gChild :\t" << stable_counter++ << endl;
    	}
    }
    
}

