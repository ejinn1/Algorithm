// Run by Node.js
const readline = require('readline');

function solution(a, b){
	let a2 = a.split('').reverse().join('')
	let b2 = b.split('').reverse().join('')
	return a2 > b2 ? a : b
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	const lines = []
	for await (const line of rl) {
		lines.push(line)
		rl.close();
	}
	
	const data = lines[0].split(' ')
	let a = data[0]
	let b = data[1]
	
	let res = solution(a, b)
	console.log(res)
	
	process.exit();
})();
