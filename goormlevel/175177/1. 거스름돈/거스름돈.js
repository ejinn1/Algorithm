// Run by Node.js
const readline = require('readline');

function solution(cash){
	let cnt = 0
	const coin = [40, 20, 10, 5, 1]
	for(let c of coin){
		if(cash >= c){
			cnt += parseInt(cash / c)
			cash %= c
		}
	}
	
	return cnt
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let lines = []
	for await (const line of rl) {
		lines.push(line)
		rl.close();
	}
	const res = solution(lines[0])
	console.log(res)
	process.exit();
})();
