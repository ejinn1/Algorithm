// Run by Node.js
const readline = require('readline');

function solution(scores){
	const max = Math.max(...scores)
	const result = []
	for(let i=max ; i>=1 ; i--){
		if(scores.includes(i)){
			result.push(scores.indexOf(i) + 1)
		}
		if(result.length === 3){
			break
		}
	}
	
	return result.join(' ')
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
	
	const n = parseInt(lines[0], 0)
	const scores = lines[1].split(' ').map(Number)
	
	const result = solution(scores)
	console.log(result)
	
	process.exit();
})();
