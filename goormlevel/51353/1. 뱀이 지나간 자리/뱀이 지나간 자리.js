// Run by Node.js
const readline = require('readline');

function solution(n, m){
	let shap = ""
	for(let i=0 ; i<m ; i++){
		shap += '#'
	}
	let point = ""
	for(let i=0 ; i<m-1 ; i++){
		point += '.'
	}
	let f = true
	for(let i=0 ; i<n ; i++){
		if(i%2 === 0){
			console.log(shap)
		} else {
			if(f){
				console.log(point+"#")
				f = false
			} else {
				console.log("#"+point)
				f = true
			}
		}
	}
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let data = ""
	for await (const line of rl) {
		data = line
		rl.close();
	}
	
	let [n, m] = data.split(' ')
	solution(n, m)
	
	process.exit();
})();
