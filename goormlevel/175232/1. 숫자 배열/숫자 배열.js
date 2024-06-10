// Run by Node.js
const readline = require('readline');

function print(k, n){
	let tmp = []
	for(let i=1 ; i<=n ; i++){
		tmp.push(k+i)
	}
	console.log(tmp.join(' '))
}

function solution(n){
	for(let i=0 ; i<n ; i++){
		print(n*i, n)
	}
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let n = null
	for await (const line of rl) {
		n = line
		rl.close();
	}

	solution(n)
	
	process.exit();
})();
