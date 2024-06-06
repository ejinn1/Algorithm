// Run by Node.js
const readline = require('readline');

function solution(N, c, times){
	let cnt = 1
	for(let i=1 ; i<times.length ; i++){
		if(times[i] - times[i-1] <= c) cnt ++
		else cnt = 1
	}
	
	return cnt
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let lines = []
	for await (const line of rl) {
		lines.push(line)
		if(lines.length === 2){
			rl.close();
		}
	}
	
	let [N, c] = lines[0].split(' ')
	let times = lines[1].split(' ')
		
	let res = solution(N, c, times)
	console.log(res)
	
	process.exit();
})();
